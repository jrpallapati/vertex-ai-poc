package org.pallapati.vertexaipoc.controller;

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final VertexAiGeminiChatClient geminiChatClient;

    @Autowired
    public ChatController(final VertexAiGeminiChatClient geminiChatClient) {
        this.geminiChatClient = geminiChatClient;
    }

    @GetMapping("/ai/generate")
    public String getAiResponse(@RequestParam(value = "message", defaultValue = "Tell me a joke") final String message) {
        return geminiChatClient.call(message);
    }
}
