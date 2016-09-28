package library_view;

import java.util.Scanner;

import library_controller.Controllers;

public class UserPageView {

	private Scanner keyboard;

	public UserPageView() {

		keyboard = new Scanner(System.in);
	}

	public void userPageInfo() {
		System.out.println("[ * 마이페이지 입니다. * ]");
		
		System.out.print("[1. 내 정보 보기, 2.도서대출이력조회, 0.메인페이지 ] : ");
		int selectedMenu = keyboard.nextInt();
		
		switch(selectedMenu){
		
		case 1:
			Controllers.getUserController().requestUserList();
			break;
			
		case 2:
			
			System.out.println("도서대출이력조회 페이지입니다.");
			Controllers.getBookController().requesutLoanList();
			break;
			
		case 3:
			
			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();
			
		}
		
	}
}
