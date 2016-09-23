package library_controller;

import library_dao.LoginDao;
import library_domain.Login;
import library_view.LoginView;
import library_view.MainLoginView;


public class LoginController {

	private LoginDao loginDao;
	
	public LoginController(){
		
		loginDao = new LoginDao();
		
	}
	
	//로그인 
	public void requestLogin(){
		LoginView loginView = new LoginView();
		Login login=loginView.getLoginInfo();
		boolean success = loginDao.login(login);
				
	}
	
	//로그인 상태
	public void requestLoginCheck(){
		
	}
	
	//로그아웃
	public void requestLogOut(){
		boolean success = loginDao.logOut();
	}

	public void requestMainLogin() {
		
		MainLoginView mainLoginView = new MainLoginView();
		mainLoginView.showMainPage();
		
	}
}
