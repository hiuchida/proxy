package com.github.hiuchida.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * RestClientクラスのユニットテストです。
 */
public class RestClientTest extends TestCase {
	public RestClientTest(String testName) {
		super(testName);
	}
    public static Test suite() {
        return new TestSuite(RestClientTest.class);
    }
    //-----------------------------------------------------------------------------
    //connect(String,String)
    //-----------------------------------------------------------------------------
    public void testConnect() throws IOException {
    	InputStream is = RestClient.getMockInstance().connect(null, null);
    	Reader r = new InputStreamReader(is, "UTF8");
    	BufferedReader br = new BufferedReader(r);
    	assertEquals("null", br.readLine());
    }
    //-----------------------------------------------------------------------------
    //connect(String,String,Map)
    //-----------------------------------------------------------------------------
    public void testConnect0() throws IOException {
    	Map<String,String[]> params = new HashMap<String,String[]>();
    	InputStream is = RestClient.getMockInstance().connect(null, null, params);
    	Reader r = new InputStreamReader(is, "UTF8");
    	BufferedReader br = new BufferedReader(r);
    	String s = br.readLine();
//    	System.out.println(s);
    	assertEquals(null, s);
    }
    public void testConnect1() throws IOException {
    	Map<String,String[]> params = new HashMap<String,String[]>();
    	String[] v1 = {"あいう"};
    	params.put("キー", v1);
    	InputStream is = RestClient.getMockInstance().connect(null, null, params);
    	Reader r = new InputStreamReader(is, "UTF8");
    	BufferedReader br = new BufferedReader(r);
    	String s = br.readLine();
//  	System.out.println(s);
    	assertEquals("%E3%82%AD%E3%83%BC=%E3%81%82%E3%81%84%E3%81%86", s);
    }
    public void testConnect2() throws IOException {
    	Map<String,String[]> params = new HashMap<String,String[]>();
    	String[] v1 = {"あいう"};
    	params.put("キー1", v1);
    	String[] v2 = {"かきく"};
    	params.put("キー2", v2);
    	InputStream is = RestClient.getMockInstance().connect(null, null, params);
    	Reader r = new InputStreamReader(is, "UTF8");
    	BufferedReader br = new BufferedReader(r);
    	String s = br.readLine();
//    	System.out.println(s);
    	assertEquals("%E3%82%AD%E3%83%BC1=%E3%81%82%E3%81%84%E3%81%86&%E3%82%AD%E3%83%BC2=%E3%81%8B%E3%81%8D%E3%81%8F", s);
    }
}
