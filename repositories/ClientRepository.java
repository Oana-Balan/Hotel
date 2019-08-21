package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import spring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	
	Client findByNume(String nume);
	
	@Modifying(clearAutomatically = true)
	@Query("update Client c set c.camereInchiriate = ?1 where c.nume = ?2")
	void setClientByCamereInchiriate(Integer camereInchiriate, String nume);
}
