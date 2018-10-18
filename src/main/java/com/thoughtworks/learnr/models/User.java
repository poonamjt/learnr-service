package com.thoughtworks.learnr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "users")
public class User {

    @Id
    @NotNull
    private Long userId;

    @NotNull
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();

    public User() {
    }

    public User(long userId, String name, Date creationDate) {
        this.userId = userId;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long  userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(Map<String, String> userSettings) {
        this.userSettings = userSettings;
    }
}

