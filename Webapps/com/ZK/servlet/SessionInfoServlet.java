package com.ZK.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class SessionInfoServlet
 */
@WebServlet("/SessionInfoServlet")
public class SessionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession mySession = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Session Info Servlet</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H3>Session Information</H3>");
		out.println("<BR>New Session: " + mySession.isNew());
		out.println("<BR>Session ID: " + mySession.getId());
		out.println("<BR>Session Creation Time: " + new Date(mySession.getCreationTime()));
		out.println("<BR>Session Last Accessed Time: " + new Date(mySession.getLastAccessedTime()));
		
		out.println("<H3>Request Information</H3>");
		out.println("<BR>Session ID from Request: " + request.getRequestedSessionId());
		out.println("<BR>Session ID via Cookie: " + request.isRequestedSessionIdFromCookie());
		out.println("<BR>Session ID via rewritten URL: " + request.isRequestedSessionIdFromURL());
		out.println("<BR>Valid Session ID: " + request.isRequestedSessionIdValid());
		
		out.println("<br><a href=" + response.encodeURL("SessionInfoServlet") + ">refresh</a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
