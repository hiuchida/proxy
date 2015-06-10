package com.github.hiuchida.proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.github.hiuchida.proxy.mock.ServletConfigMock;

/**
 * SetupServletクラスのユニットテストです。
 */
public class SetupServletTest extends TestCase {
	public SetupServletTest(String testName) {
		super(testName);
	}
    public static Test suite() {
        return new TestSuite(SetupServletTest.class);
    }
    //-----------------------------------------------------------------------------
    //init
    //-----------------------------------------------------------------------------
    public void testInit() throws ServletException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("server", "http://example.com/");
    	ServletConfigMock scm = new ServletConfigMock(map);
    	new SetupServlet().init(scm);
    	assertEquals("http://example.com/", Config.getInstance().getServerUrl());
    	Config.getInstance().setServerUrl("http://localhost:8080/"); //undo
    }
}
