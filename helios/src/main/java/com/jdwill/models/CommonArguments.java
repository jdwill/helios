package com.jdwill.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * A model of arguments required by all LevelMoney APIs.
 * @author Jason Williams
 *
 */
@JsonRootName(value="args")
public class CommonArguments {
	private Long uid = 1110590645L;
	private String token = "6ABE85ADE9BA81D81EC8C54C6046E1B7";
	private String api_token = "AppTokenForInterview";
	private boolean json_strict_mode = false;	
	private boolean json_verbose_response = false;
	
	@JsonProperty("uid")
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	@JsonProperty("token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@JsonProperty("api-token")
	public String getApi_token() {
		return api_token;
	}
	public void setApi_token(String api_token) {
		this.api_token = api_token;
	}
	@JsonProperty("json-strict-mode")
	public boolean isJson_strict_mode() {
		return json_strict_mode;
	}
	public void setJson_strict_mode(boolean json_strict_mode) {
		this.json_strict_mode = json_strict_mode;
	}
	@JsonProperty("json-verbose-response")
	public boolean isJson_verbose_response() {
		return json_verbose_response;
	}
	public void setJson_verbose_response(boolean json_verbose_response) {
		this.json_verbose_response = json_verbose_response;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((api_token == null) ? 0 : api_token.hashCode());
		result = prime * result + (json_strict_mode ? 1231 : 1237);
		result = prime * result + (json_verbose_response ? 1231 : 1237);
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonArguments other = (CommonArguments) obj;
		if (api_token == null) {
			if (other.api_token != null)
				return false;
		} else if (!api_token.equals(other.api_token))
			return false;
		if (json_strict_mode != other.json_strict_mode)
			return false;
		if (json_verbose_response != other.json_verbose_response)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CommonArguments [uid=" + uid + ", token=" + token + ", api_token=" + api_token + ", json_strict_mode="
				+ json_strict_mode + ", json_verbose_response=" + json_verbose_response + "]";
	}
}