package com.study.zxxz.dto;

import java.util.List;

public class BookTypeDTO {

	private Integer bookTypeID;
	private String bookTypeName;
	private ShelfDTO shelfDTO;
	private List<BookDTO> bookList;

	@Override
	public String toString() {
		return "BookTypeDTO [bookTypeID=" + bookTypeID + ", bookTypeName=" + bookTypeName + ", bookList=" + bookList
				+ "]";
	}

	public ShelfDTO getShelfDTO() {
		return shelfDTO;
	}

	public void setShelfDTO(ShelfDTO shelfDTO) {
		this.shelfDTO = shelfDTO;
	}

	public BookTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBookTypeID() {
		return bookTypeID;
	}

	public void setBookTypeID(Integer bookTypeID) {
		this.bookTypeID = bookTypeID;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public List<BookDTO> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookDTO> bookList) {
		this.bookList = bookList;
	}

}
