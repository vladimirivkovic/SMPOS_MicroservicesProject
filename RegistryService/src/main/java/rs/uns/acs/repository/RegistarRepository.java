package rs.uns.acs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.acs.model.Registar;

public interface RegistarRepository extends MongoRepository<Registar, String> {

	//public List<Integer> findAllRedniBroj();
	public Registar findByRedniBroj(int redniBroj);
	public Registar findById(String id);
	public List<Registar> findByBrojRegistra(int brojRegistra);
	public List<Registar> findByPpu(String ppu);

}
