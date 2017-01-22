package rs.uns.acs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rs.uns.acs.model.Registar;
import rs.uns.acs.model.Registry;
import rs.uns.acs.repository.RegistarRepository;

@Service
public class RegistarService extends AbstractCRUDService<Registar, String> {

	private RegistarRepository registarRepository;
	private RestTemplate restTemplate;
	private static final String activityUrl = "http://localhost:8765/activity/api/checkActivities?brojMere=";

	@Autowired
	private RegistryService registryService;
	
	@Autowired
	public RegistarService(RegistarRepository repo) {
		super(repo);
		this.registarRepository = repo;
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Registar save(Registar entity) {
		Registry reg = registryService.findActive();
		entity.setBrojRegistra(reg.getBroj());
		
		if (entity.getId() == null) {
			List<Registar> allBrojMere = registarRepository.findByBrojRegistra(reg.getBroj());
			int max = -1;

			for (Registar i : allBrojMere) {
				if (max < i.getRedniBroj()) {
					max = i.getRedniBroj();
				}
			}
			entity.setRedniBroj(max + 1);
		}

		return super.save(entity);
	}

	@Override
	public Registar update(String id, Registar newEntity) {
		if (newEntity.getOstvarenRok() != null) {
			Registar old = registarRepository.findById(id);

			if (old != null && !newEntity.getOstvarenRok().equals(old.getOstvarenRok())) {
				CommunicationService<Boolean> c = new CommunicationService<>(Boolean.class, restTemplate);
				String url = activityUrl + newEntity.getRedniBroj();

				Boolean response = c.get(url);
				if (!response)
					throw new IllegalArgumentException("Registry entry cannot be closed!");
			}
		}
		
		return super.update(id, newEntity);
	}

	public Registar findByRedniBroj(int redniBroj) {
		return registarRepository.findByRedniBroj(redniBroj);
	}

}
