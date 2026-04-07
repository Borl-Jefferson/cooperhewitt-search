package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class CHRepository {

    //private final WebClient webClient;
    //private static final String baseUrl = "https://api.cooperhewitt.org/?query={object(title:\"spoon\"){title,description}}";
    private static final String baseUrl = "https://api.cooperhewitt.org";
    WebClient webClient = WebClient.create(baseUrl);
    HttpGraphQlClient graphQlClient = HttpGraphQlClient.create(webClient);

    public CHRepository(){
        /*webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();*/
    }

    public String getResults(String q){

        HttpGraphQlClient graphQlClient = HttpGraphQlClient
                .builder(webClient)
                .build();

// Perform requests with graphQlClient...


        System.out.println(
                graphQlClient.document("{object(description:\""+q+"\"){title,description}}")
                        .retrieve("object")
                        .toEntity(Object.class)
                        .block()
        );

        return "fin";
    }

}
