package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Book;
import model.service.BookService;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookService bookService = BookService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch(action) {
			case "list":
				getBookList(request, response);
				break;
			case "goRegist":
				request.getRequestDispatcher("book/bookInsert.jsp").forward(request, response);
				break;
			case "regist":
				insertBook(request, response);
				break;
			case "detail":
				detailBook(request, response);
				break;
			case "delete":
				deleteBook(request, response);
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

	private void getBookList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Book> list = bookService.getBookList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("book/bookList.jsp").forward(request, response);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, description, img);
		int cnt = bookService.insertBook(book);
		response.sendRedirect(request.getContextPath()+"/book?action=list");
	}
	
	private void detailBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book = bookService.detailBook(isbn);
		request.setAttribute("book", book);
		request.getRequestDispatcher("book/bookDetail.jsp").forward(request, response);
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String isbn = request.getParameter("isbn");
		int cnt = bookService.deleteBook(isbn);
		response.sendRedirect(request.getContextPath()+"/book?action=list");
	}
}
