package be.vdab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@Service
@ReadOnlyTransactionService
public class DefaultBrouwerService implements BrouwerService {
	private final BrouwerRepository brouwerRepository;
	
	
	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	public Optional<Brouwer> read(long id) {
		return Optional.ofNullable(brouwerRepository.findOne(id));
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll(new Sort("naam"));
	}

	@Override
	public long findAantalBrouwers() {
		return brouwerRepository.count();
	}

}
