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

	@Column(name = "lecture_name", length = 50)
	private String lecture_name;

	@Column(name = "lecture_description", length = 500)
	private String lecture_description;

	@Column(name = "lecture_play_time", length = 100)
	private String lecture_play_time;

	@Column(name = "image", length = 500)
	private String image;

	@Column(name = "price", length = 20)
	private String price;

	@Column(name = "video")
	private String video;

	public Lecture() {
		super();
	}

	public Lecture(Long id, LectureCategory lectureCategory, String lecture_name, String lecture_description,
			String lecture_play_time, String image, String price, String video) {
		super();
		this.id = id;
		this.lectureCategory = lectureCategory;
		this.lecture_name = lecture_name;
		this.lecture_description = lecture_description;
		this.lecture_play_time = lecture_play_time;
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

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public String getLecture_description() {
		return lecture_description;
	}

	public void setLecture_description(String lecture_description) {
		this.lecture_description = lecture_description;
	}

	public String getLecture_play_time() {
		return lecture_play_time;
	}

	public void setLecture_play_time(String lecture_play_time) {
		this.lecture_play_time = lecture_play_time;
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
