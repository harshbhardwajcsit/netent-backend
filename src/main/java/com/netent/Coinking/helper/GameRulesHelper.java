package com.netent.Coinking.helper;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GameRulesHelper {
    public static final Map<Integer, String> rules = ImmutableMap.<Integer, String>builder()
            .put(1, "FREE ROUND")
            .put(2, "WIN")
            .put(3, "LOST")
            .build();
}
