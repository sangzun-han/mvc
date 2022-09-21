package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;
import util.DBUtil;

public class BookDao {
	private BookDao() {}
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	
	DBUtil dbUtil = DBUtil.getInstance();
	
	public List<Book> getBookList() throws SQLException {
		List<Book> list = new ArrayList<>();
		
		String sql = "select * from book";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		 	conn = dbUtil.getConnection();
		 	pstmt = conn.prepareStatement(sql);
		 	rs = pstmt.executeQuery();
		 	
		 	while(rs.next()) {
		 		Book book = new Book();
		 		book.setIsbn(rs.getString(1));
		 		book.setTitle(rs.getString(2));
		 		book.setAuthor(rs.getString(3));
		 		book.setPrice(rs.getInt(4));
		 		book.setDescription(rs.getString(5));
		 		book.setImg(rs.getString(6));
		 		list.add(book);
		 	}
		 	return list;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
	public int insertBook(Book book) throws SQLException {
		String sql = "insert into book(isbn, title, author, price, description, img) values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getImg());
			
			return pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt,conn);
		}
	}
	
	public Book detailBook(String isbn) throws SQLException {
		String sql = "select * from book where isbn = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			ResultSet rs = pstmt.executeQuery();
			
			Book book = new Book();
			if(rs.next()) {
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setDescription(rs.getString(5));
				book.setImg(rs.getString(6));
			}
			return book;
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	public int deleteBook(String isbn) throws SQLException {
		String sql = "delete from book where isbn = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			return pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
}
