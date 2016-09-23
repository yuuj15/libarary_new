package library_view;

import library_controller.Controllers;

public class BooksearchView {

	public int search() {
		int number = 0;
		if(number ==1){
			System.out.println("책이름검색 :");
			Controllers.getBookController().reqestSearchBook();
		}else if(number ==2){
			System.out.println("저자 검색:");
			Controllers.getBookController().requestSearchWriter();
		}
		return number;
		
	}
		
}
