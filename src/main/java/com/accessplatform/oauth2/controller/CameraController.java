package com.accessplatform.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/camera1/")
public class CameraController 
{
	@RequestMapping("camerashow")
	public String camera()
	{
		return "unity/dashboard";
	}

}
