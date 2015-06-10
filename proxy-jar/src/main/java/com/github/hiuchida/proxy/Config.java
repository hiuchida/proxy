package com.github.hiuchida.proxy;

/**
 * 環境設定を保持するsingletonです。
 * SetupServletから設定されます。
 */
public class Config {
	
	public static Config singleton = new Config();
	
	public static Config getInstance() {
		return singleton;
	}
	
	private String serverUrl;
	
	public Config() {
		setServerUrl("http://localhost:8080/");
	}
	
	public String getServerUrl() {
		return serverUrl;
	}
	
	public void setServerUrl(String s) {
		if (s != null) {
			if (!s.endsWith("/")) {
				s = s + "/";
			}
			this.serverUrl = s;
		}
	}
	
}
