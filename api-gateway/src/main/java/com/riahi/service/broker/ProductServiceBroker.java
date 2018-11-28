package com.riahi.service.broker;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.riahi.model.Categorie;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jalel Eddine
 *
 * 27 nov. 2018
 */

@Service
@Slf4j
@EnableBinding(ApiStreamTopicConfig.class)
public class ProductServiceBroker {

	private final MessageChannel OUTPUT_ID_CAT ;
	private final MessageChannel OUTPUT_CAT ;
	
	public ProductServiceBroker(ApiStreamTopicConfig apiStreamTopicConfig) {
		
		this.OUTPUT_ID_CAT = apiStreamTopicConfig.outboundIdCategorie() ; 
		this.OUTPUT_CAT = apiStreamTopicConfig.outboundCategorie() ;
	}
	
	public void sendCategorie( Categorie categorie) throws Exception {
		
		try {
			
			MessageChannel messageChannel = OUTPUT_CAT ;

			messageChannel.send(MessageBuilder
					.withPayload(categorie)
						.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
							.build());
	
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		
	}
	
	 public void sendIdToDelete(Long id) {
		
		MessageChannel messageChannel = OUTPUT_ID_CAT ;
		messageChannel.send(MessageBuilder
				.withPayload(id)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
						.build());
		
		
	} 
}
