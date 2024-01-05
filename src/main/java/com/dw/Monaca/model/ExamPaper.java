package com.dw.Monaca.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam_paper")
public class ExamPaper {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "exam_paper_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;
	
	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "examTest", length = 100)
	private String examTest;

	@Column(name = "createAt", length = 50)
	private String createAt;

	@Column(name = "examImage", length = 500)
	private String examImage;

	@Column(name = "is_checked")
	private boolean is_checked;

	@ManyToOne
	private Lecture lecture;
	
	public ExamPaper() {
		super();
	}

	public ExamPaper(Long id, String title, String examTest, String createAt, String examImage, boolean is_checked,
			Lecture lecture) {
		super();
		this.id = id;
		this.title = title;
		this.examTest = examTest;
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

	public String getExamTest() {
		return examTest;
	}

	public void setExamTest(String examTest) {
		this.examTest = examTest;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
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
