package com.sysman.demo.common;

public class MaterialErrorLogs {

	private String code;
	private String status;
	private String executed;
	private String propertyClass;
	private String field;
	private String message;
	private String uri;
	private String process;

	public MaterialErrorLogs(String code, String status, String executed, String propertyClass, String field,
			String message, String uri, String process) {
		this.code = code;
		this.status = status;
		this.executed = executed;
		this.propertyClass = propertyClass;
		this.field = field;
		this.message = message;
		this.uri = uri;
		this.process = process;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExecuted() {
		return executed;
	}

	public void setExecuted(String executed) {
		this.executed = executed;
	}

	public String getPropertyClass() {
		return propertyClass;
	}

	public void setPropertyClass(String propertyClass) {
		this.propertyClass = propertyClass;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialErrorLogs {\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    executed: ").append(toIndentedString(executed)).append("\n");
		sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
		sb.append("    field: ").append(toIndentedString(field)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
		sb.append("    process: ").append(toIndentedString(process)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
