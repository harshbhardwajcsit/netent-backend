package com.netent.Coinking.resources;

import com.netent.Coinking.response.entity.CommonResponse;
import com.netent.Coinking.response.entity.GameResponseEntity;
import com.netent.Coinking.service.CoinkingService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/coin")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Invalid Input"),
        @ApiResponse(code = 401, message = "Invalid token"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
public class CoinKingResource {

    @Autowired
    private CoinkingService coinkingService;

    @GetMapping("/result")
    public CommonResponse getPlayerResult() throws Exception {
        return coinkingService.fetchResult();
    }

}
