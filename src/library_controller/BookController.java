package library_controller;

import library_dao.BookDao;
import library_view.BookSearchView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	public void requesrSearchBook() {
		
		BookSearchView booksearchView = new BookSearchView();
		booksearchView.search();

	}

	public void reqestSearchBook(String searchBook) {
		
		boolean success = bookDao.searchBook(searchBook);
		
		if(success){
			System.out.println("책이름 찾기 성공");
		} else{
			System.out.println("책이름 찾기 실패");
		}
		
		//도서 검색 리스트 보여주기
		requesrSearchBook();

	}

	public void requestSearchWriter() {
		boolean success = false;

		success = bookDao.searchWriter();

	}

}
