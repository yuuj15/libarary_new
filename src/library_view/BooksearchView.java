package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.Controllers;
import library_domain.Book;

public class BooksearchView {

	private Scanner keyboard;

	public BooksearchView() {

		keyboard = new Scanner(System.in);

	}

	public void searchedBookList(ArrayList<Book> searchedBookAuthor) {

		if (searchedBookAuthor.size() == 0) {

			System.out.println("검색하신 책 목록이 없습니다.");

		} else {
			for (int i = 0; i < searchedBookAuthor.size(); i++) {

				System.out.println("바코드 번호 : " + searchedBookAuthor.get(i).getBookBarcode());
				System.out.println("책 이름 : " + searchedBookAuthor.get(i).getBookName());
				System.out.println("저자 : " + searchedBookAuthor.get(i).getBookAuthor());
				System.out.println("책회사 : " + searchedBookAuthor.get(i).getBookPublisher());
				System.out.println("장르 : " + searchedBookAuthor.get(i).getGenreCode());
			}
		}
	}

	public void search() {

		System.out.println("[ 도서검색 페이지 입니다. ]");
		System.out.println(" 1. 책이름, 2. 저자  3. 메인페이지");
		int number = keyboard.nextInt();

		if (number == 1) {

			System.out.println("책이름검색 : ");
			String searchBook = keyboard.next();

			Controllers.getBookController().reqestSearchBookName(searchBook);

		} else if (number == 2) {

			System.out.println("저자 검색: ");
			String searchAuthor = keyboard.next();

			Controllers.getBookController().requestSearchAuthor(searchAuthor);

		} else if (number == 3) {

			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();

		}

	}

}