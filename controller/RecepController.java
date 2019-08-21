package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.ClientDTO;
import spring.dto.ReceptionistDTO;
import spring.services.RecepService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/recep")
public class RecepController {
	
	@Autowired
	private RecepService recepService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/insertClient", method = RequestMethod.POST)
	public String insertClient(@RequestBody ClientDTO clientDTO){
		recepService.insertCLient(clientDTO);
		return "Insert succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/allClients", method = RequestMethod.GET)
	public List<ClientDTO> getallClients(){
		return recepService.AllClients();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/Booking", method = RequestMethod.POST)
	public String Booking(@RequestBody ReceptionistDTO recDTO){
		recepService.bookRoom(recDTO);
		return "Booking succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/Cancel/{nume}/{numar}")
	public String delUser(@PathVariable("nume") String nume, @PathVariable("numar") Integer numar){
		recepService.cancelRoom(nume, numar);
		return "Delete succeed!";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public List<ReceptionistDTO> getallBookings(@PathVariable("id") Integer id){
		return recepService.AllBookings(id);
	}
}
