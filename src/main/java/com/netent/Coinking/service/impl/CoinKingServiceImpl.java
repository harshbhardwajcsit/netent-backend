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
        final int[] RATES = {2, 2, 2, 3, 3, 3, 3, 3, 3, 3};
        Random random = new Random();
        int finalResult;
        int result = RATES[random.nextInt(RATES.length)];
        if (result == 2) {
            final int[] FREE_ROUND = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int result2 = RATES[random.nextInt(FREE_ROUND.length)];
            if (result2 == 1) {
                finalResult = 1;
            } else {
                finalResult = 2;
            }
        } else {
            finalResult = 3;
        }

        GameResponseEntity gameResponseEntity = new GameResponseEntity(finalResult);
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
}
