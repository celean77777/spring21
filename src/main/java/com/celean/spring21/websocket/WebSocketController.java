package com.celean.spring21.websocket;

import com.celean.spring21.models.Product;
import com.celean.spring21.services.FileService;
import com.celean.spring21.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web-socket")
public class WebSocketController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ProductService productService;
    private final FileService fileService;

    @MessageMapping("/createfile")
    @SendTo("/topic/getProducts" )

    public String createNewFile(String fileName) {
        fileService.saveProductFile(fileName + ".xlsx", productService.getProducts());
        return "New file - " + fileName + " - created at: " + System.currentTimeMillis();
    }


    @GetMapping(value = "/getProductFile", produces = "application/octet-stream")
    public void getFile() {
        byte[] fileByte;
        try {
            fileByte = fileService.getFileData();
        } catch (IOException e) {
            fileByte = new byte[] {};
        }

        simpMessagingTemplate.convertAndSend("/topic/greetings", fileByte);
    }


}
