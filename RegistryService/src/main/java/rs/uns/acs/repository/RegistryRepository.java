package rs.uns.acs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.acs.model.Registry;

public interface RegistryRepository extends MongoRepository<Registry, String> {
	public Registry findByBroj(int broj);
	public Registry findById(String id);
}
