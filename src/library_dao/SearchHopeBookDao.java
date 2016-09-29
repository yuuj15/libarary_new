package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library_controller.Controllers;
import library_domain.SearchBook;

public class SearchHopeBookDao {


	//자료검색(책이름으로 검색)
	public ArrayList<SearchBook> searchedBookName(String searchedBookName) {

		SearchBook searchBook = null;
		ArrayList<SearchBook> searchBookNameList = new ArrayList<SearchBook>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "select * from SEARCHBOOK where SEARCHBOOKNAME like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchedBookName);
			rs = pstmt.executeQuery();


			while(rs.next()){

				searchBook = new SearchBook();
				searchBook.setSearchBookNumber(rs.getInt("SEARCHBOOKNUMBER"));
				searchBook.setSearchBookName(rs.getString("SEARCHBOOKNAME"));
				searchBook.setSearchBookAuthor(rs.getString("SEARCHBOOKAUTHOR"));
				searchBook.setSearchBookPublisher(rs.getString("SEARCHBOOKPUBLISHER"));
				searchBook.setSearchBookPrice(rs.getInt("SEARCHBOOKPRICE"));
				searchBookNameList.add(searchBook);

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

		return searchBookNameList;


	}

	//자료검색(저자로 검색)
	public ArrayList<SearchBook> searchedAuthor(String searchedAuthor) {

		ArrayList<SearchBook> searchBookList = new ArrayList<SearchBook>();
		SearchBook searchBook = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "select * from SEARCHBOOK where SEARCHBOOKAUTHOR like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchedAuthor);
			rs = pstmt.executeQuery();


			while(rs.next()){

				searchBook = new SearchBook();
				searchBook.setSearchBookNumber(rs.getInt("SEARCHBOOKNUMBER"));
				searchBook.setSearchBookName(rs.getString("SEARCHBOOKNAME"));
				searchBook.setSearchBookAuthor(rs.getString("SEARCHBOOKAUTHOR"));
				searchBook.setSearchBookPublisher(rs.getString("SEARCHBOOKPUBLISHER"));
				searchBook.setSearchBookPrice(rs.getInt("SEARCHBOOKPRICE"));
				searchBookList.add(searchBook);

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

		return searchBookList;
	}

	//희망하는 자료넘버를 받은 자료정보들을 RequestBook table에 저장한다.
	public boolean bookInfoSaveToDB(int searchedBookNumber, int hopeCountNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String recentBookName = null;
		String recentBookAuthor = null;
		String recentBookPublisher = null;
		int recentBookPrice = 0;
		int countNumber = 0;
		String sql = null;

		try{

			sql = "select SEARCHBOOKNAME, SEARCHBOOKAUTHOR, SEARCHBOOKPUBLISHER, SEARCHBOOKPRICE from SEARCHBOOK where SEARCHBOOKNUMBER = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchedBookNumber);
			rs = pstmt.executeQuery();

			if(rs.next()){

				recentBookName = rs.getString("SEARCHBOOKNAME");
				recentBookAuthor = rs.getString("SEARCHBOOKAUTHOR");
				recentBookPublisher = rs.getString("SEARCHBOOKPUBLISHER");
				recentBookPrice = rs.getInt("SEARCHBOOKPRICE");

			}

			sql = "select * from SEARCHBOOK where SEARCHBOOKNUMBER = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchedBookNumber);
			rs = pstmt.executeQuery();

			if(rs.next()){//중복이 있다.
				countNumber = hopeCountNumber + rs.getInt("REQUESTBOOKCOUNTNUMBER");
				sql = "update REQUESTBOOK set REQUESTBOOKCOUNTNUMBER = ? set where REQUESTBOOKNUMBER = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, countNumber);
				pstmt.setInt(2, searchedBookNumber);
				int result = pstmt.executeUpdate();
				
				if(result != 0){
					
					success = true;
					
				}
			}else{

				sql = "insert into REQUESTBOOK values(?, ?, ?, ?, ?, ?)";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, searchedBookNumber);
				pstmt.setString(2, recentBookName);
				pstmt.setString(3, recentBookAuthor);
				pstmt.setString(4, recentBookPublisher);
				pstmt.setInt(5, hopeCountNumber);
				pstmt.setInt(6, recentBookPrice);

				int result = pstmt.executeUpdate();

				if(result != 0){
					success = true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return success;

	}

	//신청한 자료가 admin으로 넘겨주기

}
