package library_domain;

public class SearchBook {
	
	private int searchBookNumber;
	private String searchBookName;
	private String searchBookAuthor;
	private String searchBookPublisher;
	private int searchBookPrice;
	
	public SearchBook(){
		
	}

	public SearchBook(int searchBookNumber, String searchBookName, String searchBookAuthor, String searchBookPublisher,
			int searchBookPrice) {
		
		this.searchBookNumber = searchBookNumber;
		this.searchBookName = searchBookName;
		this.searchBookAuthor = searchBookAuthor;
		this.searchBookPublisher = searchBookPublisher;
		this.searchBookPrice = searchBookPrice;
		
	}

	public int getSearchBookNumber() {
		return searchBookNumber;
	}

	public void setSearchBookNumber(int searchBookNumber) {
		this.searchBookNumber = searchBookNumber;
	}

	public String getSearchBookName() {
		return searchBookName;
	}

	public void setSearchBookName(String searchBookName) {
		this.searchBookName = searchBookName;
	}

	public String getSearchBookAuthor() {
		return searchBookAuthor;
	}

	public void setSearchBookAuthor(String searchBookAuthor) {
		this.searchBookAuthor = searchBookAuthor;
	}

	public String getSearchBookPublisher() {
		return searchBookPublisher;
	}

	public void setSearchBookPublisher(String searchBookPublisher) {
		this.searchBookPublisher = searchBookPublisher;
	}

	public int getSearchBookPrice() {
		return searchBookPrice;
	}

	public void setSearchBookPrice(int searchBookPrice) {
		this.searchBookPrice = searchBookPrice;
	}
	
	
}
