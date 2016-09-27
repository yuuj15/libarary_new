package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.Controllers;
import library_domain.Book;

public class BooksearchView {

	private Scanner keyboard;

<<<<<<< HEAD
	public BooksearchView() {
=======
	public BooksearchView(){
>>>>>>> refs/remotes/pcj9027/master

		keyboard = new Scanner(System.in);

	}

<<<<<<< HEAD
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
=======
	public void searchedBookList(ArrayList<Book> bookList){

		//		System.out.println("바코드 번호 : " + searchedBookName.getBookBarcode());
		//		System.out.println("책 이름 : " + searchedBookName.getBookName());
		//		System.out.println("저자 : " + searchedBookName.getBookAuthor());
		//		System.out.println("책회사 : " + searchedBookName.getBookPublisher());
		//		System.out.println("성별 : " + searchedBookName.getGenreCode());


		if(bookList.size() == 0){

			System.out.println("찾으시는 제품이 없습니다.");

		} else{

			System.out.println("[ 바코드 번호    |  책이름    |  저자    |  책회사    |  성별 ]");
			
			for(int i = 0; i < bookList.size(); i++){
				
				System.out.print(" " + " " + bookList.get(i).getBookBarcode() + "\t");
				System.out.print(" " + bookList.get(i).getBookName() + "\t");
				System.out.print(" " + bookList.get(i).getBookAuthor() + "\t");
				System.out.print(" " + bookList.get(i).getBookPublisher() + "\t");
				System.out.println(" " + bookList.get(i).getGenreCode() + "\t");

>>>>>>> refs/remotes/pcj9027/master
			}
		}
	}


	public void search() {

		System.out.println("[ 도서검색 페이지 입니다. ]");
		System.out.println(" 1. 책이름, 2. 저자  3. 메인페이지");
		int number = keyboard.nextInt();

<<<<<<< HEAD
		if (number == 1) {
=======
		if(number == 1){
>>>>>>> refs/remotes/pcj9027/master

			System.out.println("책이름검색 : ");
			String searchBook = keyboard.next();

			Controllers.getBookController().reqestSearchBookName(searchBook);

<<<<<<< HEAD
		} else if (number == 2) {

			System.out.println("저자 검색: ");
			String searchAuthor = keyboard.next();

			Controllers.getBookController().requestSearchAuthor(searchAuthor);

		} else if (number == 3) {
=======
		}else if(number == 2){

			System.out.println("저자 검색: ");
			Controllers.getBookController().requestSearchWriter();

		}else if(number == 3){
>>>>>>> refs/remotes/pcj9027/master

			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();

		}

	}

<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/pcj9027/master
