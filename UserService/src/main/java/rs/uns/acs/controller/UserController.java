package rs.uns.acs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.User;
import rs.uns.acs.model.User.Role;
import rs.uns.acs.service.UserService;

@RestController
@RequestMapping("api")
public class UserController extends AbstractRESTController<User, String>{
	
	private UserService userService;
    
	@Autowired
	public UserController(UserService userService) {
		super(userService);
		this.userService = userService;
	}
	
	@RequestMapping(value = "/checkUser", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> checkUser(
			@RequestHeader("Authorization") String userId
	){
		User user = userService.findById(userId);
		
		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>(user.makeLoginResponse(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(
			@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password){
		User u = userService.login(username, password);
		
		if (u == null) return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
//	@RequestMapping(value = "search/findByFirstName", method = RequestMethod.GET)
//	public List<User> findByAreaOfDanger(
//			@RequestParam(name = "firstName") String firstName) {
//		List<User> all = userService.findByFirstName(firstName);
//		return all;
//	}
//	
//	@RequestMapping(value = "search/findByFirstNamePageable", method = RequestMethod.GET)
//	public Map<String, Object> findByAreaOfDanger(
//			@RequestParam(name = "firstName") String firstName,
//			@RequestParam(name = "page", defaultValue = "0") Integer page) {
//		Page<User> all = userService.findByFirstName(firstName, new PageRequest(page, pageSize));
//		return prepareListPage(all);
//	}
	
	@RequestMapping(value = "findByUloga", method = RequestMethod.GET)
	public List<User> findByAreaOfDanger(
			@RequestParam(name = "uloga") Role uloga) {
		List<User> all = userService.findByUloga(uloga);
		return all;
	}


}
