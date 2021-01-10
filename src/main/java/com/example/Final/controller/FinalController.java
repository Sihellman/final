package com.example.Final.controller;

import com.example.Final.Service.FinalService;
import com.example.Final.config.FeatureSwitchConfiguration;
import com.example.Final.model.Person;
import com.example.Final.model.Values;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")

public class FinalController {
    private final FinalService finalService;
    public final FeatureSwitchConfiguration featureSwitchConfiguration;
    @PostMapping("/start")
    public ResponseEntity isBarMitzva(@RequestBody Person person){
        if ((person.name == "") || (person.name == null)){
            return new ResponseEntity<> ("no name", HttpStatus.UNAUTHORIZED);
        }
        else{
            return new ResponseEntity<> (finalService.isBarMitzva(person), HttpStatus.OK);
        }
    }

    @GetMapping("/time")
    public ResponseEntity timestamp(){
        return new ResponseEntity<> (finalService.timestamp(), HttpStatus.OK);
    }

    @PostMapping("/{operation}")
    public ResponseEntity math(@RequestBody Values values,
                               @PathVariable(value="operation") String operation,
                               @RequestParam Double v1){
        try{
            if(featureSwitchConfiguration.isMathUp()){
                return new ResponseEntity<>(finalService.math(operation, v1, values.getArray()), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("no math allowed here", HttpStatus.SERVICE_UNAVAILABLE);
            }
        }
        catch (HttpClientErrorException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }
}
