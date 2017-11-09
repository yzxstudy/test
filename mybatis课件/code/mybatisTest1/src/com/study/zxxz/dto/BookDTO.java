package com.study.zxxz.dto;

public class BookDTO {

	private Integer bookID;
	private String name;
	private Integer bookTypeID;
	private String bookTypeName;
	private double price;
	private String img;
	private String description;

	@Override
	public String toString() {
		return "BookDTO [bookID=" + bookID + ", name=" + name + ", bookTypeID=" + bookTypeID + ", bookTypeName="
				+ bookTypeName + ", price=" + price + ", img=" + img + ", description=" + description + "]";
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBookTypeID() {
		return bookTypeID;
	}

	public void setBookTypeID(Integer bookTypeID) {
		this.bookTypeID = bookTypeID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
}