package com.nithin.integratchatgpt.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class chatGPTResponse {
    
    private List<Choice> Choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    
    public static class Choice{
        private int index;
        private Message message;

    }
}
