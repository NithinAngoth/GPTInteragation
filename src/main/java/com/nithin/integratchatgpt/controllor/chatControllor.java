package com.nithin.integratchatgpt.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.nithin.integratchatgpt.dto.chatGPTResponse;
import com.nithin.integratchatgpt.dto.chatGPTResquest;

import org.springframework.ui.Model;;

@Controller
@RequestMapping("/chat")
public class chatControllor {

    @Value("${chatgpt.model}")
    private String model;

    @Value("${chatgpt.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/openapi")
    public String fetch(@RequestParam("prompt") String value, Model modle) {
        System.out.println("Received prompt: " + value);
        chatGPTResquest request = new chatGPTResquest(model, value);
        chatGPTResponse response = restTemplate.postForObject(url, request, chatGPTResponse.class);

        if (response != null && !response.getChoices().isEmpty()) {
            modle.addAttribute("response", response.getChoices().get(0).getMessage().getContent());
        } else {
            modle.addAttribute("response", "No valid response received from the chatGPT service.");
        }
        return "index";
    }
}
