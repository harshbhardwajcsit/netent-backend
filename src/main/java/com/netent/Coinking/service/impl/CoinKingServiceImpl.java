package com.netent.Coinking.service.impl;

import com.netent.Coinking.GameResponseEntity;
import com.netent.Coinking.service.CoinkingService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CoinKingServiceImpl implements CoinkingService {
    @Override
    public GameResponseEntity fetchResult() {
        final int[] RATES = {1, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        Random random = new Random();
        int result = RATES[random.nextInt(RATES.length)];
        return new GameResponseEntity(result);
    }
}
