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
@Table(name = "lecture_history")
public class LectureHistory {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "lecture_history_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne 
	private Lecture lecture; 

	@Column(name = "lastDate", length = 50)
	private String lastDate;
	
	@Column(name = "is_completed",length = 5)
	private boolean is_completed;

	public LectureHistory() {
		super();
	}

	public LectureHistory(Long id, User user, Lecture lecture, String lastDate, boolean is_completed) {
		super();
		this.id = id;
		this.user = user;
		this.lecture = lecture;
		this.lastDate = lastDate;
		this.is_completed = is_completed;
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

	public String getLastDate() {
		return lastDate;
	}

	public void setLast_date(String lastDate) {
		this.lastDate = lastDate;
	}

	public boolean isIs_completed() {
		return is_completed;
	}

	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}
	
	

}
