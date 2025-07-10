package edu.wgu.d387_sample_code.model.response;

import edu.wgu.d387_sample_code.model.Links;

;

public class ReservableRoomResponse {

	private Long id;
	private Integer roomNumber;
	private Integer price;
	private Integer cPrice;
	private Integer ePrice;
	private Links links;
	
	public ReservableRoomResponse() {
		super();
	}
	
	public ReservableRoomResponse(Integer roomNumber, Integer price, Integer cPrice, Integer ePrice) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
		this.cPrice = cPrice;
		this.ePrice = ePrice;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getcPrice() {
		return cPrice;
	}
	public Integer getePrice() {
		return ePrice;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setcPrice(Integer cPrice) {
		this.price = cPrice;
	}
	public void setePrice(Integer ePrice) {
		this.price = ePrice;
	}

	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	
	
}
