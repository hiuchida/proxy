package com.github.hiuchida.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * RestClientImplクラスのユニットテストです。
 */
public class RestClientImplTest extends TestCase {
	public static String urlStr = "http://localhost:8080/proxy/";
	public RestClientImplTest(String testName) {
		super(testName);
	}
    public static Test suite() {
        return new TestSuite(RestClientImplTest.class);
    }
    //-----------------------------------------------------------------------------
    //connect
    //-----------------------------------------------------------------------------
    public void testConnect1() throws IOException {
		InputStream is = RestClientImpl.connect(urlStr, "GET", null);
		Reader r = new InputStreamReader(is, "UTF8");
		BufferedReader br = new BufferedReader(r);
		assertEquals("Running <br>", br.readLine());
		assertEquals("server: http://localhost:8080/", br.readLine());
		assertEquals(null, br.readLine());
    }
    public void testConnect2() throws IOException {
		InputStream is = RestClientImpl.connect(urlStr, "GET", "who=proxy");
		Reader r = new InputStreamReader(is, "UTF8");
		BufferedReader br = new BufferedReader(r);
		assertEquals("Running proxy<br>", br.readLine());
		assertEquals("server: http://localhost:8080/", br.readLine());
		assertEquals(null, br.readLine());
    }
}
