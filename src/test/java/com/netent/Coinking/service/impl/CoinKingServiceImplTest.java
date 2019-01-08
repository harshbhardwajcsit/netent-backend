package com.netent.Coinking.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CoinKingServiceImplTest {

    @InjectMocks
    private CoinKingServiceImpl coinKingService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}