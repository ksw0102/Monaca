package com.dw.Monaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dw.Monaca.dto.ResponseDto;
import com.dw.Monaca.model.Candy;
import com.dw.Monaca.service.CandyService;

@RestController
@CrossOrigin(origins="http://localhost:3000",
methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/candies")
public class CandyController {

    private final CandyService candyService;

    @Autowired
    public CandyController(CandyService candyService) {
        this.candyService = candyService;
    }

    // candy List 불러오기
    @GetMapping 
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseDto<List<Candy>> getAllCandies() {
        return candyService.getAllCandies();
    }

    // candyId를 이용해 특정한 candy 불러오기
    @GetMapping("/{candyId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseDto<Candy> getCandyById(@PathVariable Long candyId) {
        return candyService.getCandyById(candyId);
    }

    // candy 생성하여 저장
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseDto<Candy> saveCandy(@RequestBody Candy candy) {
        return candyService.saveCandy(candy);
    }

    // candy 삭제
    @DeleteMapping("/{candyId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseDto<String> deleteCandyById(@PathVariable Long candyId) {
        return candyService.deleteCandyById(candyId);
    }
}