package com.kazama.spring_jpa_base.common.utils;

import java.util.Objects;

import org.hibernate.query.QueryParameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationUtils {

    private Integer limit;

    private Integer offset;

    private Integer pageNumber;

    private Integer rowsPerPage;

    public PaginationUtils( Integer pageNumber,Integer rowsPerPage) {
        this.pageNumber = pageNumber;
        this.rowsPerPage = rowsPerPage;
        this.limit = rowsPerPage;
        this.offset = (pageNumber - 1) * rowsPerPage;
    }

    
 public PaginationUtils addPageNumber(Integer pageNumber) {
        if (Objects.isNull(pageNumber)) {
            pageNumber = 1;
        }
        this.pageNumber = pageNumber;
        return this;
    }

    public PaginationUtils addRowsPerPage(Integer rowsPerPage) {
        if (Objects.isNull(rowsPerPage)) {
            rowsPerPage = 10;
        }
        this.rowsPerPage = rowsPerPage;
        return this;
    }


    public  PaginationUtils build(){
        return new PaginationUtils(pageNumber, rowsPerPage);

    }
}
