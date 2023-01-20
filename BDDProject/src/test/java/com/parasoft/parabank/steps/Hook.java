package com.parasoft.parabank.steps;

import com.parasoft.parabank.core.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {



    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("executing scenario " + scenario.getName());

        DriverInstance.getBrowserDriver("chrome");


    }

    @After
    public void afterScenario(Scenario scenario){

        //DriverInstance.kill();


        System.out.println("scenario " + scenario.getName() + " got " + scenario.getStatus());
    }
}
