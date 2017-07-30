package com.tea.user.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.serialize.support.kryo.ResponseData;
import com.alibaba.dubbo.config.annotation.Reference;
import com.tea.common.base.spring.JsonModelAndView;
import com.tea.user.common.NoLogin;
import com.tea.user.entity.User;
import com.tea.user.service.IUserInfoService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
   
	@Reference
	private IUserInfoService userInfoService;
	
	@NoLogin
	@RequestMapping(value = "/getUsers.json")
	@ResponseBody
	public JsonModelAndView getUsers(String phone){
		ResponseData<List<User>> response = new ResponseData<>();
		response.data=userInfoService.getUsers(phone);
		return new JsonModelAndView(response);
	}
}
