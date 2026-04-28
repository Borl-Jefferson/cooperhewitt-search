package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import com.apollographql.java.client.ApolloClient;
import io.swagger.v3.core.util.Json;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChObject;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChResponse;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.Data;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;


@Repository
public class CHRepository {

    ApolloClient client = new ApolloClient.Builder()
            .serverUrl("https://api.cooperhewitt.org")
  .build();

    //private final WebClient webClient;
    //private static final String baseUrl = "https://api.cooperhewitt.org/?query={object(title:\"spoon\"){title,description}}";

    //HttpGraphQlClient graphQlClient = HttpGraphQlClient.create(webClient);

    public CHRepository(){


    }

    public String getResults(String q) {
        /*HttpGraphQlClient graphQlClient = HttpGraphQlClient
                .builder(webClient)
                .build();
        ArrayList<String> chr =
                graphQlClient.document("{object(title:\"" + q + "\"){title,description}}")
                .retrieve("object")
                .toEntity(ArrayList.class)
                .block();*/

        client.query(new MyQuery()).enqueue(response -> {
            if (response.data != null) {
                // Handle (potentially partial) data
                System.out.println(response.data);
            } else {
                // Something wrong happened
                if (response.exception != null) {
                    // Handle non-GraphQL errors, e.g. network issues
                    response.exception.printStackTrace();
                } else {
                    // Handle GraphQL errors in response.errors
                    System.out.println(response.getErrors().get(0));
                }
            }
        });

        return "good";
    }
}
