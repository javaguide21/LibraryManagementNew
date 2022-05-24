package com.dto;

import java.util.Date;

public class BookTnxDto {
	private String bookId;
	private int memberId;
	private Date borrowdate;
	private Date returndate;
	private Date duedate;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getReturndate() {
		return returndate;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public BookTnxDto(String bookId, int memberId, Date borrowdate, Date returndate, Date duedate) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
		this.borrowdate = borrowdate;
		this.returndate = returndate;
		this.duedate = duedate;
	}
public BookTnxDto() {
}
@Override
public String toString() {
	return "BookTnxDto [bookId=" + bookId + ", memberId=" + memberId + ", borrowdate=" + borrowdate + ", returndate="
			+ returndate + ", duedate=" + duedate + "]";
}

}
