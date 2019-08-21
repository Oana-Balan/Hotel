package spring.dto;

public class ClientDTO {
	private String nume;
	private String prenume;
	private String telefon;
	private String adresa;
	private Integer camereInchiriate;
	
	public ClientDTO() {
	}

	public ClientDTO(String nume, String prenume, String telefon, String adresa, Integer camereInchiriate) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
		this.adresa = adresa;
		this.camereInchiriate = camereInchiriate;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Integer getCamereInchiriate() {
		return camereInchiriate;
	}

	public void setCamereInchiriate(Integer camereInchiriate) {
		this.camereInchiriate = camereInchiriate;
	}
	
	public static class Builder{
		private String nestednume;
		private String nestedprenume;
		private String nestedtelefon;
		private String nestedadresa;
		private Integer nestedcamereInchiriate;
		
		public Builder nume(String nume){
			this.nestednume = nume;
			return this;
		}
		
		public Builder prenume(String prenume){
			this.nestedprenume = prenume;
			return this;
		}
		
		public Builder telefon(String telefon){
			this.nestedtelefon = telefon;
			return this;
		}
		
		
		public Builder adresa(String adresa){
			this.nestedadresa = adresa;
			return this;
		}
		
		public Builder camereInchiriate(Integer camereInchiriate) {
			this.nestedcamereInchiriate = camereInchiriate;
			return this;
		}
		
		public ClientDTO create(){
			return new ClientDTO(nestednume, nestedprenume, nestedtelefon, nestedadresa, nestedcamereInchiriate);
		}
	}
}
