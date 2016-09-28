package library_view;

import java.util.Scanner;

public class UserCheckPwView {
	private Scanner keyboard;

	public UserCheckPwView() {
		
		keyboard = new Scanner(System.in);
	}

	public String getLoginInfo() {
		
		System.out.print("비밀번호 입력: ");
		String userPw = keyboard.next();
		
		return userPw;
	}
}
