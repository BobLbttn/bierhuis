package be.vdab.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import be.vdab.entities.Bier;
import be.vdab.repositories.BierRepository;

@Service
@ReadOnlyTransactionService
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
		
		return bierRepository.findAll();
	}

	@Override
	public long findAantalBieren() {
		return bierRepository.count();
	}

}
