package com.netent.Coinking.service.impl;

import com.netent.Coinking.config.MongoConfig;
import com.netent.Coinking.model.PlayerModel;
import com.netent.Coinking.request.PlayerRecordSaveRequest;
import com.netent.Coinking.response.entity.CommonResponse;
import com.netent.Coinking.response.entity.GameResponseEntity;
import com.netent.Coinking.service.CoinkingService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CoinKingServiceImpl implements CoinkingService {
    @Override
    public CommonResponse fetchResult() {
        GameResponseEntity gameResponseEntity = new GameResponseEntity(getGameResult(), getFreeRound());
        return CommonResponse.success(null, gameResponseEntity);
    }

    @Override
    public CommonResponse savePlayerData(PlayerRecordSaveRequest recordSaveRequest) throws Exception {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName(recordSaveRequest.getName());
        playerModel.setGameStatus(recordSaveRequest.getGameStatus());

        MongoConfig mongoConfig = new MongoConfig();
        mongoConfig.mongoOperations().save(playerModel, "playerDataTable");
        return CommonResponse.success(null);
    }

    @Override
    public CommonResponse getPlayerData() {
        return null;
    }

    private int getFreeRound() {
        final int[] RATES = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Random random = new Random();
        return RATES[random.nextInt(RATES.length)];
    }

    private int getGameResult() {
        final int[] RATES = {2, 2, 2, 3, 3, 3, 3, 3, 3, 3};
        Random random = new Random();
        return RATES[random.nextInt(RATES.length)];
    }
}
