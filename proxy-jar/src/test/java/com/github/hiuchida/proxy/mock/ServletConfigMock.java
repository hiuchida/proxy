package com.github.hiuchida.proxy.mock;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * ServletConfigインターフェイスのモッククラスです。
 */
public class ServletConfigMock implements ServletConfig {

	private Map<String,String> map;
	
	public ServletConfigMock(Map<String,String> m) {
		this.map = m;
	}
	
	public String getInitParameter(String arg0) {
		// TODO Auto-generated method stub
		return map.get(arg0);
	}

	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletName() {
		// TODO Auto-generated method stub
		return null;
	}

}
