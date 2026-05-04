package org.jointheleague.cooperhewitt.Cooperhewitt.Repository.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title"
})
@Generated("jsonschema2pojo")
public class ChObject {

   // @JsonProperty("title")
   // private List<String> title;

    @JsonProperty("title")
    public String getTitle() {
        return "title";
    }

    @JsonProperty("title")
    public void setTitle(List<String> title) {
        //this.title = title;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChObject.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
       // sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}