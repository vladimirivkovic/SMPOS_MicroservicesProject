package rs.uns.acs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Aktivnost;
import rs.uns.acs.service.AktivnostService;

@RestController
@RequestMapping("api")
public class AktivnostController extends AbstractRESTController<Aktivnost, String> {

	private AktivnostService aktivnostService;

	@Autowired
	public AktivnostController(AktivnostService service) {
		super(service);
		this.aktivnostService = service;
	}
	
	@RequestMapping(value = "findByBrMere", method = RequestMethod.GET)
	public List<Aktivnost> getAllFor(@RequestParam("brojMere") Integer brojMere) {
		
		return aktivnostService.getAllFor(brojMere);
	}
	
	@RequestMapping(value = "checkActivities", method = RequestMethod.GET)
	public Boolean checkAcitivies(@RequestParam("brojMere") Integer brojMere) {
		
		return aktivnostService.checkActivitiesForClosing(brojMere);
	}
}
