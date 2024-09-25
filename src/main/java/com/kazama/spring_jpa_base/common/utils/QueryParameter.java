package com.kazama.spring_jpa_base.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class QueryParameter {
 private List<String> conditions;

    public QueryParameter() {
        this.conditions = new ArrayList<>();
    }

    // 添加等於條件
    public QueryParameter addEqual(String value, String column) {
        conditions.add(column + " = '" + value + "'");
        return this;
    }

    // 添加大於條件
    public QueryParameter addGreaterThan(String value, String column) {
        conditions.add(column + " > '" + value + "'");
        return this;
    }

    // 添加LIKE條件
    public QueryParameter addLike(String value, String column) {
        conditions.add(column + " LIKE '%" + value + "%'");
        return this;
    }

    // 組裝所有條件為一個 SQL 字串
    public String build() {
        if (conditions.isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(" AND ");
        for (String condition : conditions) {
            joiner.add(condition);
        }
        return joiner.toString();
    }}
