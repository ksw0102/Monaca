package com.dw.Monaca.model;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "'class_room'")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Lecture lecture;
	
	@Column(name = "is_completed")
	private boolean is_completed;
	
	@Column(name = "progress_rate")
	private double progress_rate;

	public ClassRoom() {
		super();
	}

	public ClassRoom(Long id, User user, Lecture lecture, boolean is_completed, double progress_rate) {
		super();
		this.id = id;
		this.user = user;
		this.lecture = lecture;
		this.is_completed = is_completed;
		this.progress_rate = progress_rate;
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

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public boolean isIs_completed() {
		return is_completed;
	}

	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}

	public double getProgress_rate() {
		return progress_rate;
	}

	public void setProgress_rate(double progress_rate) {
		this.progress_rate = progress_rate;
	}
	
	

}
