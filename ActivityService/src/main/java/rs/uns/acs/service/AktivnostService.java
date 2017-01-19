package rs.uns.acs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.acs.model.Aktivnost;
import rs.uns.acs.repository.AktivnostRepository;

@Service
public class AktivnostService extends AbstractCRUDService<Aktivnost, String>{
	
	private AktivnostRepository aktivnostRepository;
	
	@Autowired
	public AktivnostService(AktivnostRepository repo) {
		super(repo);
		this.aktivnostRepository = repo;
	}
	
	public List<Aktivnost> getAllFor(int brojMere) {
		return aktivnostRepository.findByBrojMere(brojMere);
	}

}
