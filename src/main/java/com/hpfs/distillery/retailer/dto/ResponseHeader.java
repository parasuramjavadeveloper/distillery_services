package com.hpfs.distillery.retailer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;


@Getter
@Setter
@ApiModel(description="Response Header")
public class ResponseHeader implements io.swagger.annotations.ResponseHeader {
	
	@ApiModelProperty(notes=" SUCCESS/FAILURE ")
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultSetType getResultSetType() {
		return resultSetType;
	}

	public void setResultSetType(ResultSetType resultSetType) {
		this.resultSetType = resultSetType;
	}

	@ApiModelProperty(notes=" Message incase of Exception")
	private String message;
	
	@ApiModelProperty(notes=" Message SINGLE/LIST")
	private ResultSetType resultSetType;
	
	public ResponseHeader(final Status status,final ResultSetType resultSetType){
		this.status =status;
		this.resultSetType = resultSetType;
	}

	public ResponseHeader(final Status status,final String message){
		this.status =status;
		this.message = message;
	}
	
	public ResponseHeader(final Status status,final String message,final ResultSetType resultSetType){
		this.message = message;
		this.status = status;
		this.resultSetType = resultSetType;
	}

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public Class<?> response() {
        return null;
    }

    @Override
    public String responseContainer() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public enum ResultSetType{LIST,SINGLE}
	public enum Status{FAILURE,SUCCESS}
	
}
