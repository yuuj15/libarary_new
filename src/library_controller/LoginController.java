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
		Login login = loginView.getLoginInfo();
		boolean success = loginDao.login(login);
		
		if(success){
			System.out.println("로그인 성공");
		} else{
			System.out.println("로그인 실패");;
		}
		
		//로그인 된 메인 메인페이지로 이동
		requestMainLogin();
	}
	
	//로그인 상태
	public boolean requestLoginCheck(){
		
		boolean success = loginDao.loginCheck();
		
		return success;
	}
	
	//로그아웃
	public void requestLogOut(){
		
		loginDao.logOut();
		
		//주문 내역 삭제
		
	}

	//메인 페이지
	public void requestMainLogin() {
		
		MainLoginView mainLoginView = new MainLoginView();
		mainLoginView.showMainPage();
		
	}
}
