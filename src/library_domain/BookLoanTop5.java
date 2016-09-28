package library_domain;

public class BookLoanTop5 {
	
	private int rownum;
	private String bookName;
	
	public BookLoanTop5(){
		
	}
	
	public BookLoanTop5(int rownum, String bookName) {
		
		this.rownum = rownum;
		this.bookName = bookName;

	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	
}
