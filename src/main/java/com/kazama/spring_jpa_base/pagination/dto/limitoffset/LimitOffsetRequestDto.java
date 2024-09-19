package com.kazama.spring_jpa_base.pagination.dto.limitoffset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimitOffsetRequestDto {
 
    
    private Integer pageNumber;

    private Integer rowsPerPage;
}
