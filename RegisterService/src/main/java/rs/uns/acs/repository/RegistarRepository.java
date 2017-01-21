package rs.uns.acs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.acs.model.Registar;

public interface RegistarRepository extends MongoRepository<Registar, String> {

	//public List<Integer> findAllRedniBroj();

}
