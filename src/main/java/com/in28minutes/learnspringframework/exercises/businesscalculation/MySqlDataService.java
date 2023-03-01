package com.in28minutes.learnspringframework.exercises.businesscalculation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MySqlDataService implements DataService1 {

    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
