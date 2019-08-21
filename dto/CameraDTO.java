package spring.dto;

public class CameraDTO {
	private Integer numar;
	private String tip;
	private String disponibilitate;
	private Integer pret;
	
	public CameraDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CameraDTO(Integer numar, String tip, String disponibilitate, Integer pret) {
		super();
		this.numar = numar;
		this.tip = tip;
		this.disponibilitate = disponibilitate;
		this.pret = pret;
	}

	public Integer getNumar() {
		return numar;
	}

	public void setNumar(Integer numar) {
		this.numar = numar;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getDisponibilitate() {
		return disponibilitate;
	}

	public void setDisponibilitate(String disponibilitate) {
		this.disponibilitate = disponibilitate;
	}

	public Integer getPret() {
		return pret;
	}

	public void setPret(Integer pret) {
		this.pret = pret;
	}
	
	public static class Builder{
		private Integer nestednumar;
		private String nestedtip;
		private String nesteddisponibilitate;
		private Integer nestedpret;
		
		public Builder numar(Integer numar){
			this.nestednumar = numar;
			return this;
		}
		
		public Builder tip(String tip){
			this.nestedtip = tip;
			return this;
		}
		
		public Builder disponibilitate(String disponibilitate){
			this.nesteddisponibilitate = disponibilitate;
			return this;
		}
		
		public Builder pret(Integer pret){
			this.nestedpret = pret;
			return this;
		}
		
		public CameraDTO create(){
			return new CameraDTO(nestednumar, nestedtip, nesteddisponibilitate, nestedpret);
		}
	}
}
