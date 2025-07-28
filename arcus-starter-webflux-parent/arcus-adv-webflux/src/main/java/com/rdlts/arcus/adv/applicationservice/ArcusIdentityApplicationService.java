package com.rdlts.arcus.adv.applicationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * ArcusIdentityApplicationService
 *
 * @author wangjialong
 * @since 2025/7/24 10:38
 */
@Service
public class ArcusIdentityApplicationService {

    private final WebClient webClient;

    @Autowired
    public ArcusIdentityApplicationService(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder.build();
    }

    public Mono<String> callIdentityApi(String path) {
        return webClient.get()
                .uri(path)
                .retrieve()
                .bodyToMono(String.class);
    }
}
