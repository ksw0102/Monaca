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
@Table(name = "reply")
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 30)
	private String title;

	@Column(name = "text", length = 5000)
	private String text;

	@ManyToOne
	private User user;

	@ManyToOne
	private QandA qandA;

	public Reply() {
		super();
	}

	public Reply(Long id, String title, String text, User user, QandA qandA) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.user = user;
		this.qandA = qandA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public QandA getQandA() {
		return qandA;
	}

	public void setQandA(QandA qandA) {
		this.qandA = qandA;
	}

}
