package com.kazama.spring_jpa_base.pagination.controller;

import com.kazama.spring_jpa_base.pagination.dto.limitoffset.LimitOffsetRequestDto;

import org.springframework.http.ResponseEntity;

public interface PaginationController {
    
    public ResponseEntity<?> queryWithLimitOffset(LimitOffsetRequestDto requestDto);
}
