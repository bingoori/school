package com.movie.web.jquery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Separate;

/**
 * Servlet implementation class JqController
 */
@WebServlet({"/jquery/attr.do","/jquery/core.do","/jquery/dom.do","/jquery/event.do","/jquery/selector.do","/jquery/traversing.do"})
public class JqController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DispatcherServlet.go(request, response, CommandFactory.createCommand(Separate.getValidityUrl(request).get(0),Separate.getValidityUrl(request).get(1)).getView());
	}

}
