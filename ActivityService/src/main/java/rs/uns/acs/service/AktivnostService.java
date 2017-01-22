package rs.uns.acs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rs.uns.acs.model.Aktivnost;
import rs.uns.acs.repository.AktivnostRepository;

@Service
public class AktivnostService extends AbstractCRUDService<Aktivnost, String>{
	
	private AktivnostRepository aktivnostRepository;
	private RestTemplate restTemplate;
	private static final String registryUrl = "http://localhost:8765/registry/api/checkRegistry?redniBroj=";
	
	@Autowired
	public AktivnostService(AktivnostRepository repo) {
		super(repo);
		this.aktivnostRepository = repo;
		this.restTemplate = new RestTemplate();
	}
	
	public List<Aktivnost> getAllFor(int brojMere) {
		return aktivnostRepository.findByBrojMere(brojMere);
	}
	
    @Override
	public Aktivnost save(Aktivnost entity) {
    	CommunicationService<Boolean> c = new CommunicationService<>(Boolean.class, restTemplate);
    	String url = registryUrl + entity.getBrojMere();

    	Boolean response = c.get(url);

    	if (response)
    		return super.save(entity);
    	else
    		throw new IllegalArgumentException("Registry does not exist!");
	}
    
    public Boolean checkActivitiesForClosing(int brojMere) {
    	List<Aktivnost> a = aktivnostRepository.findByBrojMere(brojMere);
    	
    	for (Aktivnost i : a) {
    		if (!(i.getObimRealizacije() != null 
    				&& i.getVerifikacijaEfekta() != null 
    				&& i.getDatumVerifikacije() != null)) {
    			return false;
    		}
    	}
    	
    	return true;
    }

}
