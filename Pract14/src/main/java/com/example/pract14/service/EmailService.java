package com.example.pract14.service;

import com.example.pract14.entity.MarketDB;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//21

@Service
public class EmailService {

    @Async
    public void sendEmail(MarketDB marketDB){
        //имитация отсылания email
    }
}
