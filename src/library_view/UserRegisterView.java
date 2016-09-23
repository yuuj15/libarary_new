package library_view;

import java.util.Scanner;

import library_domain.User;

public class UserRegisterView {

	private Scanner keyboard;

	public UserRegisterView() {

		keyboard = new Scanner(System.in);
	}

	public User getUserInfo() {

		// private String userId;
		// private String userPw;
		// private String userName;
		// private String userAddr;
		// private String userTel;
		// private String userGender;

		User user = null;
		System.out.println("[회원가입 페이지 접속]");
		while (true) {

			System.out.print("[ID] : ");
			String userId = keyboard.next();
			System.out.print("[[PW] : ");
			String userPw = keyboard.next();
			System.out.print("[회원이름] : ");
			String userName = keyboard.next();
			System.out.print("[주소] : ");
			String userAddr = keyboard.next();
			System.out.print("[전화번호] : ");
			String userTel = keyboard.next();
			System.out.println("[성별 M/F] : ");
			String userGender = keyboard.next();

			if (userGender.equals("M") || userGender.equals("F")) {
				user = new User(userId, userPw, userName, userAddr, userTel, userGender);
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
		return user;
	}

}
