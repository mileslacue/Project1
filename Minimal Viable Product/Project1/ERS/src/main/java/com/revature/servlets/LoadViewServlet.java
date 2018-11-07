package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.util.RequestViewHelper;

public class LoadViewServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Logger log = LogManager.getLogger(LoadViewServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Request sent to front controller, LoadViewServlet.doGet()");

		String nextView = RequestViewHelper.process(request);

		log.info("In LoadView Servlet: outgoing String: "+nextView);
	
		request.getRequestDispatcher(nextView).forward(request, response);

}
}
