package com.nithin.integratchatgpt.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class chatGPTResquest {
    
    private String model;
    private List<Message> messages;

    public chatGPTResquest(String model, String prompt){
        this.model = model;
        this.messages = new ArrayList<Message>();
        this.messages.add(new Message("user", prompt));
    }
}
