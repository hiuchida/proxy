package com.github.hiuchida.proxy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 環境設定を行うサーブレットです。
 * web.xmlに<load-on-startup>指定しているため、コンテナ起動時にロードされます。
 */
public class SetupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String s = config.getInitParameter("server");
		Config.getInstance().setServerUrl(s);
	}

}
