package com.kazama.spring_jpa_base.common.utils;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    
    private String tableName;
    private List<String> columns;
    private String whereClause;
    private List<String> joinClauses; // 存储多个连接
    private List<String> onClauses; // 存储多个连接条件
    private boolean isCount;
    private List<String> ctes; // 存储多个 CTE 定义


    private QueryBuilder(){
        this.columns = new ArrayList<>();
        this.joinClauses = new ArrayList<>();
        this.onClauses = new ArrayList<>();
        this.ctes = new ArrayList<>(); // 初始化 CTE 列表
        this.isCount = false;
    }
 

    public static QueryBuilder select(String ...columns){
        QueryBuilder queryBuilder = new QueryBuilder();
        for(String column:columns){
            queryBuilder.columns.add(column);
        }
        return queryBuilder;
    }

    public QueryBuilder from(String tableName) {
        this.tableName = tableName;
        return this;
    }
    // where clause
    public QueryBuilder where(QueryParameter queryParameter) {
        this.whereClause = queryParameter.build();
        return this;
    }

    public QueryBuilder innerJoin(String joinTable) {
        joinClauses.add("INNER JOIN " + joinTable); // 添加到连接列表
        return this;
    }

    // left join
    public QueryBuilder leftJoin(String joinTable) {
        joinClauses.add("LEFT JOIN " + joinTable); // 添加到连接列表
        return this;
    }

    // right join
    public QueryBuilder rightJoin(String joinTable) {
        joinClauses.add("RIGHT JOIN " + joinTable); // 添加到连接列表
        return this;
    }

    public QueryBuilder on(String leftColumn, String rightColumn) {
        onClauses.add(" ON " + leftColumn + " = " + rightColumn); // 添加到条件列表
        return this;
    }

    public String fetch() {
        return build(false); // false 表示 fetch 查询
    }

    // count 方法
    public String count() {
        return build(true); // true 表示 count 查询
    }

    public QueryBuilder with(String cteDefinition) {
        this.ctes.add(cteDefinition); // 添加到 CTE 列表
        return this;
    }


    private String build(boolean countQuery) {
        StringBuilder sql = new StringBuilder();

        // 添加 CTE
        if (!ctes.isEmpty()) {
            sql.append("WITH ");
            sql.append(String.join(", ", ctes)); // 将多个 CTE 用逗号连接
            sql.append(" "); // 在 CTE 之后添加空格
        }

        // 处理 count 查询
        if (countQuery) {
            sql.append("SELECT COUNT(*)");
        } 
        // 处理 fetch 查询
        else {
            sql.append("SELECT ");
            sql.append(String.join(", ", columns)); // 添加选择的列
        }

        // from 表
        sql.append(" FROM ").append(tableName);

        for (int i = 0; i < joinClauses.size(); i++) {
            sql.append(" ").append(joinClauses.get(i));
            if (i < onClauses.size()) {
                sql.append(onClauses.get(i)); // 添加对应的 on 条件
            }
        }

        // where 子句
        if (whereClause != null && !whereClause.isEmpty()) {
            sql.append(" WHERE ").append(whereClause);
        }

        return sql.toString();
    }
}
