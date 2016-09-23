package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import library_controller.Controllers;
import library_domain.Login;
import library_repository.LoginRepository;

public class LoginDao {

	public LoginDao(){

		new LoginRepository();

	}

	//로그인 등록
	public boolean login(Login login){

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from USERINFO where user_id = ? and user_pw = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, login.getLogin_Id());
			pstmt.setString(2, login.getLogin_Pw());
			rs = pstmt.executeQuery();

			if (rs.next()) { 
				LoginRepository.setLogin(login);
				success = true;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			} if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;
	}

	//로그인 체크
	public boolean loginCheck(){

		boolean success = false;

		if (LoginRepository.getLogin() != null) {
			success = true;
		}

		return success;

	}

	//로그아웃
	public void logOut(){

		LoginRepository.setLogin(null);

	}

}
