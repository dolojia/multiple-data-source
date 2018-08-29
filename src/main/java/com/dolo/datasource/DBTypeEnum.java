package com.dolo.datasource;

public enum DBTypeEnum {

    dataSource1("dataSource1"), dataSource2("dataSource2");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
