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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* 
 * HP
 * 2020年6月9日-下午4:16:29
 * 定义过滤器
 */
@WebFilter
public class UrlFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(UrlFilter.class);
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
				
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("token={}", req.getParameter("token"));
		logger.info(req.getRequestURI());
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
