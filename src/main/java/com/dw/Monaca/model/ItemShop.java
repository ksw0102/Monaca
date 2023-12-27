package com.dw.Monaca.model;

import java.util.List;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_Shop")
public class ItemShop {

	@Id // ID라는 것을 인식시켜주고 id값을 넣지 않아도 오류가 나지 않음!!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private ItemShopCategory itemShopCategory;

	@Column(name = "item_name", length = 50)
	private String item_name;

	@Column(name = "image", length = 500)
	private String image;

	@Column(name = "price", length = 50)
	private String price;

	@ManyToMany
	@JoinTable(name = "item_cart", joinColumns = { @JoinColumn(name = "item_shop_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<User> user;

	public ItemShop() {
		super();
	}

	public ItemShop(ItemShopCategory itemShopCategory, String item_name, String image, String price, List<User> user) {
		super();
		this.itemShopCategory = itemShopCategory;
		this.item_name = item_name;
		this.image = image;
		this.price = price;
		this.user = user;
	}

	public ItemShopCategory getItemShopCategory() {
		return itemShopCategory;
	}

	public void setItemShopCategory(ItemShopCategory itemShopCategory) {
		this.itemShopCategory = itemShopCategory;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
