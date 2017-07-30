package com.tea.user.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.tea.common.base.constant.ProjectName;
import com.tea.common.spring.WebSpringDispatcherServlet;



@WebServlet(value = { "*.json", "*.htm" }, loadOnStartup = 1)
 public class APIServlet extends WebSpringDispatcherServlet {

	private static final long serialVersionUID = -3022081086879841896L;

	private static final String appId = ProjectName.UserWeb.getAppId();
	private static final String appName = ProjectName.UserWeb.getAppName();
	private static final String packageName = "com.tea.user";

	@Override
	public void init(ServletConfig config) throws ServletException {
		setAppConfig(appId, appName, packageName);
		super.init(config);
	}

}
