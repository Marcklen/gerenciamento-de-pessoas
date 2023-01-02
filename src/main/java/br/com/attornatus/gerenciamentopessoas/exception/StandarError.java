package br.com.attornatus.gerenciamentopessoas.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandarError {

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime timeStamp;
	private Integer status;
	private String error;
	private String path;

	public StandarError(LocalDateTime timeStamp, Integer status, String error, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getPath() {
		return path;
	}
}
