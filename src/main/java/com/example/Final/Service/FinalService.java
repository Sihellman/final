package com.example.Final.Service;

import com.example.Final.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class FinalService {
    public String isBarMitzva(Person person){
        if (person.getAge() > 13){
            return "over bar mitzva";
        }
        if(person.getAge() < 13){
            return "under bar mitzva";
        }
        else{
            return "is barmitzva";
        }
    }
    public Timestamp timestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
        public ArrayList<Double> math(String operation, Double x, ArrayList<Double> values){
            switch (operation) {
                case "add":
                    for (int i = 0; i < values.size(); i++) {
                        values.set(i, values.get(i) + x);
                    }
                    return values;
                case "subtract":
                    for(int i = 0; i < values.size(); i++){
                        values.set(i, values.get(i) - x);
                    }
                    return values;
                case "multiply":
                    for(int i = 0; i < values.size(); i++){
                        values.set(i, values.get(i) * x);
                    }
                    return values;

                case "divide":
                    for(int i = 0; i < values.size(); i++){
                        values.set(i, values.get(i) / x);
                    }
                    return values;

                default:
                    throw new HttpClientErrorException(HttpStatus.OK, "operation should be add, " +
                            "subtract, multiply, or divide");

            }
    }
}
