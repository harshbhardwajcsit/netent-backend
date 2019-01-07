package com.netent.Coinking.response.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.netent.Coinking.helper.GameRulesHelper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Entity representing a game response for each try")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResponseEntity implements Serializable {

    @ApiModelProperty("Game status(WIN,LOSS)")
    private String gameStatus;

    @ApiModelProperty("status code for game result")
    private Integer gameCode;

    private Boolean isFreeRound;

    public GameResponseEntity(Integer result, Integer freeRound) {
        gameStatus = GameRulesHelper.rules.get(result);
        gameCode = result;
        if (freeRound == 1) {
            isFreeRound = true;
        }
    }
}
