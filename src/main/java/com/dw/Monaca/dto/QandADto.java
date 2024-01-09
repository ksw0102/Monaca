package com.dw.Monaca.dto;

import com.dw.Monaca.jwtauthority.model.User;
import com.dw.Monaca.model.Lecture;

import jakarta.validation.constraints.NotBlank;

public class QandADto {
	
	@NotBlank
	private User user;
	
	@NotBlank
	private Lecture lecture;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String text;
	
	@NotBlank
	private String disposablePw;
	
	@NotBlank
	private boolean is_hide;

	public QandADto() {
		super();
	}

	public QandADto(@NotBlank User user, @NotBlank Lecture lecture, @NotBlank String title, @NotBlank String text,
			@NotBlank String disposablePw, @NotBlank boolean is_hide) {
		super();
		this.user = user;
		this.lecture = lecture;
		this.title = title;
		this.text = text;
		this.disposablePw = disposablePw;
		this.is_hide = is_hide;
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

	public String getDisposablePw() {
		return disposablePw;
	}

	public void setDisposablePw(String disposablePw) {
		this.disposablePw = disposablePw;
	}

	public boolean isIs_hide() {
		return is_hide;
	}

	public void setIs_hide(boolean is_hide) {
		this.is_hide = is_hide;
	}

	
	
}
