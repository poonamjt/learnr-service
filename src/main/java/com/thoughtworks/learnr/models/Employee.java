package com.thoughtworks.learnr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private String role;
    private String emailId;
    private Date creationDate = new Date();

    public Employee() {
    }

    public Employee(String id, String name, Date creationDate, String role, String emailId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.emailId = emailId;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() { return role; }

    public String getEmailId() {
        return emailId;
    }

    public Date getCreationDate() { return creationDate; }

    public void setId(String id) {
        this.id = id;
    }
}

