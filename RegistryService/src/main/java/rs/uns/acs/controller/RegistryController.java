package rs.uns.acs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Registry;
import rs.uns.acs.service.RegistryService;

@RestController
@RequestMapping("api/registar")
public class RegistryController extends AbstractRESTController<Registry, String>{
	
	private RegistryService registarService;

	@Autowired
	public RegistryController(RegistryService service) {
		super(service);
		this.registarService = service;
	}
}
