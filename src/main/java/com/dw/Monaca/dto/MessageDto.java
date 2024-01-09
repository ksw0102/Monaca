package com.dw.Monaca.dto;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.validation.constraints.NotBlank;

public class MessageDto {

	@NotBlank
	private Long id;
	
	@NotBlank
	private User user;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String text;
	
	@NotBlank
	private String reciever;

	public MessageDto() {
		super();
	}

	public MessageDto(@NotBlank Long id, @NotBlank User user, @NotBlank String title, @NotBlank String text,
			@NotBlank String reciever) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.text = text;
		this.reciever = reciever;
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

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	
	
	
	
}
