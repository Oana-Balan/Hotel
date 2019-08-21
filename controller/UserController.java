package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.services.UserService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/User/Email/{email}/Parola/{parola}", method = RequestMethod.GET)
	@ResponseBody
	public String getUtilizator(@PathVariable("email") String email, @PathVariable("parola") String parola){
		return userService.findUtilizator(email, parola);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/User/Email/{email}/Parola/{parola}/{utilizator}", method = RequestMethod.GET)
	@ResponseBody
	public Integer getId(@PathVariable("email") String email, @PathVariable("parola") String parola, @PathVariable("utilizator") String utilizator){
		return userService.findId(email, parola,utilizator);
	}
}
