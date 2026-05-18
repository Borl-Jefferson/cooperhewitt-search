package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import io.swagger.v3.core.util.Json;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChObject;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChResponse;
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
    //HttpGraphQlClient graphQlClient = HttpGraphQlClient.create(webClient);

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
        ArrayList<LinkedHashMap> chr = graphQlClient.document("{object(title:\""+q+"\"){title,description}}")
                .retrieve("data")
                .toEntity(ArrayList.class)
                .block();

        for(int i = 0; i<chr.size(); i++){
            System.out.println("\n\n - "+chr.get(i));
        }

        return "good";
    }

    private String[] parse(String in){
        String date = " ";
        return null;
    }

}