package phanvanhuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phanvanhuy.entity.Book;

public class BookDao {
	public static List<Book> queryBooks(Connection conn) throws SQLException {
		String sql = "Select * from Book a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			String bookId = rs.getString("BookId");
			String title = rs.getString("Title");
			String author = rs.getString("Author");
			int release = rs.getInt("Release");
			float price = rs.getFloat("Price");
			String picture = rs.getString("Picture");
			Book book = new Book();
			book.setBookId(bookId);
			book.setTitle(title);
			book.setAuthor(author);
			book.setRelease(release);
			book.setPrice(price);
			book.setPicture(picture);
			list.add(book);
		}
		return list;
	}

	
	public static Book findBook(Connection conn, String bookId) throws SQLException {
		String sql = "Select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture from Book a where a.BookId =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, bookId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String BookId = rs.getString("BookId");
			String Title = rs.getString("Title");
			String Author = rs.getString("Author");
			int Release = rs.getInt("Release");
			float Price = rs.getFloat("Price");
			String Picture = rs.getString("Picture");
			Book book = new Book(BookId, Title, Author, Release, Price, Picture);
			return book;
		}
		return null;
	}
	public static void insertBook(Connection conn, Book book) throws SQLException {
		String sql = "insert into Book(BookId, Title, Author, Release, Price, Picture) values(?,?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getBookId());
		pstm.setString(2, book.getTitle());
		pstm.setString(3, book.getAuthor());
		pstm.setInt(4, book.getRelease());
		pstm.setFloat(5, book.getPrice());
		pstm.setString(6, book.getPicture());
		pstm.executeUpdate();
	}
	public static void updateBook(Connection conn,Book book) throws SQLException {
		String sql = "UPDATE Book SET BookId=?, Title=?, Author=?, Release=?, Price=?, Picture=? WHERE BookId=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, book.getBookId());
		pstm.setString(2, book.getTitle());
		pstm.setString(3, book.getAuthor());
		pstm.setInt(4, book.getRelease());
		pstm.setFloat(5, book.getPrice());
		pstm.setString(6, book.getPicture());
		pstm.executeUpdate();
	}
	public static void deleteBook(Connection conn, String maSach) throws SQLException {
		String sql = "delete from Book where BookId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, maSach);
		pstm.executeUpdate();
}
}
