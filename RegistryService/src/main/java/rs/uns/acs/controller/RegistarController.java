package rs.uns.acs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.acs.model.Registar;
import rs.uns.acs.service.RegistarService;

@RestController
@RequestMapping("api/mere")
public class RegistarController extends AbstractRESTController<Registar, String>{
	
	private RegistarService registarService;

	@Autowired
	public RegistarController(RegistarService service) {
		super(service);
		this.registarService = service;
	}
	
	@RequestMapping("checkRegistry")
	public String checkRegistry(@RequestParam("redniBroj") Integer redniBroj) {
		Registar reg = registarService.findByRedniBroj(redniBroj);
		
		if (reg != null)
			return reg.getRukovodilacTima();
		else 
			return "";
	}
	
	@RequestMapping("checkClosedRegistry")
	public Boolean checkClosedRegistry(@RequestParam("ppu") String ppu) {
		return registarService.checkClosedRegistry(ppu);
	}

}
