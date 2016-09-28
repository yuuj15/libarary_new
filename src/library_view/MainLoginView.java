package library_view;

import java.util.Scanner;

import library_controller.Controllers;


public class MainLoginView {

	private Scanner keyboard;

	public MainLoginView() {

		keyboard = new Scanner(System.in);

	}

	public void showMainPage() {

		while (true) {
			
			//TOP5 대출 내역 	
			Controllers.getBookController().requestTop5List();

			boolean success = Controllers.getLoginControlles().requestLoginCheck();

			if(!success){
				System.out.print("[1. 회원가입, 2. 도서검색, 3. 로그인, 0. 프로그램 종료] : ");
			}else{
				System.out.print("[1. 회원가입, 2. 도서검색, 3. 로그아웃 , 0. 프로그램 종료] : ");
			}


			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				System.out.println("회원가입 페이지 입니다.");
				Controllers.getUserController().requestRegisterUser();
				break;
			case 2:
				System.out.println("도서검색 페이지 입니다.");
				Controllers.getBookController().requesrSearchBook();
				break;
			case 3:
				if (!success) {
					Controllers.getLoginControlles().requestLogin();
				} else {
					Controllers.getLoginControlles().requestLogOut();
				}
				break;
			case 0:
				System.out.println("프로그램 종료");
				System.exit(0);
			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}
