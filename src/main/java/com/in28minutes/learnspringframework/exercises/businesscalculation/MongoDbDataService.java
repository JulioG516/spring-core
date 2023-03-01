package com.in28minutes.learnspringframework.exercises.businesscalculation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MongoDbDataService implements DataService1 {
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44 , 55};
    }
}
