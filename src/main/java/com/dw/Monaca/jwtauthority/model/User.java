package com.dw.Monaca.jwtauthority.model;

import java.util.Set;

import com.dw.Monaca.model.Lecture;
import com.dw.Monaca.model.LectureCategory;
import com.dw.Monaca.model.UserItem;

//import com.dw.Monaca.model.Lecture;
//import com.dw.Monaca.model.LectureCategory;
//import com.dw.Monaca.model.UserItem;

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
@Table(name = "`user`")
public class User {

	@Id // 자체적으로 붙는 ID
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 회원 정보의 ID
	@Column(name = "loginId", length = 20)
	private String loginId;

	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "name", length = 50, unique = true)
	private String name;

	@Column(name = "nickname", length = 50)
	private String nickname;

	@Column(name = "birthDate", length = 50)
	private String birthDate;

	@Column(name = "gender", length = 3)
	private String gender;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "phoneNum", length = 15)
	private int phoneNum;

	@Column(name = "professorIntro", length = 50)
	private String professorIntro;

	@Column(name = "professorResume", length = 50)
	private String professorResume;

	@Column(name = "image", length = 500)
	private String image;

//	// 활성화 / 비활성화
//	@Column(name = "activated")
//	private boolean activated = false;
	@Column(name = "activated")
	private Boolean activated;

	@ManyToOne
	private UserItem userItem;

	@ManyToOne
	private LectureCategory lectureCategory;

	@ManyToMany
	@JoinTable(name = "user_authority", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;

	@ManyToMany
	@JoinTable(name = "lecture_cart", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "lecture_id") })
	private Set<Lecture> lectures;

	@ManyToMany
	@JoinTable(name = "wishlist", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "lecture_id)") })
	private Set<Lecture> wishLecture;

	public User() {
		super();
	}

	public User(Long id, String loginId, String password, String name, String nickname, String birthDate, String gender,
			String email, int phoneNum, String professorIntro, String professorResume, String image, Boolean activated,
			UserItem userItem, LectureCategory lectureCategory, Set<Authority> authorities, Set<Lecture> lectures,
			Set<Lecture> wishLecture) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.phoneNum = phoneNum;
		this.professorIntro = professorIntro;
		this.professorResume = professorResume;
		this.image = image;
		this.activated = activated;
		this.userItem = userItem;
		this.lectureCategory = lectureCategory;
		this.authorities = authorities;
		this.lectures = lectures;
		this.wishLecture = wishLecture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProfessorIntro() {
		return professorIntro;
	}

	public void setProfessorIntro(String professorIntro) {
		this.professorIntro = professorIntro;
	}

	public String getProfessorResume() {
		return professorResume;
	}

	public void setProfessorResume(String professorResume) {
		this.professorResume = professorResume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public UserItem getUserItem() {
		return userItem;
	}

	public void setUserItem(UserItem userItem) {
		this.userItem = userItem;
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

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	public Set<Lecture> getWishLecture() {
		return wishLecture;
	}

	public void setWishLecture(Set<Lecture> wishLecture) {
		this.wishLecture = wishLecture;
	}

	// 사용하지 않음
//	@ManyToOne
//	private UserItem userItem;
//	@ManyToOne
//	private LectureCategory lectureCategory;
//
//	@ManyToMany
//	@JoinTable(name = "user_authority", joinColumns = {
//			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
//					@JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
//	private Set<Authority> authorities;
//
//	@ManyToMany
//	@JoinTable(name = "lecture_cart", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "lecture_id") })
//	private Set<Lecture> lectures;
//
//	@ManyToMany
//	@JoinTable(name = "wishlist", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "lecture_id)") })
//	private Set<Lecture> wish_lecture;

}
