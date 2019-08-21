package spring.services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.repositories.ReceptionistRepository;
import spring.dto.ClientDTO;
import spring.dto.ReceptionistDTO;
import spring.entities.Camera;
import spring.entities.Client;
import spring.entities.Receptionist;
import spring.repositories.CameraRepository;
import spring.repositories.ClientRepository;

@Service
public class RecepService {
	@Autowired
	private ReceptionistRepository recepRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CameraRepository cameraRepository;
	
	public void insertCLient(ClientDTO clDTO) {
		Client cln = new Client();
		cln.setNume(clDTO.getNume());
		cln.setPrenume(clDTO.getPrenume());
		cln.setTelefon(clDTO.getTelefon());
		cln.setAdresa(clDTO.getAdresa());
		cln.setCamereInchiriate(0);
		clientRepository.save(cln);
	}
	
	public List<ClientDTO> AllClients(){
		List<Client> cls = clientRepository.findAll();
		List<ClientDTO> toReturn = new ArrayList<ClientDTO>();
		
		for(Client cln : cls){
			ClientDTO dto = new ClientDTO.Builder()
					.nume(cln.getNume())
					.prenume(cln.getPrenume())
					.telefon(cln.getTelefon())
					.adresa(cln.getAdresa())
					.camereInchiriate(cln.getCamereInchiriate())
					.create();
			toReturn.add(dto);
		}
		return toReturn;
	}
	
	@Transactional
	public void bookRoom(ReceptionistDTO recDTO){
		Receptionist recep = new Receptionist();
		recep.setIdUser(recDTO.getIdUser());
		recep.setNumeClient(recDTO.getNumeClient());
		recep.setNrCamera(recDTO.getNrCamera());
		recep.setDataSosire(recDTO.getDataSosire());
		recep.setDataPlecare(recDTO.getDataPlecare());
		
		recepRepository.save(recep);
		
		Camera cmr = cameraRepository.findByNumar(recep.getNrCamera());
		cmr.setDisponibilitate("nu");
		cameraRepository.setCameraByDisponibilitate(cmr.getDisponibilitate(), cmr.getNumar());
		
		Client cln = clientRepository.findOne(recep.getNumeClient());
		int nr = cln.getCamereInchiriate();
		nr++;
		cln.setCamereInchiriate(nr);
		clientRepository.setClientByCamereInchiriate(nr, cln.getNume());
		
		recDTO.getClienti().add(cln);
		
		Integer price = cmr.getPret();
		Date dSosire = recep.getDataSosire();
		Date dPlecare = recep.getDataPlecare();
		Integer multiplyDay = dPlecare.getDay() - dSosire.getDay();
		Integer multiplyMonth = dPlecare.getMonth() - dSosire.getMonth();
		Integer finalPrice = 0;
		if(multiplyDay == 0)
			finalPrice = price;
		else if(multiplyDay == 0 && multiplyMonth != 0)
			finalPrice = price * multiplyMonth * 30;
		else if(multiplyDay != 0 && multiplyMonth == 0)
			finalPrice = price * multiplyDay;
		else if(multiplyDay != 0 && multiplyMonth != 0)
			finalPrice = price * multiplyMonth * 30 * multiplyDay;
		
		try {
		FileWriter writer = new FileWriter("Factura.txt");
        writer.write("\r\n");
        writer.write("HOTEL FLOAREA SALBATICA");
        writer.write("\r\n");
        writer.write("Data:" + LocalDateTime.now());
        writer.write("\r\n");
        writer.write("\r\n");
        writer.write("ID Receptionist : " + recep.getIdUser());
        writer.write("\r\n");   // write new line
        writer.write("Client : " + cln.getNume() + " " + cln.getPrenume());
        writer.write("\r\n");   // write new line
        writer.write("Camera: " + cmr.getNumar() + ",tip: " + cmr.getTip());
        writer.write("\r\n");   // write new line
        writer.write("Pret pe o noapte: " + cmr.getPret());
        writer.write("\r\n");   // write new line
        writer.write("PRET TOTAL : " + finalPrice);
        writer.close();
		} catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	@Transactional
	public void cancelRoom(String nume, Integer numar) {
		Camera cmr = cameraRepository.findByNumar(numar);
		
		Receptionist r = recepRepository.findByNrCamera(numar);
		Client c = clientRepository.findByNume(r.getNumeClient());
		recepRepository.delete(r.getID());
		
		cmr.setDisponibilitate("da");
		cameraRepository.setCameraByDisponibilitate(cmr.getDisponibilitate(), cmr.getNumar());
		
		//System.out.println(cln.getNume() + " " + cln.getCamereInchiriate());
		Integer nr = c.getCamereInchiriate();
		
		nr--;
		System.out.println(nr + " nr ");
		c.setCamereInchiriate(nr);
		clientRepository.setClientByCamereInchiriate(c.getCamereInchiriate(), c.getNume());
	}
	
	public List<ReceptionistDTO> AllBookings(Integer id){
		List<Receptionist> receps = recepRepository.findAllByIdUser(id);
		List<ReceptionistDTO> toReturn = new ArrayList<ReceptionistDTO>();
		
		for(Receptionist rec : receps){
			ReceptionistDTO dto = new ReceptionistDTO.Builder()
					.idUser(rec.getIdUser())
					.nrCamera(rec.getNrCamera())
					.numeClient(rec.getNumeClient())
					.dataSosire(rec.getDataSosire())
					.dataPlecare(rec.getDataPlecare())
					.create();
			toReturn.add(dto);
		}
		return toReturn;
	}
}
