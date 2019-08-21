package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.CameraDTO;
import spring.dto.UserDTO;
import spring.services.AdminService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@RequestBody UserDTO userDTO){
		adminService.insertUser(userDTO);
		return "Insert succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<UserDTO> getallUsers(){
		return adminService.findAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/deleteUser/{id}")
	public String delUser(@PathVariable("id") Integer id){
		adminService.deleteUser(id);
		return "Delete succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "User/{nume}/{email}/{id}", method = RequestMethod.PUT)
	public String updUser(@PathVariable("nume") String nume, @PathVariable("email") String email,@PathVariable("id") Integer id){
		adminService.updateUser(nume, email,id);
		return "Update succeed";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/insertCamera", method = RequestMethod.POST)
	public String insertCamera(@RequestBody CameraDTO camDTO){
		adminService.insertCamera(camDTO);
		return "Insert succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/allCams", method = RequestMethod.GET)
	public List<CameraDTO> getallCams(){
		return adminService.AllCams();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/raport/{nr}")
	public void raportClienti(@PathVariable("nr") Integer nr){
		adminService.numberRezervations(nr);
	}
}
