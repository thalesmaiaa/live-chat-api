package com.br.chat.adapter.in.controller;

import com.br.chat.adapter.in.dto.messages.UserMessage;
import com.br.chat.core.port.in.message.ReceiveMessagePortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Controller
@RequiredArgsConstructor
public class ChatMessageControllerAdapterIn {

    private final ReceiveMessagePortIn receiveMessagePortIn;

    @MessageMapping("/new-message/{senderId}")
    public void receiveMessage(@DestinationVariable UUID senderId, UserMessage message) {
        receiveMessagePortIn.execute(message.toDomain(senderId));
    }
}