package com.netent.Coinking.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "playerDataTable")
public final class PlayerModel implements Serializable {

    @Id
    private String id;

    private String name;

    private String gameStatus;

    private Date recordedOn;

}
