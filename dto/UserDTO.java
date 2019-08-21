package spring.dto;


public class UserDTO {
	private Integer id;
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	private String utilizator;
	
	public UserDTO() {
	}

	public UserDTO(Integer id, String nume, String prenume, String email, String parola, String utilizator) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.utilizator = utilizator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
	public String getUtilizator() {
		return utilizator;
	}

	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}


	public static class Builder{
		private Integer nestedid;
		private String nestednume;
		private String nestedprenume;
		private String nestedemail;
		private String nestedparola;
		private String nestedutilizator;
		
		public Builder id(Integer id){
			this.nestedid = id;
			return this;
		}
		
		public Builder nume(String nume){
			this.nestednume = nume;
			return this;
		}
		
		public Builder prenume(String prenume){
			this.nestedprenume = prenume;
			return this;
		}
		
		public Builder email(String email){
			this.nestedemail = email;
			return this;
		}
		
		
		public Builder parola(String parola){
			this.nestedparola = parola;
			return this;
		}
		
		public Builder utilizator(String utilizator) {
			this.nestedutilizator = utilizator;
			return this;
		}
		
		public UserDTO create(){
			return new UserDTO(nestedid, nestednume, nestedprenume, nestedemail, nestedparola, nestedutilizator);
		}
	}
}
