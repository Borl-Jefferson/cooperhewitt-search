package org.jointheleague.cooperhewitt.Cooperhewitt.service;

import org.jointheleague.cooperhewitt.Cooperhewitt.Repository.CHRepository;
import org.springframework.stereotype.Service;

@Service
public class CHService {

    private final CHRepository cRepo;

    public CHService(CHRepository cRepo){
        this.cRepo = cRepo;
    }

    public String getResults(String q){
        return cRepo.getResults(q);
    }

}
