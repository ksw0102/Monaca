package com.dw.Monaca.model;

import java.util.Set;

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
	@Column(name = "item_shop_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // databases마다 만드는 방법이 달라서 표기해줘야 함!
	private Long id;

	@ManyToOne
	private ItemCategory itemShopCategory;

	@Column(name = "itemName", length = 50)
	private String itemName;

	@Column(name = "image", length = 500)
	private String image;

	@Column(name = "price", length = 50)
	private String price;

	@ManyToMany
	@JoinTable(name = "item_cart", joinColumns = {
			@JoinColumn(name = "item_shop_id", referencedColumnName = "item_shop_id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	private Set<User> users;

	public ItemShop() {
		super();
	}

	public ItemShop(Long id, ItemCategory itemShopCategory, String itemName, String image, String price,
			Set<User> users) {
		super();
		this.id = id;
		this.itemShopCategory = itemShopCategory;
		this.itemName = itemName;
		this.image = image;
		this.price = price;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemCategory getItemShopCategory() {
		return itemShopCategory;
	}

	public void setItemShopCategory(ItemCategory itemShopCategory) {
		this.itemShopCategory = itemShopCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItem_name(String itemName) {
		this.itemName = itemName;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
