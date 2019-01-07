package com.netent.Coinking.service;

import com.netent.Coinking.request.PlayerRecordSaveRequest;
import com.netent.Coinking.response.entity.CommonResponse;

public interface CoinkingService {
    public CommonResponse fetchResult();

    public CommonResponse savePlayerData(PlayerRecordSaveRequest playerRecordSaveRequest) throws Exception;

    public CommonResponse getPlayerData();
}
