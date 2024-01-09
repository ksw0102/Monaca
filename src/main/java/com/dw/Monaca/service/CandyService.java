package com.dw.Monaca.service;

import java.util.List;

import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Candy;

public interface CandyService {

	ResponseDto<List<Candy>> getAllCandies();

	ResponseDto<Candy> getCandyById(Long candyId);

	ResponseDto<Candy> saveCandy(Candy candy);

	ResponseDto<String> deleteCandyById(Long candyId);

}
