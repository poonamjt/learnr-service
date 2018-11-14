package com.thoughtworks.learnr.services;

import com.thoughtworks.learnr.models.Trainings;
import com.thoughtworks.learnr.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TrainingService {
    TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Trainings> getAllTrainings(){
        return trainingRepository.findAll();
    }

    public Map<String,List<Trainings>> getAllGroupOfTrainings(){
        List<Trainings> trainingsList =  trainingRepository.findAll();
        Map<String, List<Trainings>> collect = trainingsList.stream().collect(
                Collectors.groupingBy(x -> x.getTrainingName())
        );

        return collect;
    }

    public void addTraining(Trainings training) {
        trainingRepository.insert(training);
    }

}
