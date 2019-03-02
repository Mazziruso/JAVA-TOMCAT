package com.ZK.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession mySession = request.getSession(true);
		
		
		String heading = null;
		Integer accessCount = (Integer) mySession.getAttribute("accessCount");
		if(accessCount == null) {
			heading = "Welcome, New Customer";
			accessCount = new Integer(0);
		} else {
			heading = "welcome Back";
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		
		mySession.setAttribute("accessCount", accessCount);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Session Trace</TITLE></HEAD>"
				+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">"
				+ heading + "</H1>\n"
				+ "<H2>Information on Your Session:</H2>\n"
				+ "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
				+ "<TR BGCOLOR=\"FFAD00\">\n" + " <TH>Info Type<TH>Value\n"
				+ "<TR>\n" + " <TD>ID\n" + " <TD>" + mySession.getId() + "\n"
				+ "<TR>\n" + " <TD>Creation Time\n" + " <TD>"
				+ new Date(mySession.getCreationTime()) + "\n<TR>\n"
				+ " <TD>Time of Last Access\n" + " <TD>"
				+ new Date(mySession.getLastAccessedTime()) + "\n<TR>\n"
				+ " <TD>Number of Previous Accessed\n <TD>"
				+ accessCount + "\n</TABLE>\n"
				+ "</BODY></HTML>");
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
