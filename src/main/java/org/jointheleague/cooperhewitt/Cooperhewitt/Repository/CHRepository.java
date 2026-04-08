package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import io.swagger.v3.core.util.Json;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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
ArrayList<LinkedHashMap> ar = graphQlClient.document("{object(title:\""+q+"\"){title,description}}")
        .retrieve("object")
        .toEntity(ArrayList.class)
        .block();

        System.out.println(ar.size());
       // System.out.println(ar.get(3).get(ar.get(0).keySet()));

for (Object x : ar.get(3).keySet()) {
    ArrayList<LinkedHashMap> list = (ArrayList<LinkedHashMap>) ar.get(3).get(x);
    System.out.println("- "+ar+"\n"+list+"\n"+list.get(0).get("value"));
}
        return ar.toString();
    }

}
