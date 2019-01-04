package com.netent.Coinking.service.impl;

import com.netent.Coinking.service.CoinkingService;
import org.springframework.stereotype.Service;

@Service
public class CoinKingServiceImpl implements CoinkingService {
    @Override
    public String fetchResult() {
        return "API is working";
    }
}
