package com.projectx.webflux.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Employee {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private String address;
    private Double salary;
    private Date insertedTime;
    private Date updatedTime;
    private Boolean status;
}