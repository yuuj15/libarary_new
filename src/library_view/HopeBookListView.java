package library_view;

import java.util.ArrayList;
import java.util.Scanner;

import library_controller.Controllers;
import library_domain.SearchBook;

public class HopeBookListView {

	private Scanner keyboard;

	public HopeBookListView(){

		keyboard = new Scanner(System.in);

	}

	public void hopeBookListMenu() {

		System.out.println("[ 희망 도서 페이지 ]");
		System.out.println("[ 1. 책이름으로 찾기, 2. 저자로 찾기, 3. 메인페이지 ]");
		int selectedMenu = keyboard.nextInt();

		switch(selectedMenu){

		case 1:
			System.out.println("책이름으로 찾기 페이지 입니다.");

			System.out.println("찾으시는 책이름을 검색하세요: ");
			String searchedBookName = keyboard.next();
			Controllers.getSearchHopeBookController().requestSearchBookName(searchedBookName);
			break;

		case 2:
			System.out.println("저자로 찾기 페이지 입니다.");

			System.out.println("찾으시는 저자를 검색하세요: ");
			String searchedAuthor = keyboard.next();
			Controllers.getSearchHopeBookController().requestSearchedAuthor(searchedAuthor);
			break;

		case 3:
			Controllers.getLoginControlles().requestMainLogin();
			break;

		default:
			System.out.println("메뉴를 다시 선택해 주세요.");
		}

	}

	public void searchedBookNameList(ArrayList<SearchBook> searchBookList) {

		//ArrayList값을 받아와서 뿌려준다.
		System.out.println("            [ 검색하신 자료  ]           ");
		System.out.println("------------------------------------");

		if(searchBookList.size() == 0){

			System.out.println("찾으시는 제품이 없습니다.");

		} else{

			System.out.println("[ 검색번호   | 책이름   | 책저자  | 출판사  | 가격 ]");
			for(int i = 0; i < searchBookList.size(); i++){

				System.out.print(" " +searchBookList.get(i).getSearchBookNumber() + "\t");
				System.out.print(searchBookList.get(i).getSearchBookName() + "\t");
				System.out.print(searchBookList.get(i).getSearchBookAuthor() + "\t");
				System.out.print(searchBookList.get(i).getSearchBookPublisher() + "\t");
				System.out.println(searchBookList.get(i).getSearchBookPrice());

			}

			//희망하는 검색 번호를 선택해서 RequestBook table로 책정보를 넘긴다.
			System.out.println("---------------------------------------");
			System.out.println("[ 1. 희망하는 책 번호 선택, 2. 희망 도서 페이지 ]");
			int selectMenuNumber = keyboard.nextInt();

			switch(selectMenuNumber){

			case 1: 
				System.out.println("원하시는 책 번호를 선택하세요: ");
				int searchedBookNumber = keyboard.nextInt();
				System.out.println("신청하실 책 갯수를 입력해주세요: ");
				int hopeCountNumber = keyboard.nextInt();
				
				Controllers.getSearchHopeBookController().requestSaveToDB(searchedBookNumber, hopeCountNumber);
				break;
				
			case 2:
				hopeBookListMenu();
				break;
				
			default:
				System.out.println("메뉴를 다시 선택해 주세요.");

			}


		}




	}


}
