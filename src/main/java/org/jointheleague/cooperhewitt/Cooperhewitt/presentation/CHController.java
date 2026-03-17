package org.jointheleague.cooperhewitt.Cooperhewitt.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CHController {

    @GetMapping("/searchCHResults")
    public String getResults(@RequestParam(value="q") String q){
        return ("Searching for items relating to: "+q);
    }

}
