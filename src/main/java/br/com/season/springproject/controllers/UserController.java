package br.com.season.springproject.controllers;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.season.springproject.entity.User;
import br.com.season.springproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Método para a primeira chamada da página
	@RequestMapping(method = RequestMethod.GET)
	public String users(ModelMap map){
		User user = new User();
		List<User> users = userService.findAll();
		map.addAttribute("user", user);
		map.addAttribute("users", users);
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(User user, ModelMap map){
		userService.save(user);
		user = new User();
		map.addAttribute("user", user);
		map.addAttribute("users", userService.findAll());
		return "user";
	}
	
	//@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	//public String update(@PathVariable("userId") Integer userId, ModelMap map){ //Pode usar ModelAndView no retorno. Se usar, não precisa passar o Modelmap
	//	return "user";
//	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ModelAndView update(@PathVariable("userId") Integer userId, User user){ //Pode usar ModelAndView no retorno. Se usar, não precisa passar o Modelmap
		ModelAndView view = new ModelAndView("redirect:/user");
		User foundUser = userService.findById(userId);
		//BeanUtils.copyProperties copia todos os dados de um objeto para outro.
		BeanUtils.copyProperties(user, foundUser, "id");
		foundUser = userService.update(foundUser);
		view.addObject("user", user);
		return view;
	}
	
	//Método para o Edit
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getById(@PathVariable("userId") Integer userId, ModelMap map){
		User found = userService.findById(userId);
		List<User> list = userService.findAll();
		map.addAttribute("user", found);
		map.addAttribute("users", list);
		return "user";
	}
	
	@RequestMapping("/getCpf/{cpf}")
	//@ResponseBody é muito usado em aplicação REST.
	public @ResponseBody User findByCpf(@PathVariable String cpf){
		return userService.findByCpf(cpf);
	}
	
}
