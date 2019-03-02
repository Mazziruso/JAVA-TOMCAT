package com.ZK.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServletContext
 */
@WebServlet("/TestServletContext")
public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		ServletContext application = this.getServletContext();
		
		Integer accessCount = (Integer) application.getAttribute("accessCount");
		
		if(accessCount == null) {
			accessCount = new Integer(0);
		} else {
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		
		application.setAttribute("accessCount", accessCount);
		
		pw.println("<HTML><HEAD><TITLE>Session Trace</TITLE></HEAD>"
				+ "<BODY BGCOLOR=\"FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">"
				+ accessCount + "\n" + "</TABLE>\n</BODY></HTML></H1>\n");
		pw.close();
		
		System.out.println("accessCount: " + accessCount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
