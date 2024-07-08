package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
    
    private final ChatgptService chatgptService;

    @GetMapping("/chat")
    public String getMethodName() {
        String responseMessage = chatgptService.multiChat(Arrays.asList(new MultiChatMessage("user", "반가워 너는 누구니?")));
        System.out.println(responseMessage);
        return "chat";
    }
}