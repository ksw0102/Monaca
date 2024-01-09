//package com.dw.Monaca.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dw.Monaca.dto.ResponseDto;
//import com.dw.Monaca.enumStatus.ResultCode;
//import com.dw.Monaca.exception.InvalidRequestException;
//import com.dw.Monaca.jwtauthority.model.User;
//import com.dw.Monaca.jwtauthority.repository.UserRepository;
//import com.dw.Monaca.model.ExamPaper;
//import com.dw.Monaca.repository.ExamPaperRepository;
//import com.dw.Monaca.service.ExamPaperService;
//
//import jakarta.transaction.Transactional;
//
//@Service
//@Transactional
//public class ExamPaperServiceImpl implements ExamPaperService {
//	private final ExamPaperRepository examPaperRepository;
//	private final UserRepository userRepository;
//
//	@Autowired
//	public ExamPaperServiceImpl(ExamPaperRepository examPaperRepository, UserRepository userRepository) {
//		this.examPaperRepository = examPaperRepository;
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public ResponseDto<Void> createExamPaper(ExamPaper exampaper, String loginId) {
//		User user = userRepository.findByLoginId(loginId);
//		if (user != null && user.getAuthorities().equals("ROLE_PROFESSOR")) {
//			examPaperRepository.save(exampaper);
//			return new ResponseDto<>(ResultCode.SUCCESS.name(), null, ResultCode.SUCCESS.getMsg());
//		} else {
//			return new ResponseDto<>(ResultCode.UNAUTHORIZED.name(), null, "권한이 없습니다.");
//		}
//	}
//
//	public ResponseDto<List<ExamPaper>> getAllExamPaper() {
//		List<ExamPaper> examPapers = examPaperRepository.findAll();
//		if (examPapers.isEmpty()) {
//			throw new InvalidRequestException("ExamPaper Empty", "시험지가 존재하지 않습니다.");
//		}
//		return new ResponseDto<>(ResultCode.SUCCESS.name(), examPapers, ResultCode.SUCCESS.getMsg());
//	}
//
//}
