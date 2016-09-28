package library_controller;

import java.util.ArrayList;

import library_dao.BookDao;
import library_domain.Book;
import library_domain.BookLoanTop5;
import library_view.BookTop5List;
import library_view.BooksearchView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	// 책 검색 페이지 뷰
	public void requesrSearchBook() {

		BooksearchView booksearchView = new BooksearchView();
		booksearchView.search();

	}

	// 책이름으로 검색하는 뷰
	public void reqestSearchBookName(String searchBookName) {

		// 도서 검색 리스트 보여주기
		ArrayList<Book> bookList = bookDao.searchBook(searchBookName);
		
		//책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		bookSearchView.searchedBookList(bookList);
		
		//도서 검색 리스트 보여주기

		requesrSearchBook();

	}
	// 저자로 검색하는 뷰
	public void requestSearchAuthor(String searchAuthor) {

		ArrayList<Book> searchedBookAuthor = bookDao.searchAuthor(searchAuthor);
		// 책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		bookSearchView.searchedBookList(searchedBookAuthor);

		// 도서 검색 리스트 보여주기
		requesrSearchBook();

	}
	
	//TOP5 대출내역 리스트
	public void requestTop5List(){
		
		ArrayList<BookLoanTop5> bookLoans = bookDao.bookLoanList();
		
		// TOP5대출 내역을 뷰로 보여준다
		BookTop5List bookTop5List = new BookTop5List();
		bookTop5List.top5List(bookLoans);
	}

}