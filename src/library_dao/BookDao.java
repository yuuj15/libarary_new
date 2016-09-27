package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_controller.Controllers;
import library_domain.Book;
import library_domain.User;

public class BookDao {

<<<<<<< HEAD
	public Book searchBook(String searchBookName) {

		// boolean success = false;
		Book searchedBookName = null;

=======
	public ArrayList<Book> searchBook(String searchBookName) {
		
//		boolean success = false;
		Book searchedBookName = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
>>>>>>> refs/remotes/pcj9027/master
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "select * from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBookName);
			rs = pstmt.executeQuery();
<<<<<<< HEAD

			if (rs.next()) {
=======
			
//			if(rs.next()){
//				searchedBookName = new Book();
//				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));
//				searchedBookName.setBookName(rs.getString("bookName"));
//				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
//				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
//				searchedBookName.setGenreCode(rs.getString("genreCode"));
//			}
			
			while(rs.next()){
>>>>>>> refs/remotes/pcj9027/master
				searchedBookName = new Book();
				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));
				searchedBookName.setBookName(rs.getString("bookName"));
				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
				searchedBookName.setGenreCode(rs.getString("genreCode"));
				bookList.add(searchedBookName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD

		return searchedBookName;
=======
		
		return bookList;
>>>>>>> refs/remotes/pcj9027/master
	}

	public ArrayList<Book> searchAuthor(String searchAuthor) {
		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Book> bookinfo = new ArrayList<Book>();

		try {
			sql = "select * from Book where BookAuthor like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchAuthor);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Book searchedBookAuthor = new Book();
				searchedBookAuthor.setBookBarcode(rs.getInt("bookBarcode"));
				searchedBookAuthor.setBookName(rs.getString("bookName"));
				searchedBookAuthor.setBookAuthor(rs.getString("bookAuthor"));
				searchedBookAuthor.setBookPublisher(rs.getString("bookPublisher"));
				searchedBookAuthor.setGenreCode(rs.getString("genreCode"));
				bookinfo.add(searchedBookAuthor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookinfo;
	}
}