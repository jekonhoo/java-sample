package com.bossien.web.logging;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {

		log.info(request.getRequestURI());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}


//@Component
//@Slf4j
//public class LoggingInterceptor implements HandlerInterceptor {
//
//	@Override
//	public boolean preHandle(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			Object handler
//	) throws Exception {
//		log.info("sss");
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
//}
