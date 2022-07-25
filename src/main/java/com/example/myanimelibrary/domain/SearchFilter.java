package com.example.myanimelibrary.domain;

import java.util.List;

public class SearchFilter {
    private String field;
    private FilterOperationMode operator;
    private String value;
    private List<String> values;

    public SearchFilter(String field, FilterOperationMode operator, String value, List<String> values) {
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.values = values;
    }

    public SearchFilter() {
    }

    public String getField() {
        return field;
    }

    public FilterOperationMode getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public List<String> getValues() {
        return values;
    }
}
