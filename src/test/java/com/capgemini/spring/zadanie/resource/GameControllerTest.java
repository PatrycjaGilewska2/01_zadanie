package com.capgemini.spring.zadanie.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.capgemini.spring.zadanie.domain.dto.BoardGameDTO;
import com.capgemini.spring.zadanie.service.core.BoardGameManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

	@MockBean
	private BoardGameManagementService boardGameManagementService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldFindAllGames() throws Exception {
		// given
		BoardGameDTO boardGame = new BoardGameDTO(1L, "Taboo");
		Mockito.when(boardGameManagementService.findAll()).thenReturn(Arrays.asList(boardGame));
		// when
		ResultActions response = this.mockMvc
				.perform(get("/games").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON));
		// then
		response.andExpect(status().isOk()).andExpect(jsonPath("[0].id").value(boardGame.getId()))
				.andExpect(jsonPath("[0].gameName", is(boardGame.getGameName())));
	}

	@Test
	public void shouldAddGame() throws Exception {
		// given
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		// when
		ResultActions resultActions = mockMvc.perform(post("/games/add/Taboo"));
		// then
		resultActions.andExpect(status().isOk());
		Mockito.verify(boardGameManagementService).addGame(captor.capture());
		assertEquals("Taboo", captor.getValue());
	}

	@Test
	public void shouldAddGameToDatabase() throws Exception {
		// given
		BoardGameDTO boardGame = new BoardGameDTO(null, "Taboo");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(boardGame);
		// when
		ResultActions resultActions = mockMvc.perform(post("/games/add").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
		// then
		resultActions.andExpect(status().isOk());
		Mockito.verify(boardGameManagementService).addGame(captor.capture());
		assertEquals("Taboo", captor.getValue());
	}

}
