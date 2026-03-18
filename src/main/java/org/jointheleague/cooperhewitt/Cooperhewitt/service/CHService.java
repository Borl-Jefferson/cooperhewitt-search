package org.jointheleague.cooperhewitt.Cooperhewitt.service;

import org.springframework.stereotype.Service;

@Service
public class CHService {

    public String getResults(String q){
        return ("Searching for items relating to: "+q);
    }

}
