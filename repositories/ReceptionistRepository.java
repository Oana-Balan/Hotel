package spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entities.Receptionist;

public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer>{

	Receptionist findByNrCamera(Integer nr);
	
	List<Receptionist> findAllByIdUser(Integer id);
	
	List<Receptionist> findByDataSosireAndDataPlecare(Date sosire, Date plecare);
}
