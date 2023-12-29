package com.dw.Monaca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "q_and_a_bin")
public class QandABin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private QandA qandA;

	public QandABin() {
		super();
	}

	public QandABin(Long id, QandA qandA) {
		super();
		this.id = id;
		this.qandA = qandA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QandA getQandA() {
		return qandA;
	}

	public void setQandA(QandA qandA) {
		this.qandA = qandA;
	}

}
