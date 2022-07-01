package com.sgarcia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgarcia.model.Message;
import com.sgarcia.service.KafkaSender;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

	private final KafkaSender kafkaSender;

	public MessageController(KafkaSender kafkaSender) {
		super();
		this.kafkaSender = kafkaSender;
	}

	@PostMapping
	public void publish(@RequestBody Message message) {
		kafkaSender.sendMessage(message.getMessage());
	}

}
