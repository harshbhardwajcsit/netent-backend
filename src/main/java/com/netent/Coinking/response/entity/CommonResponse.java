package com.netent.Coinking.response.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Entity representing response if all inputs were valid")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<TYPE extends Serializable> {

    public enum OperationStatus {
        SUCCESS, FAILURE
    }

    @ApiModelProperty(value = "Any relevant message related to the overall state of operation")
    private final String message;

    @ApiModelProperty(value = "Status of operation, either SUCCESS or FAILURE")
    private final OperationStatus status;

    @ApiModelProperty(value = "Any entity or data associated with success of operation")
    private final TYPE data;

    public static <TYPE extends Serializable> CommonResponse<TYPE> failure(String message) {
        return CommonResponse.failure(message, null);
    }

    public static <TYPE extends Serializable> CommonResponse<TYPE> failure(String message, TYPE data) {
        return new CommonResponse<>(message, OperationStatus.FAILURE, data);
    }

    public static CommonResponse success(String message) {
        return CommonResponse.success(message, null);
    }

    public static <TYPE extends Serializable> CommonResponse<TYPE> success(String message, TYPE data) {
        return new CommonResponse<>(message, OperationStatus.SUCCESS, data);
    }

    public CommonResponse(String message, OperationStatus status) {
        this(message, status, null);
    }

    public CommonResponse(String message, OperationStatus status, TYPE data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public TYPE getData() {
        return data;
    }
}
