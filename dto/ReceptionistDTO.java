package spring.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spring.entities.Client;

public class ReceptionistDTO {
	private Integer ID;
	private Integer idUser;
	private Integer nrCamera;
	private String numeClient;
	private Date dataSosire;
	private Date dataPlecare;
	
	private List<Client> clienti = new ArrayList<Client>();
	
	public ReceptionistDTO() {
	}

	public ReceptionistDTO(Integer ID,Integer idUser,Integer nrCamera, String numeClient, Date dataSosire, Date dataPlecare) {
		super();
		this.ID = ID;
		this.idUser = idUser;
		this.nrCamera = nrCamera;
		this.numeClient = numeClient;
		this.dataSosire = dataSosire;
		this.dataPlecare = dataPlecare;
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getNrCamera() {
		return nrCamera;
	}

	public void setNrCamera(Integer nrCamera) {
		this.nrCamera = nrCamera;
	}

	public String getNumeClient() {
		return numeClient;
	}

	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}

	public Date getDataSosire() {
		return dataSosire;
	}

	public void setDataSosire(Date dataSosire) {
		this.dataSosire = dataSosire;
	}

	public Date getDataPlecare() {
		return dataPlecare;
	}

	public void setDataPlecare(Date dataPlecare) {
		this.dataPlecare = dataPlecare;
	}
	

	public List<Client> getClienti() {
		return clienti;
	}

	public void setClienti(List<Client> clienti) {
		this.clienti = clienti;
	}

	public static class Builder{
		private Integer nestedID;
		private Integer nestedidUser;
		private Integer nestednrCamera;
		private String nestednumeClient;
		private Date nesteddataSosire;
		private Date nesteddataPlecare;
		
		public Builder ID(Integer ID){
			this.nestedID = ID;
			return this;
		}
		
		public Builder idUser(Integer idUser){
			this.nestedidUser = idUser;
			return this;
		}
		
		public Builder nrCamera(Integer nrCamera){
			this.nestednrCamera = nrCamera;
			return this;
		}
		
		public Builder numeClient(String numeClient){
			this.nestednumeClient = numeClient;
			return this;
		}
		
		public Builder dataSosire(Date dataSosire){
			this.nesteddataSosire = dataSosire;
			return this;
		}
		
		
		public Builder dataPlecare(Date data){
			this.nesteddataPlecare = data;
			return this;
		}
	
		public ReceptionistDTO create(){
			return new ReceptionistDTO(nestedID,nestedidUser, nestednrCamera, nestednumeClient, nesteddataSosire, nesteddataPlecare);
		}
	}
}
