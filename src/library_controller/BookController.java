package library_controller;

import library_dao.BookDao;
import library_domain.Book;
import library_view.BookSearchView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	//책 검색 페이지 뷰
	public void requesrSearchBook() {
		
		BookSearchView booksearchView = new BookSearchView();
		booksearchView.search();

	}

	//책이름으로 검색하는 뷰
	public void reqestSearchBookName(String searchBookName) {
		
		Book searchedBookName = bookDao.searchBook(searchBookName);
		
		//책이름으로 찾은 책 정보들을 뷰로 보여준다.
		BookSearchView bookSearchView = new BookSearchView();
		bookSearchView.searchedBookList(searchedBookName);
		
		//도서 검색 리스트 보여주기
		requesrSearchBook();

	}

	public void requestSearchWriter() {
		boolean success = false;

		success = bookDao.searchWriter();

	}

}
