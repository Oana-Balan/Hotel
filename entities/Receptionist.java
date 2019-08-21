package spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Receptionist")
@Table (name = "receptionist")
public class Receptionist implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
    private Integer idUser;
	private Integer nrCamera;
	private String numeClient;
	private Date dataSosire;
	private Date dataPlecare;
	

	public Receptionist() {
	}

	
	
	
	public Receptionist(Integer iD,Integer idUser, Integer nrCamera, String numeClient, Date dataSosire, Date dataPlecare) {
		super();
		ID = iD;
		this.idUser = idUser;
		this.nrCamera = nrCamera;
		this.numeClient = numeClient;
		this.dataSosire = dataSosire;
		this.dataPlecare = dataPlecare;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true)
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Column(name = "idUser", nullable = false, length = 10)
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@Column(name = "nrCamera", nullable = false, length = 10)
	public Integer getNrCamera() {
		return nrCamera;
	}

	public void setNrCamera(Integer nrCamera) {
		this.nrCamera = nrCamera;
	}
	
	@Column(name = "numeClient", nullable = false, length = 200)
	public String getNumeClient() {
		return numeClient;
	}

	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataSosire")
	public Date getDataSosire() {
		return dataSosire;
	}

	public void setDataSosire(Date dataSosire) {
		this.dataSosire = dataSosire;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataPlecare")
	public Date getDataPlecare() {
		return dataPlecare;
	}

	public void setDataPlecare(Date dataPlecare) {
		this.dataPlecare = dataPlecare;
	}
	
}
