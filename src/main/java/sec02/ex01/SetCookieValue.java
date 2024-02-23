package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

//		Cookie cookie = new Cookie("password", "짜장");
		Cookie cookie = new Cookie("password", URLEncoder.encode("짜장"));
		System.out.println(cookie);
//		cookie.setMaxAge(24*60*60);
//		cookie.setMaxAge(-1);	//음수면 쿠키가 저장되지 않았음을 뜻함
//		cookie.setMaxAge(0);	//0이면 쿠키를 삭제
		response.addCookie(cookie);
		
		Date date = new Date();
//		out.write(date.toString()+"<br>");
//		out.write(date.toGMTString()+"<br>");
		out.write(date.toLocaleString());
		

	}

}
