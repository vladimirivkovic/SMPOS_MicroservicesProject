package rs.uns.acs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.acs.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByImeAndPrezime(String ime, String prezime);
	
	public User findByUsername(String username);
	
	public User findById(String userId);
	
	public List<User> findByUloga(User.Role uloga);
	
}