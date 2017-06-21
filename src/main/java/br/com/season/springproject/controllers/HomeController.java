package br.com.season.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(ModelMap map){
		map.addAttribute("nome","Zé das Cove");
		return "home";
	}
	
	@RequestMapping("/test")
	public String getId(@RequestParam("id") String id, ModelMap map){
		map.addAttribute("id", id);
		
		return "home"; //link pra usar o @RequestParam: http://localhost:8080/springProject/test?id=cretino
	}
	
	@RequestMapping("/hello")
	public String hello(@RequestHeader("Accept-Language") String language, @RequestHeader("Host") String ip, @RequestHeader("User-Agent") String agent, @RequestHeader("Accept") String accept, ModelMap map){
		map.addAttribute("agent", agent);
		map.addAttribute("accept", accept);
		map.addAttribute("ip", ip);
		map.addAttribute("language", language);
		return "home";
	}
}
