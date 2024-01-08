package com.dw.Monaca.service.impl;

import com.dw.Monaca.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService{
private final ReplyRepository replyRepository;

@Autowired
public ReplyServiceImpl(ReplyRepository replyRepository) {
this.replyRepository = replyRepository;
}

public ResponseDto<List<Reply>> getAllReply() {
List<Reply> replies = replyRepository.findAll();
if (replies.isEmpty()) {
throw new InvalidRequestException("Reply Empty", "답변이 존재하지 않습니다.");
}
return new ResponseDto<>(ResultCode.SUCCESS.name(), replies, ResultCode.SUCCESS.getMsg());