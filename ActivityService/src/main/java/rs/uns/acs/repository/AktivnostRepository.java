package rs.uns.acs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.acs.model.Aktivnost;

public interface AktivnostRepository extends MongoRepository<Aktivnost, String> {

}
