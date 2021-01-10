package com.example.Final.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Values {
    public ArrayList<Double> array;


}
