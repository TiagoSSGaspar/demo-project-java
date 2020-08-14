package br.com.tiago.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AbsFilter {
	
	protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest httpReq) throws ServletException, IOException {
		RequestDispatcher dispatcher = httpReq.getRequestDispatcher("Login.jsf");
		dispatcher.forward(request, response);
	}
	
	protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest httpReq) throws ServletException, IOException {
		RequestDispatcher dispatcher = httpReq.getRequestDispatcher("AcessoNegado.jsf");
		dispatcher.forward(request, response);
	}
}
