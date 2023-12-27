package com.dw.Monaca.jwtauthority.model;

import java.util.Set;

import com.dw.Monaca.model.LectureCategory;

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
@Table(name = "`user`") // 현 공란
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "username", length = 50, unique = true)
	private String username;

	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "nickname", length = 50)
	private String nickname;

	@Column(name = "gender", length = 3)
	private String gender;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "birth_Date", length = 50)
	private String birth_date;

	@Column(name = "professor_intro", length = 50)
	private String professor_intro;

	@Column(name = "professor_resume", length = 50)
	private String professor_resume;

	@Column(name = "image", length = 500)
	private String image;

	@Column(name = "activated")
	private boolean activated;

	@ManyToOne
	private Character character;
	@ManyToOne
	private LectureCategory lectureCategory;

	@ManyToMany
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;

	public User() {
		super();
	}

	public User(Long userId, String username, String password, String nickname, String gender, String email,
			String birth_date, String professor_intro, String professor_resume, String image, boolean activated,
			Character character, LectureCategory lectureCategory, Set<Authority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.email = email;
		this.birth_date = birth_date;
		this.professor_intro = professor_intro;
		this.professor_resume = professor_resume;
		this.image = image;
		this.activated = activated;
		this.character = character;
		this.lectureCategory = lectureCategory;
		this.authorities = authorities;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getProfessor_intro() {
		return professor_intro;
	}

	public void setProfessor_intro(String professor_intro) {
		this.professor_intro = professor_intro;
	}

	public String getProfessor_resume() {
		return professor_resume;
	}

	public void setProfessor_resume(String professor_resume) {
		this.professor_resume = professor_resume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public LectureCategory getLectureCategory() {
		return lectureCategory;
	}

	public void setLectureCategory(LectureCategory lectureCategory) {
		this.lectureCategory = lectureCategory;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}
