package com.dw.Monaca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_shop_category")
public class ItemShopCategory {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@Column(name = "category_name", length = 50)
	private String cagegory_name;

	public ItemShopCategory() {
		super();
	}

	public ItemShopCategory(String cagegory_name) {
		super();
		this.cagegory_name = cagegory_name;
	}

	public String getCagegory_name() {
		return cagegory_name;
	}

	public void setCagegory_name(String cagegory_name) {
		this.cagegory_name = cagegory_name;
	}

}
