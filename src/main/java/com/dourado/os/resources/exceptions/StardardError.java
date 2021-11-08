package com.dourado.os.resources.exceptions;

import java.io.Serializable;

public class StardardError implements Serializable {
	private static final long serialVersionUID = 1L;
//Momento em que recebeu o erro
	private Long timestamp;
	private Integer status;
	private String error;

	public StardardError() {
		super();

	}

	public StardardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}