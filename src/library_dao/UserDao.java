  package library_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library_controller.Controllers;
import library_domain.User;
import library_repository.LoginRepository;

public class UserDao {

	public boolean insertUser(User user) {

		// 쿼리
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<User>();
		boolean success = false;
		boolean duplicate = false;
		int barcodNumber = 0;

		try {

			String sql = "select userid from userinfo ";
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				User tempUserId = new User();// 1-1 객체생성을 해서 barcodeNumber를 리스트에
												// 저장한거.
				tempUserId.setUserId(rs.getString("userid"));
				users.add(tempUserId);// 1-3
			}
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUserId().equals(user.getUserId())) {

					duplicate = true;
				}

			}
			if (duplicate == false) {

				sql = "insert into userinfo(userbarcode, userid, userpw, username, useraddr, usertel, usergender) values(?,?,?,?,?,?,?) ";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, user.getUserBarcode());
				pstmt.setString(2, user.getUserId());
				pstmt.setString(3, user.getUserPw());
				pstmt.setString(4, user.getUserName());
				pstmt.setString(5, user.getUserAddr());
				pstmt.setString(6, user.getUserTel());
				pstmt.setString(7, user.getUserGender());

				int result = pstmt.executeUpdate();

				if (result != 0) {
					success = true;
				}
			}

		} catch (

		SQLException e) {
			System.out.println("제품 등록 중 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return success;

	}

	public User generateinsert(User user) {

		Random r = new Random(); // 랜덤함수 생성
		int barcodNumber = r.nextInt(899999) + 100000; // 10000~999999까지
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ArrayList<User> users = new ArrayList<User>();
		boolean success = false;

		try {
			String sql = "select userbarcode from userinfo ";
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				User tempUser = new User();// 1-1 객체생성을 해서 barcodeNumber를 리스트에
											// 저장한거.
				tempUser.setUserBarcode(rs.getInt("userbarcode"));// 1-2
				users.add(tempUser);// 1-3
			}

			while (true) {
				for (int i = 0; i < users.size(); i++) {

					if (barcodNumber == users.get(i).getUserBarcode()) {
						success = true;// userList에서 중복을 검사함.
					}

				}
				if (success == true) {
					barcodNumber = r.nextInt(899999) + 100000;// 다시 바코드번호 부여
				} else {

					user.setUserBarcode(barcodNumber);// 그 바코드 번호를 user객체에 set
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public ArrayList<User> userList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		String userId = LoginRepository.getLogin().getLogin_Id();

		try {

			String sql = "select * from userinfo where userId = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUserBarcode(rs.getInt("userBarcode"));
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserAddr(rs.getString("userAddr"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserGender(rs.getString("userGender"));
				userList.add(user);

			}

		} catch (SQLException e) {
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

		return userList;
	}
}
