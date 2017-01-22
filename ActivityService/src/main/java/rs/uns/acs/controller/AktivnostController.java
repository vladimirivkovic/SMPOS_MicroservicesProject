package rs.uns.acs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value = "findByBrMere")
	public List<Aktivnost> getAllFor(@RequestParam("brojMere") int brojMere) {
		
		return aktivnostService.getAllFor(brojMere);
	}
	
	@Override
	public Map<String, Object> save(Aktivnost newEntity) {
		// TODO Auto-generated method stub
		return super.save(newEntity);
	}

}
