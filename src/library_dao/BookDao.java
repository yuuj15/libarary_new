package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_controller.Controllers;



public class BookDao {

	public boolean searchBook(String searchBook) {
		boolean success = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try{
			System.out.println(searchBook);
			sql = "select BookName from Book where BookName like '%' || ? || '%'";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchBook);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	
		
		
		return success;
	}

	public boolean searchWriter() {

		boolean success = false;

		// 쿼리
		return success;
	}
}
