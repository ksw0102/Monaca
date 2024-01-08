package com.dw.Monaca.model;

import java.time.LocalDateTime;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "material")
public class Material {

	@Id
	@Column(name = "material_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Lecture Lecture;

	@Column(name = "title", length = 30)
	private String title;

	@Column(name = "text", length = 5000)
	private String text;

	@Column(name = "image")
	private String image;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createAt;

	@Column(name = "is_reservation")
	private boolean is_reservation;

	public Material() {
		super();
	}

	public Material(Long id, User user, com.dw.Monaca.model.Lecture lecture, String title, String text, String image,
			LocalDateTime createAt, boolean is_reservation) {
		super();
		this.id = id;
		this.user = user;
		Lecture = lecture;
		this.title = title;
		this.text = text;
		this.image = image;
		this.createAt = createAt;
		this.is_reservation = is_reservation;
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
		return Lecture;
	}

	public void setLecture(Lecture lecture) {
		Lecture = lecture;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public boolean isIs_reservation() {
		return is_reservation;
	}

	public void setIs_reservation(boolean is_reservation) {
		this.is_reservation = is_reservation;
	}

}
