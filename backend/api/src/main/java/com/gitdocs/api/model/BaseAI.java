package com.gitdocs.api.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class BaseAI {

    @Value("classpath:prompts/instructions.txt")
    private Resource promptFile;

    protected String systemPrompt;

    @PostConstruct
    protected void loadInstructions() {
        try {
            this.systemPrompt = promptFile.getContentAsString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            this.systemPrompt = "";
        }
    }

    public String generateResponse(String input) {
        return "This is a response from the base AI model. Please implement the generateResponse method in the derived class.";
    }
}
