package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_controller.Controllers;
import library_domain.Book;



public class BookDao {

	public ArrayList<Book> searchBook(String searchBookName) {
		
//		boolean success = false;
		Book searchedBookName = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			sql = "select * from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBookName);
			rs = pstmt.executeQuery();
			
//			if(rs.next()){
//				searchedBookName = new Book();
//				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));
//				searchedBookName.setBookName(rs.getString("bookName"));
//				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
//				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
//				searchedBookName.setGenreCode(rs.getString("genreCode"));
//			}
			
			while(rs.next()){
				searchedBookName = new Book();
				searchedBookName.setBookBarcode(rs.getInt("bookBarcode"));
				searchedBookName.setBookName(rs.getString("bookName"));
				searchedBookName.setBookAuthor(rs.getString("bookAuthor"));
				searchedBookName.setBookPublisher(rs.getString("bookPublisher"));
				searchedBookName.setGenreCode(rs.getString("genreCode"));
				bookList.add(searchedBookName);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return bookList;
	}

	public boolean searchWriter() {

		boolean success = false;

		// 쿼리
		return success;
	}
}
