package org.jointheleague.cooperhewitt.Cooperhewitt.Repository;

import io.swagger.v3.core.util.Json;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChObject;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChResponse;
import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto.ChResult;
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
        ArrayList<Object> res = graphQlClient.document("{object(title:\""+q+"\"){title,description}}")
                .retrieve("object")
                .toEntity(ArrayList.class)
                .block();
ArrayList<ChResult> chr = new ArrayList<ChResult>();
        for(int i = 0; i<res.size(); i++){
            chr.add(parse(res.get(i).toString()));
        }

        for(int i = 0; i<chr.size(); i++){
            chr.get(i).printAll();
        }
        return "good";
    }

    /*{title=[{date=[{from=2023, to=2023, value=2023-07-29}], language=ENGLISH, type=Descriptive title, value=Spoon}],
    description=[{type=general description, value=Pointed oval bowl, partly fluted then twisted stem terminating in acanthus scrolls below the circular crusher terminal.}]}
     */

    private ChResult parse(String in){
        String date = "Not Provided";
        String desc = "broken";
        String parts[] = in.split("description=");
        String titleVals[] = parts[0].split("type=Descriptive title, ");
        try {
            date = titleVals[0].substring(titleVals[0].indexOf("value=") + 6, titleVals[0].indexOf("}"));
        }catch (Exception e){
        }
        String title = titleVals[1].substring(titleVals[1].indexOf("value=")+6, titleVals[1].indexOf("}"));
        try {
            desc = parts[1].substring(parts[1].indexOf("value=") + 6, parts[1].indexOf("}"));
        }catch (Exception e){
            desc = parts[1].substring(0, parts[1].indexOf("}"));
        }



        return new ChResult(date, title, desc);
    }

}