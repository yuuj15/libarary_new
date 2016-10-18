package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_controller.Controllers;
import library_domain.Book;
import library_domain.BookDetail;
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


	public ArrayList<Book> searchLoanBook() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> booklist =new ArrayList<Book>();
		String bookLoantf = "f";

		try {
			String sql = "select * from book,bookloan where book.bookbarcode = bookloan.bookbarcode and bookloanTF = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, bookLoantf);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Book searchLoanBook = new Book();
				searchLoanBook.setBookName(rs.getString("bookname"));
				searchLoanBook.setBookAuthor(rs.getString("bookAuthor"));
				searchLoanBook.setBookPublisher(rs.getString("bookPublisher"));
				searchLoanBook.setGenreCode(rs.getString("genrecode"));
				booklist.add(searchLoanBook);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return booklist;
	}

	//TOP5 대출 리스트 출력
	public ArrayList<BookLoanTop5> bookLoanList() {

		ArrayList<BookLoanTop5> bookLoans = new ArrayList<BookLoanTop5>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try{
			sql = "select rownum, book.BOOKNAME from (select count(bookbarcode) tt , bookbarcode "
					+ "from bookloan where bookbarcode is not null "
					+ "group by bookbarcode order by tt desc ) tmp, book "
					+ "where book.bookbarcode = tmp.bookbarcode and rownum <=5";
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
	public BookDetail searchDetailBook(int barcodeNumber) {

		BookDetail bookInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select bookname,bookauthor,bookpublisher,genrename,bookloantf, bookloandate "
					+ "from book,genre,bookloan where book.bookbarcode = bookloan.bookbarcode "
					+ "and book.genrecode = genre.genrecode and book.bookbarcode = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, barcodeNumber);
			rs = pstmt.executeQuery();
			int lineCount = 0;
			while (rs.next()) {

				lineCount = lineCount + 1;

			}

			if (lineCount > 0) {
				sql = "select bookname,bookauthor,bookpublisher,genrename,bookloantf, bookloandate "
						+ "from book,genre,bookloan "
						+ "where book.bookbarcode = bookloan.bookbarcode and book.genrecode = genre.genrecode "
						+ "and book.bookbarcode = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, barcodeNumber);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					bookInfo = new BookDetail();
					bookInfo.setBookName(rs.getString("bookname"));
					bookInfo.setBookAuthor(rs.getString("bookauthor"));
					bookInfo.setBookPublisher(rs.getString("bookpublisher"));
					bookInfo.setGenreName(rs.getString("genrename"));
					bookInfo.setBookLoanTF(rs.getString("bookloantf"));
					bookInfo.setBookLoanDate(rs.getDate("bookloandate"));
				}	

			} 
			else {
				// 쿼리 날린 결과가 없다.
				sql = "select bookname,bookauthor,bookpublisher,genrename from book, genre"
						+ "where book.genrecode = genre.genrecode and book.bookbarcode = ? ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, barcodeNumber);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					bookInfo = new BookDetail();
					bookInfo.setBookName(rs.getString("bookname"));
					bookInfo.setBookAuthor(rs.getString("bookauthor"));
					bookInfo.setBookPublisher(rs.getString("bookpublisher"));
					bookInfo.setGenreName(rs.getString("genrename"));
					bookInfo.setBookLoanTF("t");
				}
				
			}

		} 
		catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return bookInfo;

	}
}
