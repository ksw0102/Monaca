package com.dw.Monaca.model;

import com.dw.Monaca.jwtauthority.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "'user_item")
public class UserItem {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne
		private ItemShop itemShop;
		
		@ManyToOne
		private User user;
		
		@Column
		private boolean is_wearing;

		public UserItem() {
			super();
		}

		public UserItem(Long id, ItemShop itemShop, User user, boolean is_wearing) {
			super();
			this.id = id;
			this.itemShop = itemShop;
			this.user = user;
			this.is_wearing = is_wearing;
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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isIs_wearing() {
			return is_wearing;
		}

		public void setIs_wearing(boolean is_wearing) {
			this.is_wearing = is_wearing;
		}
		
		
	
}
