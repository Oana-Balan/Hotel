package spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Camera")
@Table (name = "camera")
public class Camera implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numar;
	private String tip;
	private String disponibilitate;
	private Integer pret;
	
	public Camera() {
	}

	public Camera(Integer numar, String tip, String disponibilitate, Integer pret) {
		super();
		this.numar = numar;
		this.tip = tip;
		this.disponibilitate = disponibilitate;
		this.pret = pret;
	}
	
	@Id
	@Column(name = "numar", nullable = false, unique = true)
	public Integer getNumar() {
		return numar;
	}

	public void setNumar(Integer numar) {
		this.numar = numar;
	}
	
	@Column(name = "tip", nullable = false, length = 200)
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Column(name = "disponibilitate", nullable = false, length = 200)
	public String getDisponibilitate() {
		return disponibilitate;
	}

	public void setDisponibilitate(String disponibilitate) {
		this.disponibilitate = disponibilitate;
	}
	
	@Column(name = "pret", nullable = false, length = 10)
	public Integer getPret() {
		return pret;
	}

	public void setPret(Integer pret) {
		this.pret = pret;
	}
}
