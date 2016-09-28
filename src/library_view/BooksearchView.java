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
<<<<<<< HEAD
	
	public void searchedBookList(Book searchedBookName){
		System.out.println("바코드 번호 : " + searchedBookName.getBookBarcode());
		System.out.println("책 이름 : " + searchedBookName.getBookName());
		System.out.println("저자 : " + searchedBookName.getBookAuthor());
		System.out.println("책회사 : " + searchedBookName.getBookPublisher());
		System.out.println("성별 : " + searchedBookName.getGenreCode());
		
=======

	public void searchedBookList(ArrayList<Book> bookList){

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

			}
		}
>>>>>>> origin/master
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
			String searchAuthor = keyboard.next();
			
			Controllers.getBookController().requestSearchAuthor(searchAuthor);

		}else if(number == 3){

			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();

		}

	}

}

