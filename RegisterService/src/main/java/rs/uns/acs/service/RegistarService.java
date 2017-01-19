package rs.uns.acs.service;

import org.springframework.stereotype.Service;

import rs.uns.acs.model.Registar;
import rs.uns.acs.repository.RegistarRepository;

@Service
public class RegistarService extends AbstractCRUDService<Registar, String> {
	
	private RegistarRepository registarRepository;

	public RegistarService(RegistarRepository repo) {
		super(repo);
		this.registarRepository = repo;
	}

}
