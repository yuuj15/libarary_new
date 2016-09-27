package library_view;

import java.util.ArrayList;

import library_domain.BookLoanTop5;

public class BookTop5List {

	public void top5List(ArrayList<BookLoanTop5> bookLoans) {
		
		System.out.println("[ **** Top5 대출 현황  **** ]");
		System.out.println("");
		System.out.println("[ 순위  | 책 제목 ]");
		
		for(int i = 0; i < bookLoans.size(); i++){
		
			System.out.print("   " + bookLoans.get(i).getRownum() + "   ");
			System.out.println(bookLoans.get(i).getBookName());
			
		}
		
		
	}
	
}
