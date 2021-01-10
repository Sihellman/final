package com.example.Final.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import com.example.Final.Service.FinalService;
import com.example.Final.config.FeatureSwitchConfiguration;
import com.example.Final.model.Values;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.sql.Timestamp;

@ExtendWith(MockitoExtension.class)

public class FinalControllerTest {
    @Mock
    private FinalService finalService;

    @Mock
    private FeatureSwitchConfiguration featureSwitchConfiguration;

    @InjectMocks
    private FinalController subject;

    @Test
    public void timestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        when(finalService.timestamp()).thenReturn(timestamp);
        ResponseEntity actual = subject.timestamp();
        verify(finalService).timestamp();
        assertThat(actual.getStatusCode()).isEqualTo(OK);
        assertThat(actual.getBody()).isEqualTo(timestamp);
    }

//    @Test
//    public void math_returnsSum_whenPathIsAdd_andMathIsUp(){
//        Values values = Values.builder().build();
//        when(featureSwitchConfiguration.isMathUp()).thenReturn(true);
//    }

}