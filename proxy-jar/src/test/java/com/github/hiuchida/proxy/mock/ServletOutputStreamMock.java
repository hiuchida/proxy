package com.github.hiuchida.proxy.mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

/**
 * ServletOutputStream抽象クラスのモッククラスです。
 */
public class ServletOutputStreamMock extends ServletOutputStream {

	public ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
	@Override
	public void write(int b) throws IOException {
		baos.write(b);
	}

}
