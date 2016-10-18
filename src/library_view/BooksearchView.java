package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.BookController;
import library_controller.Controllers;
import library_domain.Book;

public class BooksearchView {

	private Scanner keyboard;

	public BooksearchView(){

		keyboard = new Scanner(System.in);

	}

	public void searchedBookList(ArrayList<Book> bookList){

		if(bookList.size() == 0){

			System.out.println("찾으시는 도서가 없습니다.");
			Controllers.getBookController().requesrSearchBook();

		} else{

			System.out.println("[ 바코드 번호    |  책이름    |  저자    |  출판사    |  장르 ]");
			
			for(int i = 0; i < bookList.size(); i++){
				
				System.out.print(" " + " " + bookList.get(i).getBookBarcode() + "\t");
				System.out.print(" " + bookList.get(i).getBookName() + "\t");
				System.out.print(" " + bookList.get(i).getBookAuthor() + "\t");
				System.out.print(" " + bookList.get(i).getBookPublisher() + "\t");
				System.out.println(" " + bookList.get(i).getGenreCode() + "\t");

			}
			
			System.out.print("1.도서상세조회, 2.도서검섹화면으로 돌아가기 : ");
			int number = keyboard.nextInt();
			
			if(number == 1)
			{
				Controllers.getBookController().requestBookDetailSeacrch();
			}
			else if(number == 2)
			{
				Controllers.getBookController().requesrSearchBook();
			}
			else
			{
				System.out.println("잘못 입력하셨습니다.");
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
			String searchAuthor = keyboard.next();
			
			Controllers.getBookController().requestSearchAuthor(searchAuthor);

		}else if(number == 3){

			System.out.println("메인페이지");
			Controllers.getLoginControlles().requestMainLogin();

		}

	}

}

