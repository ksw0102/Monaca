package com.dw.Monaca.model;

import java.time.LocalDateTime;

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
@Table(name = "exam_paper")
public class ExamPaper {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "exam_paper_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "examText", length = 100)
	private String examText;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createAt;

	@Column(name = "examImage", length = 500)
	private String examImage;

	@Column(name = "is_checked")
	private boolean is_checked;

	@ManyToOne
	private Lecture lecture;

	public ExamPaper() {
		super();
	}

	public ExamPaper(Long id, String title, String examText, LocalDateTime createAt, String examImage,
			boolean is_checked, Lecture lecture) {
		super();
		this.id = id;
		this.title = title;
		this.examText = examText;
		this.createAt = createAt;
		this.examImage = examImage;
		this.is_checked = is_checked;
		this.lecture = lecture;
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

	public String getExamText() {
		return examText;
	}

	public void setExamText(String examText) {
		this.examText = examText;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public String getExamImage() {
		return examImage;
	}

	public void setExamImage(String examImage) {
		this.examImage = examImage;
	}

	public boolean isIs_checked() {
		return is_checked;
	}

	public void setIs_checked(boolean is_checked) {
		this.is_checked = is_checked;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

}
