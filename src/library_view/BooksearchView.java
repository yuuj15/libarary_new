package library_view;

import java.util.Scanner;

import library_controller.Controllers;



public class BookSearchView {
	
	private Scanner keyboard;
	
	public BookSearchView(){
		
		keyboard = new Scanner(System.in);
		
	}

	public void search() {
		
		System.out.println("[ 도서검색 페이지 입니다. ]");
		System.out.println(" 1. 책이름, 2. 저자  3. 메인페이지");
		int number = keyboard.nextInt();
		
		if(number == 1){
			
			System.out.println("책이름검색 :");
			String searchBook = keyboard.next();
			Controllers.getBookController().reqestSearchBook(searchBook);
			
		}else if(number == 2){
			
			System.out.println("저자 검색:");
			Controllers.getBookController().requestSearchWriter();
			
		}else if(number == 3){
			
			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();
			
		}
		
	}
		
}
