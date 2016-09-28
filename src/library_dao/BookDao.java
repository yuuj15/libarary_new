package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_controller.Controllers;
import library_domain.Book;
import library_domain.BookLoanTop5;

public class BookDao {

	public ArrayList<Book> searchBook(String searchBookName) {

		Book searchedBookName = null;
		ArrayList<Book> bookList = new ArrayList<Book>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "select * from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBookName);
			rs = pstmt.executeQuery();

			while(rs.next()){

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
		}finally{
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

		return bookList;

	}
	//저자로 책 정보 찾기
	public ArrayList<Book> searchAuthor(String searchAuthor) {

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
	//TOP5 대출 리스트 출력
	public ArrayList<BookLoanTop5> bookLoanList() {

		ArrayList<BookLoanTop5> bookLoans = new ArrayList<BookLoanTop5>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try{
			sql = "select rownum, book.BOOKNAME from (select count(bookbarcode) tt , bookbarcode from bookloan where bookbarcode is not null group by bookbarcode order by tt desc ) tmp, book where book.bookbarcode = tmp.bookbarcode and rownum <=5";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){

				BookLoanTop5 bookLoanTop5 = new BookLoanTop5();
				bookLoanTop5.setRownum(rs.getInt("rownum"));
				bookLoanTop5.setBookName(rs.getString("BOOKNAME"));
				bookLoans.add(bookLoanTop5);

			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

		//리턴값으로 top5 대출 내역 보내기
		return bookLoans;
	}
}
