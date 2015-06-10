package com.github.hiuchida.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * リバースプロキシ機能のサーブレットです。
 */
public class ProxyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RestClient restClient = RestClient.getInstance();
	
	public ProxyServlet setMock() {
		restClient = RestClient.getMockInstance();
		return this;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			execute(req, resp);
		} catch (Exception e) {
			OutputStream os = resp.getOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			ps.flush();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			execute(req, resp);
		} catch (Exception e) {
			OutputStream os = resp.getOutputStream();
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			ps.flush();
		}
	}
	
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF8");
		String method = req.getParameter("method");
		if (method == null) method = "get";
		String url = Config.getInstance().getServerUrl();
		String uri = req.getParameter("uri");
		if (uri == null || uri.length() == 0) {
			error404(resp);
			return;
		}
		url = url + uri;
		if ("get".equalsIgnoreCase(method)) {
			get(req, resp, url);
		} else if ("post".equalsIgnoreCase(method)) {
			post(req, resp, url);
		} else if ("put".equalsIgnoreCase(method)) {
			put(req, resp, url);
		} else if ("delete".equalsIgnoreCase(method)) {
			delete(req, resp, url);
		}
	}
	
	public void get(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		InputStream is = restClient.connect(url, "GET");
		OutputStream os = resp.getOutputStream();
		copy(is, os);
	}
	
	public void post(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		InputStream is = restClient.connect(url, "POST", req.getParameterMap());
		OutputStream os = resp.getOutputStream();
		copy(is, os);
	}
	
	public void put(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		InputStream is = restClient.connect(url, "PUT", req.getParameterMap());
		OutputStream os = resp.getOutputStream();
		copy(is, os);
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		InputStream is = restClient.connect(url, "DELETE");
		OutputStream os = resp.getOutputStream();
		copy(is, os);
	}
	
	public void error404(HttpServletResponse resp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		OutputStream os = resp.getOutputStream();
		os.write("404".getBytes());
		os.flush();
	}
	
	public void copy(InputStream is, OutputStream os) throws IOException {
		byte[] buf = new byte[1024];
		while (true) {
			int len = is.read(buf, 0, buf.length);
			if (len <= 0) break;
			os.write(buf, 0, len);
		}
		os.flush();
	}
	
}
