package com.mycompany.webapp.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.webapp.dto.Ch08InputForm;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch08")
@Log4j2
@SessionAttributes({"inputForm"})
public class Ch08Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch08/content";
	}
	@GetMapping(value="/saveData",produces="application/json; charset=UTF-8")
	@ResponseBody
	public String saveData(String name,HttpSession session) {
		session.setAttribute("name",name);
		//{"result" : "success"} , {면 JSONObject   [면 JSONARRAY
		JSONObject  jsonObject = new JSONObject();
		jsonObject.put("result","success");
		String json=jsonObject.toString();
		return json;
	}
	@GetMapping(value="/readData",produces="application/json; charset=UTF-8")
	@ResponseBody
	public String readData(HttpSession session) {
		String name=(String)session.getAttribute("name");
		//{"result" : "success"} , {면 JSONObject   [면 JSONARRAY
		JSONObject  jsonObject = new JSONObject();
		jsonObject.put("name",name);
		String json=jsonObject.toString();
		return json;
	}
	@GetMapping("/login")
	public String loginForm() {
		
		return "ch08/loginForm";
	}
	@PostMapping("/login")
	public String login(String mid,String mpassword,HttpSession session) {
		if(mid.equals("spring") && mpassword.equals("12345")) {
			//로그인 성공세션
			session.setAttribute("sessionMid", mid);
		}
		return "redirect:/ch08/content";
	}
	@GetMapping("/logout")
	public String loginout(HttpSession session) {
		//세션에서 주어진 키를 삭제
		session.removeAttribute("sessionMid");
		//세션 객체 자체를 제거
		session.invalidate();
		return "redirect:/ch08/content";
	}
	@GetMapping("/userinfo")
	public String userInfo(HttpSession session,
			@SessionAttribute String sessionMid,
			@SessionAttribute("sessionMid") String mid) {	
		String memberId=(String) session.getAttribute("sessionMid");
		log.info("memberId: "+memberId);
		log.info("sessionMid: "+sessionMid);
		log.info("mid: " + mid);
		return "redirect:/ch08/content";
	}
	
	@RequestMapping(value="/loginAjax",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String loginAjax(String mid,String mpassword, HttpSession session){
		String result=null;
		if(mid.equals("spring")) {
			if(mpassword.equals("12345")) {
				result="success";
				session.setAttribute("sessionMid", mid);
			}else {
				result="wrongMpassword";
			}
		}else {
			result="wrongMid";
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("result", result);
		String json=jsonObject.toString();
		return json;
	}
	@RequestMapping(value="/logoutAjax",produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public String logoutAjax( HttpSession session){
		
		session.invalidate();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("result", "success");
		String json=jsonObject.toString();
		return json;
	}
	
	@GetMapping("/inputStep1")
	public String inputStep1() {
		
		
		return "ch08/inputStep1";
	}
	@ModelAttribute("inputForm")//새로운 세션 저장소에 객체를 저장하는 역할,sessionAtrriubtes없으면 컨트롤러 호출시 계속실행됨 
	public Ch08InputForm getCh08InputForm() {
		log.info("실행");
		Ch08InputForm inputForm=new Ch08InputForm();
		
		return inputForm;
	}
	@PostMapping("/inputStep2")
	public String inputStep2(@ModelAttribute("inputForm")Ch08InputForm inputForm) {
		log.info("data1: " + inputForm.getData1());
		log.info("data2: " + inputForm.getData2());
		return "ch08/inputStep2";
	}
	@PostMapping("/inputDone")
	public String inputStep3(@ModelAttribute("inputForm")Ch08InputForm inputForm,SessionStatus sessionStatus) {
		log.info("data1: " + inputForm.getData1());
		log.info("data2: " + inputForm.getData2());
		log.info("data3: " + inputForm.getData3());
		log.info("data4: " + inputForm.getData4());
		sessionStatus.setComplete();
		return "redirect:/ch08/content";
	}
	

}
