package com.sriram.spring.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    private int id;
    private String name;
    @Getter(onMethod_ = {@JsonSerialize(using = DateSerializer.class)})
    private Date createdDate;
}
