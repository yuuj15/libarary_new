package library_controller;

import java.util.ArrayList;

import library_dao.UserDao;
import library_domain.User;
import library_view.UserListView;
import library_view.UserRegisterView;

public class UserController {

	private UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	//
	public void requestRegisterUser() {
		// 뷰를 보여줘서 회원가입을 받아온다.
		UserRegisterView userRegisterView = new UserRegisterView(); 
		User user = userRegisterView.getUserInfo();

		User user2 = userDao.generateinsert(user);
		boolean success = userDao.insertUser(user2);
		
		if (success) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("중복된 아이디가 있습니다.");
		}
	}

	public void requestUserList() {
		
		ArrayList<User> userList = userDao.userList();
		
		UserListView userListView = new UserListView();
		userListView.PrintUserListView(userList);
		
		
		
		
	}

}
