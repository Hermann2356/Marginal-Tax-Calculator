package com.learning.j10.web;

import static com.learning.j10.utilities.Utility.isNull;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.j10.model.ABC;
import com.learning.j10.services.ABCService;

/**
 * Servlet implementation class ABCWeb
 */
public class ABCWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;

	
	protected void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getRequestDispatcher
		/*
		 * 
		 * Returns a RequestDispatcher object that acts as a wrapper for the resource
		 * located at the given path. A RequestDispatcher object can be used to forward
		 * a request to the resource or to include the resource in a response. The
		 * resource can be dynamic or static.
		 * 
		 */

		/*
		 * 
		 * The pathname specified may be relative, although it cannot extend outside the
		 * current servlet context. If the path begins with a "/" it is interpreted as
		 * relative to the current context root. This method returns null if the servlet
		 * container cannot return a RequestDispatcher.
		 *
		 *
		 * The difference between this method and ServletContext.getRequestDispatcher is
		 * that this method can take a relative path.
		 *
		 *
		 * Parameters: path a String specifying the pathname to the resource. If it is
		 * relative, it must be relative against the current servlet.
		 *
		 *
		 * Returns: a RequestDispatcher object that acts as a wrapper for the resource
		 * at the specifed path, or null if the servlet container cannot return a
		 * RequestDispatcher
		 * 
		 * 
		 */
		
		String author = isNull(request::getParameter, "author", "Hermann Sterling");
		String displayMode = isNull(request::getParameter, "displaymode", "abc");
		String highlight = isNull(request::getParameter, "highlight", "abc");

		ABCService service = new ABCService();
		ABC[] data = service.getAlphabet(displayMode, highlight);

		request.setAttribute("abc", data);
		request.setAttribute("author", author);
		request.setAttribute("displaymode", displayMode);
		this.redirect("/WEB-INF/abc.jsp", request, response);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
