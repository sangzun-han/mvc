package model.service;

import java.sql.SQLException;
import java.util.List;

import dto.Book;
import model.dao.BookDao;

public class BookService {
	private BookService() {}
	private static BookService instance = new BookService();
	public static BookService getInstance() {
		return instance;
	}
	
	BookDao bookDao = BookDao.getInstance();
	
	
	public List<Book> getBookList() throws SQLException {
		return bookDao.getBookList();
	}
	
	public int insertBook(Book book) throws SQLException {
		return bookDao.insertBook(book);
	}
	
	public Book detailBook(String isbn) throws SQLException {
		return bookDao.detailBook(isbn);
	}
	
	public int deleteBook(String isbn) throws SQLException {
		return bookDao.deleteBook(isbn);
	}
}
