package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response
			, FilterChain chain)
			throws IOException, ServletException {
		
		//System.out.println(">CharacterEncodingFilter.doFilter()ȣ��");
		
		//request.setCharacterEncoding("UTF-8");
		// UTF-8���� �ٸ��� ����� ��츦 ���� web.xml ���� �ֱ�
		request.setCharacterEncoding(this.encoding);
		
		chain.doFilter(request, response); //���� ���� �̵�
		
	}

	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.encoding= filterConfig.getInitParameter("encoding");
		if(this.encoding==null) this.encoding = "UTF-8";
		}
  //��� ������Ʈ ȣ��� ���� �ö�
}