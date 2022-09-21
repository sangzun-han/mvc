package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import model.service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserService userService = UserService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch(action) {
			
			case "login" :
				login(request, response);
				break;
			
			case "logout":
				logout(request,response);
				break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		User user = new User();
		user = userService.login(id, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*30);
			
			if(remember != null) {
				Cookie cookie = new Cookie("saveId",id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*30);
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("saveId",id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		response.sendRedirect(request.getContextPath()+"/book?action=list");
	}
	

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		response.sendRedirect(request.getContextPath()+"/book?action=list");
	}

}
