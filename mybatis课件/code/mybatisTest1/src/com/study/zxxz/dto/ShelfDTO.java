package com.study.zxxz.dto;

public class ShelfDTO {

	private Integer shelfID;
	private String shelfName;
	private String shelfAddress;
	private Integer bookTypeID;

	public Integer getBookTypeID() {
		return bookTypeID;
	}

	public void setBookTypeID(Integer bookTypeID) {
		this.bookTypeID = bookTypeID;
	}

	public Integer getShelfID() {
		return shelfID;
	}

	public void setShelfID(Integer shelfID) {
		this.shelfID = shelfID;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public String getShelfAddress() {
		return shelfAddress;
	}

	public void setShelfAddress(String shelfAddress) {
		this.shelfAddress = shelfAddress;
	}

	@Override
	public String toString() {
		return "ShelfDTO [shelfID=" + shelfID + ", shelfName=" + shelfName + ", shelfAddress=" + shelfAddress
				+ ", bookTypeID=" + bookTypeID + "]";
	}

}
