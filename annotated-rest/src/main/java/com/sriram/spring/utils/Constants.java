package com.sriram.spring.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String DUMMY_EMP = "/rest/emp/dummy";
    public static final String GET_EMP = "/rest/emp/{id}";
    public static final String GET_ALL_EMP = "/rest/emps";
    public static final String CREATE_EMP = "/rest/emp/create";
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";
}
