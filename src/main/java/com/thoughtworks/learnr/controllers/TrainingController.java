package com.thoughtworks.learnr.controllers;

import com.thoughtworks.learnr.models.Trainings;
import com.thoughtworks.learnr.services.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/trainings")
public class TrainingController {
    TrainingService trainingService;

    public TrainingController(TrainingService trainingService){this.trainingService = trainingService;}

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Trainings> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, List<Trainings>> getAllGroupOfTrainings() {
//        return trainingService.getAllGroupOfTrainings();
//    }

    @RequestMapping(value = "/addTraining", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addItem(@Valid @RequestBody Trainings training )
    {
        trainingService.addTraining(training);
        return new ResponseEntity( training.getId(), HttpStatus.CREATED );
    }

}
