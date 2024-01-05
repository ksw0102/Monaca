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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_item")
public class UserItem {

	@Id
	@Column(name = "user_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private ItemShop itemShop;

	@Column
	private boolean is_wearing;

	@ManyToMany
	@JoinTable(name = "userCharacter", joinColumns = {
			@JoinColumn(name = "user_item_id", referencedColumnName = "user_item_id") }, inverseJoinColumns = {
					@JoinColumn(name = "character_id", referencedColumnName = "character_id") })
	Set<Characters> characters;

	public UserItem() {
		super();
	}

	public UserItem(Long id, ItemShop itemShop, boolean is_wearing, Set<Characters> characters) {
		super();
		this.id = id;
		this.itemShop = itemShop;
		this.is_wearing = is_wearing;
		this.characters = characters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemShop getItemShop() {
		return itemShop;
	}

	public void setItemShop(ItemShop itemShop) {
		this.itemShop = itemShop;
	}

	public boolean isIs_wearing() {
		return is_wearing;
	}

	public void setIs_wearing(boolean is_wearing) {
		this.is_wearing = is_wearing;
	}

	public Set<Characters> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Characters> characters) {
		this.characters = characters;
	}

}
