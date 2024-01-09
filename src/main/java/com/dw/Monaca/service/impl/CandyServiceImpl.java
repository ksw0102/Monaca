package com.dw.Monaca.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.enumStatus.ResultCode;
import com.dw.Monaca.exception.InvalidRequestException;
import com.dw.Monaca.model.Candy;
import com.dw.Monaca.repository.CandyRepository;
import com.dw.Monaca.service.CandyService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CandyServiceImpl implements CandyService {

	private final CandyRepository candyRepository;
	
	public CandyServiceImpl(CandyRepository candyRepository) {
		this.candyRepository = candyRepository;
	}
	
	 // 모든 캔디 목록을 가져옴.
    @Override
    public ResponseDto<List<Candy>> getAllCandies() {
        List<Candy> candies = candyRepository.findAll();
        if (candies.isEmpty()) {
            throw new InvalidRequestException("Candy empty", "캔디가 존재하지 않습니다.");
        }
        return new ResponseDto<>(ResultCode.SUCCESS.name(), candies, ResultCode.SUCCESS.getMsg());
    }

    // 특정 캔디 ID에 해당하는 캔디를 가져옴.
    @Override
    public ResponseDto<Candy> getCandyById(Long candyId) {
        Optional<Candy> optionalCandy = candyRepository.findById(candyId);
        if (optionalCandy.isPresent()) {
            Candy candy = optionalCandy.get();
            return new ResponseDto<>(ResultCode.SUCCESS.name(), candy, ResultCode.SUCCESS.getMsg());
        } else {
            // 존재하지 않는 캔디에 대한 예외 처리
            throw new InvalidRequestException("캔디를 찾을 수 없습니다.", "Candy with ID " + candyId + " does not exist.");
        }
    }

    // 캔디를 저장함.
    @Override
    public ResponseDto<Candy> saveCandy(Candy candy) {
        // 입력된 캔디 객체가 null이 아닌지 확인
        if (candy != null) {
            // 저장된 캔디 객체를 반환
            return new ResponseDto<>(ResultCode.SUCCESS.name(), candyRepository.save(candy), ResultCode.SUCCESS.getMsg());
        } else {
            // 입력된 캔디 객체가 null인 경우 예외 처리
            throw new InvalidRequestException("캔디를 저장할 수 없습니다.", "Candy object is null.");
        }
    }

    // 특정 캔디 ID에 해당하는 캔디를 삭제함. // 삭제 후에는 삭제 성공 여부와 메시지만을 전달하면 되기 때문에 <Candy>가 아닌 <String>을 넣어줌
    public ResponseDto<String> deleteCandyById(Long candyId) {
        // 캔디 ID에 해당하는 캔디가 존재하는지 확인
        if (candyRepository.existsById(candyId)) {
            // 캔디 ID에 해당하는 캔디를 삭제하고 성공 메시지를 반환
            candyRepository.deleteById(candyId);
            return new ResponseDto<>(ResultCode.SUCCESS.name(), "캔디가 성공적으로 삭제되었습니다.", ResultCode.SUCCESS.getMsg());
        } else {
            // 캔디 ID에 해당하는 캔디가 존재하지 않으면 예외 처리
            throw new InvalidRequestException("캔디를 삭제할 수 없습니다.", "Candy with ID " + candyId + " does not exist.");
        }
    }
	
}
