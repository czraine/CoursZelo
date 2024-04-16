package com.example.courszelo.Controller;

import com.example.courszelo.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chatbot")
    public ResponseEntity<?> chat(@RequestBody Map<String, String> json) {
        String userMessage = json.get("message");
        String response = chatService.getChatbotResponse(userMessage);

        return ResponseEntity.ok(response);
    }
}
