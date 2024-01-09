//package com.dw.Monaca.model;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//
//// candy_points를 얻을 수 있는 방법은 출석, 우수성적(A), 회원등급(이건 테이블을 따로 만들어야 될 듯)
//// candy_points를 사용하는 것은 item_shop에서 물건을 구매할 때 차감
//// 그렇기 때문에 candy_points 단독적으로 관리하는 엔티티가 필요함.
//@Entity
//@Table(name = "candy_point")
//public class CandyPoint {
//
//	@Id
//	@Column(name = "candy_point_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne
//	private Attendance attendance;
//	
//	@ManyToOne
//	private Candy candy;
//	
//	@ManyToOne
//	private Examination examination;
//	
//	@ManyToOne
//	private ItemShop itemShop;
//	
//	// candyPoint를 획득한 포인트인지 사용한 포인트인지 나타냄. 
//	// (양수이면 획득한 포인트, 음수이면 사용한 포인트)
//	@Column(name = "useHistory", nullable = false)
//	private int useHistory;
//	
//	//특정 이벤트에 대한 설명이나 추가적인 메모
//	@Column(name = "description")
//	private String description;
//	
//	@Column(nullable = false , updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	private LocalDateTime timeStamp;
//
//	public CandyPoint() {
//		super();
//	}
//
//	public CandyPoint(Long id, Attendance attendance, Candy candy, Examination examination, ItemShop itemShop,
//			int useHistory, String description, LocalDateTime timeStamp) {
//		super();
//		this.id = id;
//		this.attendance = attendance;
//		this.candy = candy;
//		this.examination = examination;
//		this.itemShop = itemShop;
//		this.useHistory = useHistory;
//		this.description = description;
//		this.timeStamp = timeStamp;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Attendance getAttendance() {
//		return attendance;
//	}
//
//	public void setAttendance(Attendance attendance) {
//		this.attendance = attendance;
//	}
//
//	public Candy getCandy() {
//		return candy;
//	}
//
//	public void setCandy(Candy candy) {
//		this.candy = candy;
//	}
//
//	public Examination getExamination() {
//		return examination;
//	}
//
//	public void setExamination(Examination examination) {
//		this.examination = examination;
//	}
//
//	public ItemShop getItemShop() {
//		return itemShop;
//	}
//
//	public void setItemShop(ItemShop itemShop) {
//		this.itemShop = itemShop;
//	}
//
//	public int getUseHistory() {
//		return useHistory;
//	}
//
//	public void setUseHistory(int useHistory) {
//		this.useHistory = useHistory;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public LocalDateTime getTimeStamp() {
//		return timeStamp;
//	}
//
//	public void setTimeStamp(LocalDateTime timeStamp) {
//		this.timeStamp = timeStamp;
//	}
//	
//	
//}
