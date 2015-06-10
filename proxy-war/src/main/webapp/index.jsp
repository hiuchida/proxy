Running <%= request.getParameter("who") != null ? request.getParameter("who") : "" %><br>
server: <%= com.github.hiuchida.proxy.Config.getInstance().getServerUrl() %>