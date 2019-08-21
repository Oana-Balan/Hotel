package spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@Table (name = "User")
public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	private String utilizator;
	
	public User() {
	}

	public User(String nume, String prenume, String email, String parola, String utilizator) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.utilizator = utilizator;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
	
	@Column(name = "email", nullable = false, length = 200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "parola", nullable = false, length = 200)
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	@Column(name = "utilizator", nullable = false, length = 200)
	public String getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}

}
