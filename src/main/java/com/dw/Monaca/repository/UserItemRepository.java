package com.dw.Monaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.Monaca.model.UserItem;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {
	// 엔티티그래프로 유저테이블을 불러오기
	// 디스코드 유저 레퍼지토리 참고
}
