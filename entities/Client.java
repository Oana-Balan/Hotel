package spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Client")
@Table (name = "client")
public class Client implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nume;
	private String prenume;
	private String telefon;
	private String adresa;
	private Integer camereInchiriate;
	
	
	public Client() {
	}


	public Client(String nume, String prenume, String telefon, String adresa, Integer camereInchiriate) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
		this.adresa = adresa;
		this.camereInchiriate = camereInchiriate;
	}

	@Id
	@Column(name = "nume", nullable = false, length = 200)
	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}
	
	@Column(name = "prenume", nullable = false, length = 200)
	public String getPrenume() {
		return prenume;
	}


	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	@Column(name = "telefon", nullable = false, length = 200)
	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Column(name = "adresa", nullable = false, length = 200)
	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Column(name = "camereInchiriate", nullable = false, length = 10)
	public Integer getCamereInchiriate() {
		return camereInchiriate;
	}


	public void setCamereInchiriate(Integer camereInchiriate) {
		this.camereInchiriate = camereInchiriate;
	}
}
