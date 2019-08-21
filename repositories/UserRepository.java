package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import spring.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u.utilizator from User u where u.email = ?1 and u.parola = ?2")
	String findByEmailAndParola(String email, String parola);
	
	@Query("select u.id from User u where u.email = ?1 and u.parola = ?2 and u.utilizator = ?3")
	Integer findByEmailAndParolaAndUtilizator(String email, String parola, String utilizator);
	
	User findByUtilizator(String utilizator);
	
	User findByNume(String nume);
	
	User findById(Integer id);
	
	@Modifying(clearAutomatically = true)
	@Query("update User u set u.nume = ?1, u.email = ?2 where u.id = ?3")
	void setUserById(String nume, String email, Integer id);
}
