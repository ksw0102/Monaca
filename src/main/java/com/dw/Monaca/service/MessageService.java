package com.dw.Monaca.service;

import java.util.List;
import java.util.Optional;

import com.dw.Monaca.dto.MessageDto;
import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Message;


// 쪽지 기능
public interface MessageService {
// 기능 구현 예정
//	// 휴지통 따로 없이 바로 삭제
//	// 탭 메뉴 활용하여 대상을 선택 해 쪽지 발송 가능
//	// 새로운 답변 수신 시 new 또는 카운트로 알림 표시 (새로고침 필)

    // 모든 쪽지 조회
    List<Message> getAllMessages();

//    // 특정 쪽지 ID로 쪽지 조회
//    Optional<Message> getMessageById(Long messageId);
//
//    // 특정 사용자가 보낸 쪽지 목록 조회
//    List<Message> getSentMessagesByLoginId(String loginId);
//
//    // 특정 사용자가 받은 쪽지 목록 조회
//    List<Message> getReceivedMessagesByLoginId(String receiver);
//
//    // 특정 수신자에게 쪽지 전송
//    void sendMessage(String loginId, String receiver, MessageDto messageDto);
//
//    // 특정 쪽지를 읽음으로 표시
//    void markMessageAsRead(Long messageId);

    // 특정 쪽지 삭제
    ResponseDto<Message> deleteMessage(Long messageId);

//    // 모든 쪽지 삭제
//    void deleteAllMessages();
//
//    // 특정 사용자가 보낸 쪽지 삭제
//    void deleteMessagesByLoginId(String loginId);
//
//    // 특정 수신자에게 온 쪽지 삭제
//    void deleteMessagesByReceiver(String receiver);
//
//    // 특정 사용자가 특정 수신자에게 보낸 쪽지 삭제
//    void deleteMessagesByLoginIdAndReceiver(String loginId, String receiver);

}
