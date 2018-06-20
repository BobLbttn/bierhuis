package be.vdab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import be.vdab.entities.Bier;
import be.vdab.repositories.BierRepository;

public class DefaultBierService implements BierService {

	final private BierRepository bierRepository;
	
	public DefaultBierService(BierRepository bierRepository) {
		this.bierRepository = bierRepository;
	}
	
	@Override
	public Optional<Bier> read(long id) {
		return Optional.ofNullable(bierRepository.findOne(id));
	}

	@Override
	public List<Bier> findAll() {
		
		return bierRepository.findAll(new Sort("naam"));
	}

	@Override
	public long findAantalBieren() {
		return bierRepository.count();
	}

}
