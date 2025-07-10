package edu.wgu.d387_sample_code.entity;

import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer roomNumber;

	@NotNull
	private String price;

	@NotNull
	private String cPrice;

	@NotNull
	private String ePrice;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ReservationEntity> reservationEntityList;

	public RoomEntity() {
	}

	public RoomEntity(Integer roomNumber, String price, String cPrice, String ePrice) {
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

	public String getPrice() {
		return price;
	}
	public String getcPrice() {
		return cPrice;
	}
	public String getePrice() {
		return ePrice;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	public void setcPrice(String price) {
		this.cPrice = price;
	}
	public void setePrice(String price) {
		this.ePrice = price;
	}


	public List<ReservationEntity> getReservationEntityList() {
		return reservationEntityList;
	}

	public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
		this.reservationEntityList = reservationEntityList;
	}

	public void addReservationEntity(ReservationEntity reservationEntity) {
		if (null == reservationEntityList)
			reservationEntityList = new ArrayList<>();

		reservationEntityList.add(reservationEntity);
	}

}