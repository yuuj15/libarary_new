package library_view;

import java.util.Scanner;

import library_domain.Login;

public class LoginView {

	private Scanner keyboard;

	public LoginView() {

		keyboard = new Scanner(System.in);

	}

	public Login getLoginInfo() {

		System.out.println("[ * 로그인 페이지 입니다. * ] ");
		System.out.print("ID를 입력하세요:");
		String login_Id = keyboard.next();		
		System.out.print("PW를 입력하세요: ");
		String login_pw = keyboard.next();

		Login login = new Login(login_Id, login_pw);

		return login;
	}

}
