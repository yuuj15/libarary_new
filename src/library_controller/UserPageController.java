package library_controller;

import library_dao.LoginDao;
import library_view.UserCheckPwView;
import library_view.UserPageView;

public class UserPageController {

	private LoginDao logindao;

	public UserPageController() {

		logindao = new LoginDao();
	}

	public void requestUserPage() {

		UserCheckPwView checkPwView = new UserCheckPwView();
		String pwInfo = checkPwView.getLoginInfo();

		boolean success = logindao.password(pwInfo);
		if (success) {
			UserPageView userPageView = new UserPageView();
			userPageView.userPageInfo();
		}else{
			System.out.println("비밀번호가 틀립니다.");
		}
	}

	

}
