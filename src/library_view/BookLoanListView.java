package library_view;

import java.util.ArrayList;

import library_domain.Book;

public class BookLoanListView {

	public void searchedLoanList(ArrayList<Book> bookList) {
		
		System.out.println("\n[대출 내역 보기]");
		System.out.println("책이름\t 저자 \t 출판사\t 장르 ");
		if (bookList.size() == 0) {
			System.out.println("나의 정보가 없습니다.");
		} else {

			for (int i = 0; i < bookList.size(); i++) {
				System.out.print(bookList.get(i).getBookName() + "\t");
				System.out.print(bookList.get(i).getBookAuthor() + "\t");
				System.out.print(bookList.get(i).getBookPublisher() + "\t");
				System.out.println(bookList.get(i).getGenreCode());
			}
		}

	}

}
