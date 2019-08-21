package spring.services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dto.CameraDTO;
import spring.dto.ClientDTO;
import spring.dto.UserDTO;
import spring.entities.Camera;
import spring.entities.Client;
import spring.entities.User;
import spring.repositories.CameraRepository;
import spring.repositories.ClientRepository;
import spring.repositories.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CameraRepository cameraRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void insertUser(UserDTO userDTO){
		User user = new User();
		user.setNume(userDTO.getNume());
		user.setPrenume(userDTO.getPrenume());
		user.setEmail(userDTO.getEmail());
		user.setParola(userDTO.getParola());
		user.setUtilizator(userDTO.getUtilizator());
		userRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
		User user = userRepository.findById(id);
		UserDTO userDTO = new UserDTO.Builder()
				.id(user.getId())
				.nume(user.getNume())
				.prenume(user.getPrenume())
				.email(user.getEmail())
				.parola(user.getParola())
				.create();
		userRepository.delete(userDTO.getId());
	}
	
	public List<UserDTO> findAllUsers(){
		List<User> users = userRepository.findAll();
		List<UserDTO> toReturn = new ArrayList<UserDTO>();
		
		for(User usr : users){
			UserDTO dto = new UserDTO.Builder()
					.id(usr.getId())
					.nume(usr.getNume())
					.prenume(usr.getPrenume())
					.email(usr.getEmail())
					.parola(usr.getParola())
					.utilizator(usr.getUtilizator())
					.create();
			toReturn.add(dto);
		}
		return toReturn;
	}
	
	@Transactional
	public void updateUser(String nume, String email,Integer id) {
		User user = userRepository.findOne(id);
		userRepository.setUserById(nume, email, user.getId());
	}
	
	public void insertCamera(CameraDTO camDTO) {
		Camera cam = new Camera();
		cam.setNumar(camDTO.getNumar());
		cam.setTip(camDTO.getTip());
		cam.setDisponibilitate("da");
		cam.setPret(camDTO.getPret());
		cameraRepository.save(cam);
	}
	
	public List<CameraDTO> AllCams(){
		List<Camera> cams = cameraRepository.findAll();
		List<CameraDTO> toReturn = new ArrayList<CameraDTO>();
		
		for(Camera cmr : cams){
			CameraDTO dto = new CameraDTO.Builder()
					.numar(cmr.getNumar())
					.tip(cmr.getTip())
					.disponibilitate(cmr.getDisponibilitate())
					.pret(cmr.getPret())
					.create();
			toReturn.add(dto);
		}
		return toReturn;
	}
	
	public void numberRezervations(Integer nr){
		List<Client> clients = clientRepository.findAll();
		try {
			FileWriter writer = new FileWriter("RaportClienti.txt");
	        writer.write("\r\n");
	        writer.write("HOTEL FLOAREA SALBATICA");
	        writer.write("\r\n");
	        writer.write("Data:" + LocalDateTime.now());
	        writer.write("\r\n");
		for(Client cl: clients) {
			if(cl.getCamereInchiriate() >= nr) {
			        writer.write("\r\n");
			        writer.write("Nume si prenume client : " + cl.getNume() + " " + cl.getPrenume());
			        writer.write("\r\n");   // write new line
			        writer.write("Adresa : " + cl.getAdresa() + " si telefon : " + cl.getTelefon());
			        writer.write("\r\n");   // write new line
			        writer.write("Numarul camerelor inchiriate: " + cl.getCamereInchiriate());
			        writer.write("\r\n");   // write new line
					}
		}
		writer.close();
		}catch (IOException e) {
			            e.printStackTrace();
			        }
			}
}
