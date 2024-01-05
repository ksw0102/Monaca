package com.dw.Monaca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecture")
public class Lecture {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "lecture_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private LectureCategory lectureCategory;

	@Column(name = "lectureName", length = 50)
	private String lectureName;

	@Column(name = "lectureDescription", length = 500)
	private String lectureDescription;

	@Column(name = "lecturePlayTime", length = 100)
	private String lecturePlayTime;

	@Column(name = "image", length = 500)
	private String image;

	@Column(name = "price", length = 20)
	private String price;

	@Column(name = "video")
	private String video;

	public Lecture() {
		super();
	}

	public Lecture(Long id, LectureCategory lectureCategory, String lectureName, String lectureDescription,
			String lecturePlayTime, String image, String price, String video) {
		super();
		this.id = id;
		this.lectureCategory = lectureCategory;
		this.lectureName = lectureName;
		this.lectureDescription = lectureDescription;
		this.lecturePlayTime = lecturePlayTime;
		this.image = image;
		this.price = price;
		this.video = video;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LectureCategory getLectureCategory() {
		return lectureCategory;
	}

	public void setLectureCategory(LectureCategory lectureCategory) {
		this.lectureCategory = lectureCategory;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureDescription() {
		return lectureDescription;
	}

	public void setLectureDescription(String lectureDescription) {
		this.lectureDescription = lectureDescription;
	}

	public String getLecturePlayTime() {
		return lecturePlayTime;
	}

	public void setLecturePlayTime(String lecturePlayTime) {
		this.lecturePlayTime = lecturePlayTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	

	
}
