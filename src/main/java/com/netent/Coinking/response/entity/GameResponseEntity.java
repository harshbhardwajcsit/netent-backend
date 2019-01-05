package com.netent.Coinking.response.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.netent.Coinking.helper.GameRulesHelper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@ApiModel(description = "Entity representing a game response for each try")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResponseEntity implements Serializable {

    @ApiModelProperty("Game status(WIN,LOSS,FREE_ROUND)")
    private String gameStatus;

    @ApiModelProperty("status code for game result")
    private Integer gameCode;

    public GameResponseEntity(Integer randomInteger) {
        gameStatus = GameRulesHelper.rules.get(randomInteger);
        gameCode = randomInteger;
    }
}
