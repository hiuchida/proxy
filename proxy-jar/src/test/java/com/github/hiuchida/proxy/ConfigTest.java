package com.github.hiuchida.proxy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Configクラスのユニットテストです。
 */
public class ConfigTest extends TestCase {
	public ConfigTest(String testName) {
		super(testName);
	}
    public static Test suite() {
        return new TestSuite(ConfigTest.class);
    }
    //-----------------------------------------------------------------------------
    //getServerUrl
    //-----------------------------------------------------------------------------
    public void testGetServerUrl() {
    	assertEquals("http://localhost:8080/", Config.getInstance().getServerUrl());
    }
    //-----------------------------------------------------------------------------
    //setServerUrl
    //-----------------------------------------------------------------------------
    public void testSetServerUrl0() {
    	Config.getInstance().setServerUrl(null);
    	assertEquals("http://localhost:8080/", Config.getInstance().getServerUrl());
    }
    public void testSetServerUrl1() {
    	Config.getInstance().setServerUrl("http://example.com");
    	assertEquals("http://example.com/", Config.getInstance().getServerUrl());
    	Config.getInstance().setServerUrl("http://localhost:8080/"); //undo
    }
    public void testSetServerUrl2() {
    	Config.getInstance().setServerUrl("http://example.com/");
    	assertEquals("http://example.com/", Config.getInstance().getServerUrl());
    	Config.getInstance().setServerUrl("http://localhost:8080/"); //undo
    }
}
