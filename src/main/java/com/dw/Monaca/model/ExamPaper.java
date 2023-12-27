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
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;
	
	@Column(name = "title", length = 50)
	private String title;

	@Column(name = "exam_test", length = 100)
	private String exam_test;

	@Column(name = "create_at", length = 50)
	private String create_at;

	@Column(name = "exam_image", length = 500)
	private String exam_image;

	@Column(name = "is_checked")
	private boolean is_checked;

	@ManyToOne
	private Lecture lecture;
	
	public ExamPaper() {
		super();
	}

	public ExamPaper(String title, String exam_test, String create_at, String exam_image, boolean is_checked) {
		super();
		this.title = title;
		this.exam_test = exam_test;
		this.create_at = create_at;
		this.exam_image = exam_image;
		this.is_checked = is_checked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExam_test() {
		return exam_test;
	}

	public void setExam_test(String exam_test) {
		this.exam_test = exam_test;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getExam_image() {
		return exam_image;
	}

	public void setExam_image(String exam_image) {
		this.exam_image = exam_image;
	}

	public boolean isIs_checked() {
		return is_checked;
	}

	public void setIs_checked(boolean is_checked) {
		this.is_checked = is_checked;
	}

}
