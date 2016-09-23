package library_controller;

import library_dao.BookDao;
import library_view.BooksearchView;

public class BookController {

	private BookDao bookDao;

	public BookController() {

		bookDao = new BookDao();

	}

	public void requesrSearchBook() {
		BooksearchView booksearchView = new BooksearchView();
		int number = booksearchView.search();

	}

	public void reqestSearchBook() {
		boolean success = false;

		success = bookDao.searchBook();

	}

	public void requestSearchWriter() {
		boolean success = false;

		success = bookDao.searchWriter();

	}

}
