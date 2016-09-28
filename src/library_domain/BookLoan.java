package library_domain;

import java.sql.Date;

public class BookLoan {
	
	private int loanNumber;
	private String bookLoanTF = "F";
	private String adminId;
	private int userBarCode;
	private int bookBarCode;
	private Date bookLoanDate;
	
	public BookLoan(int loanNumber, String bookLoanTF, String adminId, int userBarCode, int bookBarCode,
			Date bookLoanDate) {
		
		this.loanNumber = loanNumber;
		this.bookLoanTF = bookLoanTF;
		this.adminId = adminId;
		this.userBarCode = userBarCode;
		this.bookBarCode = bookBarCode;
		
		
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getBookLoanTF() {
		return bookLoanTF;
	}

	public void setBookLoanTF(String bookLoanTF) {
		this.bookLoanTF = bookLoanTF;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public int getUserBarCode() {
		return userBarCode;
	}

	public void setUserBarCode(int userBarCode) {
		this.userBarCode = userBarCode;
	}

	public int getBookBarCode() {
		return bookBarCode;
	}

	public void setBookBarCode(int bookBarCode) {
		this.bookBarCode = bookBarCode;
	}

	public Date getBookLoanDate() {
		return bookLoanDate;
	}

	public void setBookLoanDate(Date bookLoanDate) {
		this.bookLoanDate = bookLoanDate;
	}
	
	
	
	
}
