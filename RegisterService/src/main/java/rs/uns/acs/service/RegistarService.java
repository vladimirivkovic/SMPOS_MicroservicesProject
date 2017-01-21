package rs.uns.acs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.acs.model.Registar;
import rs.uns.acs.repository.RegistarRepository;

@Service
public class RegistarService extends AbstractCRUDService<Registar, String> {
	
	private RegistarRepository registarRepository;

	@Autowired
	public RegistarService(RegistarRepository repo) {
		super(repo);
		this.registarRepository = repo;
	}
	
	@Override
	public Registar save(Registar entity) {
		List<Registar> allBrojMere = registarRepository.findAll();
		//List<Integer> allBroj = registarRepository.findAllRedniBroj();
		int max = -1;
		for(Registar i : allBrojMere) {
			if (max < i.getRedniBroj()) {
				max = i.getRedniBroj();
			}
		}
		entity.setRedniBroj(max+1);
		
		return super.save(entity);
	}

}
