package com.dw.Monaca.model;

import java.util.Set;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private User user;

	@Column(name = "time_stamp", length = 50)
	private String time_stamp;

	@ManyToMany
	@JoinTable(name = "candy_point", joinColumns = {
			@JoinColumn(name = "attendance_id", referencedColumnName = "attendance_id") }, inverseJoinColumns = {
					@JoinColumn(name = "candy_id", referencedColumnName = "candy_id") })
	Set<Candy> candies;

	public Attendance() {
		super();
	}

	public Attendance(Long id, User user, String time_stamp, Set<Candy> candies) {
		super();
		this.id = id;
		this.user = user;
		this.time_stamp = time_stamp;
		this.candies = candies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	public Set<Candy> getCandies() {
		return candies;
	}

	public void setCandies(Set<Candy> candies) {
		this.candies = candies;
	}

}
