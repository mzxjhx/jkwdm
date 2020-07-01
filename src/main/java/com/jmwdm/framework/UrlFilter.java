package com.jmwdm.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
/* 
 * HP
 * 2020年6月9日-下午4:16:29
 * 定义过滤器
 */
@WebFilter
@Configuration
public class UrlFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(UrlFilter.class);
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
				
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		//允许跨域
		//response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Credentials","true");
	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		logger.info("token={}", request.getParameter("token"));
		logger.info(request.getRequestURI());
        chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
