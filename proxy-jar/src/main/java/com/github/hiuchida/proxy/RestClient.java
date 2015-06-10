package com.github.hiuchida.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import com.github.hiuchida.proxy.mock.RestClientMock;

/**
 * RESTクライアントのユーティリティクラスです。
 * 開発当初のこのクラスからRestClientImplに分割しました。
 */
public class RestClient {

	private static RestClient impl = new RestClient(false);
	private static RestClient mock = new RestClient(true);
	
	public static RestClient getInstance() {
		return impl;
	}
	
	public static RestClient getMockInstance() {
		return mock;
	}
	
	private boolean bMock;
	
	public RestClient(boolean bMock) {
		this.bMock = bMock;
	}
	
	public InputStream connect(String urlStr, String method) throws IOException {
		if (bMock) return RestClientMock.connect(urlStr, method, null);
		return RestClientImpl.connect(urlStr, method, null);
	}
	
	public InputStream connect(String urlStr, String method, Map<String,String[]> params) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (String key : params.keySet()) {
			String[] val = params.get(key);
			key = URLEncoder.encode(key, "UTF8");
			val[0] = URLEncoder.encode(val[0], "UTF8");
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append(key).append("=").append(val[0]);
		}
		if (bMock) return RestClientMock.connect(urlStr, method, sb.toString());
		return RestClientImpl.connect(urlStr, method, sb.toString());
	}
	
}
