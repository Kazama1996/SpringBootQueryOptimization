package com.kazama.spring_jpa_base.entityManagerQuery.service.impl;

import java.util.List;

import com.kazama.spring_jpa_base.common.utils.QueryBuilder;
import com.kazama.spring_jpa_base.common.utils.QueryParameter;
import com.kazama.spring_jpa_base.employee.entity.Employee;
import com.kazama.spring_jpa_base.entityManagerQuery.service.EntityManagerService;
import com.querydsl.core.support.QueryBase;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EntityManagerServiceImpl implements EntityManagerService {


    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String query() {
        // TODO Auto-generated method stub
        QueryParameter queryParameter = new QueryParameter()
                .addEqual("adam", "my_table.id")
                .addGreaterThan("2023-01-01", "my_table.created_date");

        // 定义多个 CTE
        String cte1 = "cte_name1 AS (SELECT * FROM my_table WHERE created_date > '2023-01-01')";
        String cte2 = "cte_name2 AS (SELECT * FROM cte_name1 WHERE some_column = 'some_value')";

        // 生成 fetch 查询
        QueryBuilder qBuilder = QueryBuilder.select("id", "name") // 添加选择的列
                .with(cte1) // 添加第一个 CTE
                .with(cte2) // 添加第二个 CTE
                .from("cte_name2") // 使用最后一个 CTE 作为表
                .leftJoin("other_table") // 添加左连接
                .on("cte_name2.id", "other_table.foreign_key") // 指定左连接条件
                .innerJoin("join_table2") // 添加内连接
                .on("join_table2.id", "cte_name2.id") // 指定内连接条件
                .where(queryParameter); // 添加条件


     
        String query = qBuilder.fetch();
        String countQuery = qBuilder.count();

        

        return query+"\n"+countQuery;
        
    }

    private void test(){
    



    }
    
}
