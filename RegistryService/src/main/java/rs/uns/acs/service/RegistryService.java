package rs.uns.acs.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.uns.acs.model.Registry;
import rs.uns.acs.repository.RegistryRepository;

@Service
public class RegistryService extends AbstractCRUDService<Registry, String> {

	private RegistryRepository registryRepository;
	
	public RegistryService(RegistryRepository repo) {
		super(repo);
		this.registryRepository = repo;
	}
	
	@Override
	public Registry save(Registry entity) {
		if (entity.getId() == null) {
			List<Registry> allBroj = registryRepository.findAll();
			int max = -1;

			for (Registry i : allBroj) {
				if (max < i.getBroj()) {
					max = i.getBroj();
				}
			}
			entity.setBroj(max + 1);
		}
		
		entity.setDatumOtvaranja(new Date());

		return super.save(entity);
	}
	
	public Registry findByRedniBroj(int broj) {
		return registryRepository.findByBroj(broj);
	}
	
	public Registry findActive() {
		List<Registry> all = registryRepository.findAll();
		
		Registry active = all.get(0);
		
		for (Registry r : all) {
			if (r.getDatumOtvaranja().after(active.getDatumOtvaranja())) {
				active = r;
			}
		}
		
		return active;
	}
}
