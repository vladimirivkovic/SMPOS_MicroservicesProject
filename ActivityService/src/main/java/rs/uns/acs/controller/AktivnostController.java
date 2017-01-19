package rs.uns.acs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Aktivnost;
import rs.uns.acs.service.AktivnostService;

@RestController
public class AktivnostController extends AbstractRESTController<Aktivnost, String> {

	private AktivnostService aktivnostService;

	@Autowired
	public AktivnostController(AktivnostService service) {
		super(service);
		this.aktivnostService = service;
	}

}
