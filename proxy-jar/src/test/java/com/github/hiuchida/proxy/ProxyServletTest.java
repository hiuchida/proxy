package com.github.hiuchida.proxy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.github.hiuchida.proxy.mock.HttpServletRequestMock;
import com.github.hiuchida.proxy.mock.HttpServletResponseMock;

/**
 * ProxyServletクラスのユニットテストです。
 */
public class ProxyServletTest extends TestCase {
	public ProxyServletTest(String testName) {
		super(testName);
	}
    public static Test suite() {
        return new TestSuite(ProxyServletTest.class);
    }
    //-----------------------------------------------------------------------------
    //execute
    //-----------------------------------------------------------------------------
    public void testExecute0() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(404, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("404", resp.sosm.baos.toString());
    }
    public void testExecute1() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("uri", "");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(404, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("404", resp.sosm.baos.toString());
    }
    public void testExecute2() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("GET", resp.sosm.baos.toString());
    }
    public void testExecute4() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("uri", "uri");
    	map.put("root", "");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("GET", resp.sosm.baos.toString());
    }
    public void testExecute11() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "get");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("GET", resp.sosm.baos.toString());
    }
    public void testExecute13() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "get");
    	map.put("uri", "uri");
    	map.put("root", "");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("GET", resp.sosm.baos.toString());
    }
    public void testExecute21() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "post");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("POST:method=post&uri=uri", resp.sosm.baos.toString());
    }
    public void testExecute31() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "put");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("PUT:method=put&uri=uri", resp.sosm.baos.toString());
    }
    public void testExecute41() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "delete");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().execute(req, resp);
    	assertEquals("UTF8", req.ce);
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("DELETE", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //get
    //-----------------------------------------------------------------------------
    public void testGet1() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "get");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().get(req, resp, "uri");
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("GET", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //post
    //-----------------------------------------------------------------------------
    public void testPost1() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "post");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().post(req, resp, "uri");
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("POST:method=post&uri=uri", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //put
    //-----------------------------------------------------------------------------
    public void testPut1() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "put");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().put(req, resp, "uri");
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("PUT:method=put&uri=uri", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //delete
    //-----------------------------------------------------------------------------
    public void testDelete1() throws ServletException, IOException {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("method", "delete");
    	map.put("uri", "uri");
    	HttpServletRequestMock req = new HttpServletRequestMock(map);
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().delete(req, resp, "uri");
    	assertEquals(200, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("DELETE", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //error404
    //-----------------------------------------------------------------------------
    public void testError404() throws IOException {
    	HttpServletResponseMock resp = new HttpServletResponseMock();
    	new ProxyServlet().setMock().error404(resp);
    	assertEquals(404, resp.status);
    	assertEquals("", resp.caw.toString());
    	assertEquals("404", resp.sosm.baos.toString());
    }
    //-----------------------------------------------------------------------------
    //copy
    //-----------------------------------------------------------------------------
    public void testCopy() throws IOException {
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<1024; i++) {
    		sb.append("1234567890");
    	}
    	String str = sb.toString();
    	ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	new ProxyServlet().setMock().copy(bais, baos);
    	assertEquals(str, baos.toString());
    }
}
