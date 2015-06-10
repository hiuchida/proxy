package com.github.hiuchida.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * RESTクライアントの実装クラスです。
 * 実際にHTTP通信します。
 */
public class RestClientImpl {
	
	public static InputStream connect(String urlStr, String method, String contents) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(method);
		conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; utf-8");
		if (contents != null) {
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(contents.getBytes());
		}
		conn.connect();
		return conn.getInputStream();
	}

}
