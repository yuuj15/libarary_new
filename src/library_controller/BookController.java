package library_controller;

import library_dao.BookDao;
import library_domain.Book;
import library_view.BooksearchView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	//책 검색 페이지 뷰
	public void requesrSearchBook() {
		
		BooksearchView booksearchView = new BooksearchView();
		booksearchView.search();

	}

	//책이름으로 검색하는 뷰
	public void reqestSearchBookName(String searchBookName) {
		
		Book searchedBookName2 = bookDao.searchBook(searchBookName);
		
		//책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BooksearchView bookSearchView = new BooksearchView();
		bookSearchView.searchedBookList(searchedBookName2);
		
		//도서 검색 리스트 보여주기
		requesrSearchBook();

	}

	public void requestSearchWriter() {
		boolean success = false;

		success = bookDao.searchWriter();

	}

}
