package rs.uns.acs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.acs.model.User;
import rs.uns.acs.repository.UserRepository;

@Service
public class UserService extends AbstractCRUDService<User, String>{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository){
		super(userRepository);
		this.userRepository = userRepository;
	}
	
	public User login(String username, String password){
		User user = userRepository.findByUsername(username);
		
		if(user != null){
			if(user.getPassword().equals(password)){
				return user;
			}
		}
		
		return null;
	}
	
	public User findByImeAndPrezime(String ime, String prezime){
		return userRepository.findByImeAndPrezime(ime, prezime);
	}
	
	public User findById(String userId) {
		return userRepository.findById(userId);
	}

}
