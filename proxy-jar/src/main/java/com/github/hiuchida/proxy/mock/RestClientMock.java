package com.github.hiuchida.proxy.mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ユニットテスト用のRestClientのモッククラスです。
 */
public class RestClientMock {

	public static InputStream connect(String urlStr, String method, String contents) throws IOException {
		if (method == null) {
			if (contents == null) {
				return new ByteArrayInputStream("null".getBytes());
			}
			return new ByteArrayInputStream(contents.getBytes());
		} else if ("get".equalsIgnoreCase(method)) {
			return new ByteArrayInputStream(method.getBytes());
		} else if ("post".equalsIgnoreCase(method)) {
			return new ByteArrayInputStream((method+":"+contents).getBytes());
		} else if ("put".equalsIgnoreCase(method)) {
			return new ByteArrayInputStream((method+":"+contents).getBytes());
		} else if ("delete".equalsIgnoreCase(method)) {
			return new ByteArrayInputStream(method.getBytes());
		}
		return new ByteArrayInputStream(method.getBytes());
	}

}
