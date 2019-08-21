package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import spring.entities.Camera;

public interface CameraRepository extends JpaRepository<Camera, Integer>{
	Camera findByNumar(Integer numar);
	
	@Modifying(clearAutomatically = true)
	@Query("update Camera c set c.disponibilitate = ?1 where c.numar = ?2")
	void setCameraByDisponibilitate(String disponibilitate, Integer numar);
}
