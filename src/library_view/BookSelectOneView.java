package library_view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import library_domain.BookDetail;

public class BookSelectOneView {

	public void outputOneBook(BookDetail bookInfo) {

		if (bookInfo.getBookLoanTF().equals("f")) {

			System.out.println("책이름\t  책저자\t  출판사\t  장르\t  대출여부\t  대출날짜\t  반납예정날짜");
			System.out.print(bookInfo.getBookName() + "\t");
			System.out.print(bookInfo.getBookAuthor() + "\t");
			System.out.print(bookInfo.getBookPublisher() + "\t");
			System.out.print(bookInfo.getGenreName() + "\t");
			System.out.print(bookInfo.getBookLoanTF() + "\t");
			System.out.print(bookInfo.getBookLoanDate() + "\t");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(bookInfo.getBookLoanDate());
			cal.add(Calendar.DATE, 14);
			String loanDay = format.format(cal.getTime());
			System.out.println(loanDay);

		} else {
			System.out.println("책이름\t  책저자\t  출판사\t  장르\t  대출여부");
			System.out.print(bookInfo.getBookName() + "\t");
			System.out.print(bookInfo.getBookAuthor() + "\t");
			System.out.print(bookInfo.getBookPublisher() + "\t");
			System.out.print(bookInfo.getGenreName() + "\t");
			System.out.print(bookInfo.getBookLoanTF() + "\t");
			System.out.println("");
		}
	}

}
