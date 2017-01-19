package rs.uns.acs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Registar;
import rs.uns.acs.service.RegistarService;

@RestController
@RequestMapping("registar")
public class RegistarController extends AbstractRESTController<Registar, String>{
	
	private RegistarService registarService;

	public RegistarController(RegistarService service) {
		super(service);
		this.registarService = service;
	}

}
