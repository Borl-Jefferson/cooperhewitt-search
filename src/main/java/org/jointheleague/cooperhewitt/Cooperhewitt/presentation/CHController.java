package org.jointheleague.cooperhewitt.Cooperhewitt.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.jointheleague.cooperhewitt.Cooperhewitt.service.CHService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CHController {

    private final CHService cCon;

    public CHController(CHService cCon) {
        this.cCon = cCon;
    }

    @GetMapping("/searchCHResults")
    @Operation(description = "Searches for items matching the search term",
            summary = "Response may include multiple result values."
            //responses = ApiResponse.
             )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result(s) found"),
            @ApiResponse(responseCode = "404", description = "Result(s) not found")
    })
    public String getResults(@RequestParam(value="q") String q){
        return cCon.getResults(q);
    }

}
