package com.dw.Monaca.model;

// 답안지 제출용, exam이랑 grade를 일괄 관리하기 위해 사용
import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "examination")
public class Examination {
	
	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@Column(name = "examination_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	
	private Long id;
	@ManyToOne
	private User user;

	@ManyToOne
	private Grade grade;

	@ManyToOne
	private ExamPaper examPaper;

	@Column(name = "answer_text", length = 500)
	private String answer_text;

	@Column(name = "submit_date", length = 50)
	private String submit_date;

	@Column(name = "score", length = 5)
	private String score;

	public Examination() {
		super();
	}

	public Examination(User user, Grade grade, ExamPaper examPaper, String answer_text, String submit_date,
			String score) {
		super();
		this.user = user;
		this.grade = grade;
		this.examPaper = examPaper;
		this.answer_text = answer_text;
		this.submit_date = submit_date;
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

	public String getAnswer_text() {
		return answer_text;
	}

	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}

	public String getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
