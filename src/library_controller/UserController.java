package library_controller;

import java.util.ArrayList;

import library_dao.UserDao;
import library_domain.User;
import library_repository.LoginRepository;
import library_view.UserChangeAddrView;
import library_view.UserChangeNameView;
import library_view.UserChangeTelView;
import library_view.UserCheckPwView;
import library_view.UserListView;
import library_view.UserRegisterView;

public class UserController {

	private UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	//회원가입
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
	public void requestChangeName() {

		UserChangeNameView userChangeNameView = new UserChangeNameView();
		String userNewName = userChangeNameView.UserNewName();

		boolean success = userDao.userChangeName(userNewName);
		requestUserList();

	}

	public void requestChangeAddr() {

		UserChangeAddrView userChangeAddrView = new UserChangeAddrView();
		String userNewAddr = userChangeAddrView.UserNewAddr();

		boolean success = userDao.userChangeAddr(userNewAddr);
		requestUserList();

	}

	public void requestChangeTel() {

		UserChangeTelView userChangeTelView = new UserChangeTelView();
		String userNewTel = userChangeTelView.UserNewTel();

		boolean success = userDao.userChangeTel(userNewTel);
		requestUserList();

	}

	public void requsetUserDelete() {

		UserCheckPwView checkPwView = new UserCheckPwView();
		String pwInfo = checkPwView.getLoginInfo();
		boolean success = userDao.password(pwInfo);
		if (success == true) {

			success = userDao.userDelete();
			if (success == true) {
				Controllers.getLoginControlles().requestLogOut();
			}
		}else{
			System.out.println("비민번호가 틀립니다.");
		}
	}
	


}
