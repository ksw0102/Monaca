package com.dw.Monaca.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candy")
public class Candy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "candy_name", length = 10)
	private String candy_name;

	@Column(name = "image")
	private String image;

	@ManyToMany
	@JoinTable(name = "candy_point", joinColumns = {
			@JoinColumn(name = "candy_id", referencedColumnName = "candy_id") }, inverseJoinColumns = {
					@JoinColumn(name = "attendance_id", referencedColumnName = "attendance_id") })
	Set<Attendance> attendances;

	public Candy() {
		super();
	}

	public Candy(Long id, String candy_name, String image, Set<Attendance> attendances) {
		super();
		this.id = id;
		this.candy_name = candy_name;
		this.image = image;
		this.attendances = attendances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCandy_name() {
		return candy_name;
	}

	public void setCandy_name(String candy_name) {
		this.candy_name = candy_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

}
