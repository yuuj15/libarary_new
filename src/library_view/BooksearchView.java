package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.Controllers;
import library_domain.Book;

public class BooksearchView {

	private Scanner keyboard;

	public BooksearchView(){

		keyboard = new Scanner(System.in);

	}

	public void searchedBookList(ArrayList<Book> bookList){

		//		System.out.println("바코드 번호 : " + searchedBookName.getBookBarcode());
		//		System.out.println("책 이름 : " + searchedBookName.getBookName());
		//		System.out.println("저자 : " + searchedBookName.getBookAuthor());
		//		System.out.println("책회사 : " + searchedBookName.getBookPublisher());
		//		System.out.println("성별 : " + searchedBookName.getGenreCode());


		if(bookList.size() == 0){

			System.out.println("찾으시는 제품이 없습니다.");

		} else{

			for(int i = 0; i < bookList.size(); i++){

				System.out.println("바코드 번호: " + bookList.get(i).getBookBarcode());
				System.out.println("책 이름: " + bookList.get(i).getBookName());
				System.out.println("저자: " + bookList.get(i).getBookAuthor());
				System.out.println("책회사: " + bookList.get(i).getBookPublisher());
				System.out.println("성별: " + bookList.get(i).getGenreCode());

			}
		}
	}


	public void search() {

		System.out.println("[ 도서검색 페이지 입니다. ]");
		System.out.println(" 1. 책이름, 2. 저자  3. 메인페이지");
		int number = keyboard.nextInt();

		if(number == 1){

			System.out.println("책이름검색 : ");
			String searchBook = keyboard.next();

			Controllers.getBookController().reqestSearchBookName(searchBook);

		}else if(number == 2){

			System.out.println("저자 검색: ");
			Controllers.getBookController().requestSearchWriter();

		}else if(number == 3){

			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();

		}

	}

}
