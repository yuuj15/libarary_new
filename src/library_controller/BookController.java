package library_controller;

import java.util.ArrayList;

import library_dao.BookDao;
import library_domain.Book;
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
<<<<<<< HEAD

		Book searchedBookName = bookDao.searchBook(searchBookName);

		// 책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		// bookSearchView.searchedBookList(searchedBookName);

		// 도서 검색 리스트 보여주기
=======
		
		ArrayList<Book> bookList = bookDao.searchBook(searchBookName);
		
		//책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		bookSearchView.searchedBookList(bookList);
		
		//도서 검색 리스트 보여주기
>>>>>>> refs/remotes/pcj9027/master
		requesrSearchBook();

	}

	public void requestSearchAuthor(String searchAuthor) {

		ArrayList<Book> searchedBookAuthor = bookDao.searchAuthor(searchAuthor);
		// 책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		bookSearchView.searchedBookList(searchedBookAuthor);

		// 도서 검색 리스트 보여주기
		requesrSearchBook();

	}

}