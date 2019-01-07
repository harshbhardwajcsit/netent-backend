package com.netent.Coinking.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PlayerRecordSaveRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String gameStatus;
}
