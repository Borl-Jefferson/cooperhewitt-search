package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class CHRepository {

    private final WebClient webClient;
    private static final String baseUrl = "https://api.cooperhewitt.org/?query={object(title:spoon){description}}";

    public CHRepository(){
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public String getResults(String q){
        System.out.println(webClient.get()
                /* .uri(uriBuilder -> uriBuilder
                         .queryParam("title", q)
                         .queryParam("at", "results")
                         .queryParam("q", q)
                         .build()
                 )*/
                .retrieve()
                .bodyToMono(String.class)
                .block());

        return "fin";
    }

}
