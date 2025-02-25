package com.deepfocus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-focus") // Endpoint WebSocket
                .setAllowedOrigins("*") // Permite conexão de qualquer origem (ajuste isso em produção)
                .withSockJS(); // Habilita fallback para navegadores que não suportam WebSocket nativo
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Define prefixo para mensagens enviadas aos clientes
        registry.setApplicationDestinationPrefixes("/app"); // Prefixo para mensagens enviadas pelo cliente ao servidor
    }
}
