package com.dw.Monaca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "character")
public class Character {
	
	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;
	
	@Column(name = "character_name", length = 20)
	private String character_name;

	@Column(name = "character_gender", length = 6)
	private String character_gender;

	@Column(name = "image", length = 500)
	private String image;

	public Character() {
		super();
	}

	public Character(String character_name, String character_gender, String image) {
		super();
		this.character_name = character_name;
		this.character_gender = character_gender;
		this.image = image;
	}

	public String getCharacter_name() {
		return character_name;
	}

	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}

	public String getCharacter_gender() {
		return character_gender;
	}

	public void setCharacter_gender(String character_gender) {
		this.character_gender = character_gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
