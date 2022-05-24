package com.dto;

public class BookRegDto {
	private String bookId;
	private int bookGroupId;
	private String bookName;
	private String 	iSBNNo;
	private String author;
	private String category;
	private String status;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getBookGroupId() {
		return bookGroupId;
	}
	public void setBookGroupId(int bookGroupId) {
		this.bookGroupId = bookGroupId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getiSBNNo() {
		return iSBNNo;
	}
	public void setiSBNNo(String iSBNNo) {
		this.iSBNNo = iSBNNo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BookRegDto(String bookId, int bookGroupId, String bookName, String iSBNNo, String author, String category,
			String status) {
		super();
		this.bookId = bookId;
		this.bookGroupId = bookGroupId;
		this.bookName = bookName;
		this.iSBNNo = iSBNNo;
		this.author = author;
		this.category = category;
		this.status = status;
	}
public BookRegDto() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BookRegDto [bookId=" + bookId + ", bookGroupId=" + bookGroupId + ", bookName=" + bookName + ", iSBNNo="
			+ iSBNNo + ", author=" + author + ", category=" + category + ", status=" + status + "]";
}

}
