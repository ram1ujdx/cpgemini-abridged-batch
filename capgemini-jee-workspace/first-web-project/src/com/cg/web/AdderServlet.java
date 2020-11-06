package com.cg.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add", initParams = {
		@WebInitParam(name = "color", value = "red")
})
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int x,y,sum;
		x=Integer.parseInt(request.getParameter("tnum1"));
		y=Integer.parseInt(request.getParameter("tnum2"));
		sum=x+y;
		Cookie cookie=new Cookie("cg.web.sum", String.valueOf(sum));
		//response.sendRedirect("cube?sum="+sum);
		cookie.setMaxAge(60*60*24);	
		response.addCookie(cookie);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Add Numbers</title></head>");
		out.println("<body bgColor='yellow'>");
		out.println("<h1 style='color :blue;'>");
				out.println("Sum = "+sum);
				out.println("</h1>");
//				out.println("<a href=cube?sum="+sum+">Get Cube</a>");
				out.println("<a href=cube>Get Cube</a>");
				out.println("</body>");
				out.println("</html>");
		
	}

}
