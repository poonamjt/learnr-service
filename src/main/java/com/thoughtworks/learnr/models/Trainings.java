package com.thoughtworks.learnr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "trainings")
public class Trainings {

    @Id
    private String id;
    private String trainingName;
    private Date date;
    private String location;
    private int trainerCount;
    private int participantCount;
    private String trainingForRoles;

    public Trainings() {
    }

    public Trainings(String id, String trainingName, Date date, String location, int trainerCount, int participantCount, String trainingForRoles) {
        this.id = id;
        this.trainingName = trainingName;
        this.date = date;
        this.location = location;
        this.trainerCount = trainerCount;
        this.participantCount = participantCount;
        this.trainingForRoles = trainingForRoles;
    }

    public String getId() {
        return id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getTrainerCount() {
        return trainerCount;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public String getTrainingForRoles() {
        return trainingForRoles;
    }

    public void setTrainingId(String id) {
        this.id = id;
    }
}


