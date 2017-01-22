package rs.uns.acs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Registar;
import rs.uns.acs.service.RegistarService;

@RestController
@RequestMapping("api")
public class RegistarController extends AbstractRESTController<Registar, String>{
	
	private RegistarService registarService;

	@Autowired
	public RegistarController(RegistarService service) {
		super(service);
		this.registarService = service;
	}
	
	@RequestMapping("checkRegistry")
	public Boolean checkRegistry(@RequestParam("redniBroj") Integer redniBroj) {
		return registarService.findByRedniBroj(redniBroj) != null;
	}

}
