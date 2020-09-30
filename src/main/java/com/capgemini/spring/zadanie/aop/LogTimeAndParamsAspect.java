package com.capgemini.spring.zadanie.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogTimeAndParamsAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogTimeAndParamsAspect.class);

	@Around("@annotation(LogTimeAndParams)")
	public void logTimeAndParams(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Method: {} executed in {} ms.", joinPoint, timeTaken);

		logParams(joinPoint);
	}

	private void logParams(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		if (args.length == 0) {
			logger.info("Method {} takes no parameters", joinPoint);
		} else {
			StringBuilder sb = new StringBuilder("Method {} takes following parameters: ");
			for (int i = 0; i < args.length; i++) {
				sb.append(args[i]);
				if (i != args.length - 1) {
					sb.append(", ");
				}
			}
			logger.info(sb.toString(), joinPoint);
		}
	}
}
