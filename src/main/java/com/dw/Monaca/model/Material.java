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
@Table(name = "material")
public class Material {

	@Id
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

	@Column(name = "create_at")
	private String create_at;

	@Column(name = "is_reservation")
	private String is_reservation;

	public Material() {
		super();
	}

	public Material(Long id, User user, com.dw.Monaca.model.Lecture lecture, String title, String text, String image,
			String create_at, String is_reservation) {
		super();
		this.id = id;
		this.user = user;
		Lecture = lecture;
		this.title = title;
		this.text = text;
		this.image = image;
		this.create_at = create_at;
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

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getIs_reservation() {
		return is_reservation;
	}

	public void setIs_reservation(String is_reservation) {
		this.is_reservation = is_reservation;
	}

}
