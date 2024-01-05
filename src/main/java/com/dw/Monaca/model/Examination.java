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

	@Column(name = "answerText", length = 500)
	private String answerText;
	
	public Examination() {
		super();
	}

	public Examination(Long id, User user, Grade grade, ExamPaper examPaper, String answerText, String submitDate,
			String score) {
		super();
		this.id = id;
		this.user = user;
		this.grade = grade;
		this.examPaper = examPaper;
		this.answerText = answerText;
		this.submitDate = submitDate;
		this.score = score;
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

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "submitDate", length = 50)
	private String submitDate;

	@Column(name = "score", length = 5)
	private String score;

	

	
}
