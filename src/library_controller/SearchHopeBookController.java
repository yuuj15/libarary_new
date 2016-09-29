package library_controller;

import java.util.ArrayList;

import library_dao.SearchHopeBookDao;
import library_domain.SearchBook;
import library_view.AlertView;
import library_view.HopeBookListView;

public class SearchHopeBookController {
	
	private SearchHopeBookDao searchHopeBookDao;
	
	public SearchHopeBookController(){
		
		searchHopeBookDao = new SearchHopeBookDao();
		
	}
	
	//희망 도서 페이지
	public void requestHopeBookList(){
		
		HopeBookListView hopeBookListView = new HopeBookListView();
		hopeBookListView.hopeBookListMenu();
	}
	
	//희망 도서 자료검색(책이름으로)
	public void requestSearchBookName(String searchedBookName){
		
		ArrayList<SearchBook> SearchBookList = searchHopeBookDao.searchedBookName(searchedBookName);
		HopeBookListView hopeBookListView = new HopeBookListView();
		hopeBookListView.searchedBookNameList(SearchBookList);
		
	}

	//희망 도서 자료 검색(저자로)
	public void requestSearchedAuthor(String searchedAuthor) {
		
		//리스트로 받아온 값을 전달
		ArrayList<SearchBook> searchBookList = searchHopeBookDao.searchedAuthor(searchedAuthor);
		HopeBookListView hopeBookListView = new HopeBookListView();
		hopeBookListView.searchedBookNameList(searchBookList);
		
	}

	//원하는 자료의 정보를 REQUESTBOOK의 DB로 저장한다.
	public void requestSaveToDB(int searchedBookNumber, int hopeCountNumber) {
		
		boolean success = searchHopeBookDao.bookInfoSaveToDB(searchedBookNumber, hopeCountNumber);
		
		if(success){
			new AlertView().alert("희망도서 신청 성공");
			Controllers.getLoginControlles().requestMainLogin();
		}else{
			new AlertView().alert("희망도서 신청 실패");
			requestHopeBookList();
		}
		
	}
}
