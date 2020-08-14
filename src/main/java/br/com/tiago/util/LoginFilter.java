package br.com.tiago.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tiago.model.Pessoa;

public class LoginFilter extends AbsFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Pessoa user = null;
		HttpSession sess = ((HttpServletRequest) request).getSession(false);

		if (sess != null) {
			user = (Pessoa) sess.getAttribute("user");
		}

		if (user == null) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/pages/Login.jsf");
		} else {
			chain.doFilter(request, response);
		}

	}

}