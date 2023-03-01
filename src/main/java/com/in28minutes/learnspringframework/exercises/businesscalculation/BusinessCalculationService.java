package com.in28minutes.learnspringframework.exercises.businesscalculation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
//@Component
@Service
public class BusinessCalculationService {
    DataService1 dataService;
    public BusinessCalculationService(DataService1 dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
