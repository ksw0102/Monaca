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
@Table(name = "q_and_a")
public class QandA {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Lecture lecture;

	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "text", length = 1000)
	private String text;

	@Column(name = "create_at")
	private String create_at;

	@Column(name = "disposable_pw", length = 10)
	private String disposable_pw;

	@Column(name = "is_hide")
	private boolean is_hide;

	public QandA() {
		super();
	}

	public QandA(Long id, User user, Lecture lecture, String title, String text, String create_at, String disposable_pw,
			boolean is_hide) {
		super();
		this.id = id;
		this.user = user;
		this.lecture = lecture;
		this.title = title;
		this.text = text;
		this.create_at = create_at;
		this.disposable_pw = disposable_pw;
		this.is_hide = is_hide;
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

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getDisposable_pw() {
		return disposable_pw;
	}

	public void setDisposable_pw(String disposable_pw) {
		this.disposable_pw = disposable_pw;
	}

	public boolean isIs_hide() {
		return is_hide;
	}

	public void setIs_hide(boolean is_hide) {
		this.is_hide = is_hide;
	}

}
