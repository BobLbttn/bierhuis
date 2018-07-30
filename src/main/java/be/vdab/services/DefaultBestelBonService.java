package be.vdab.services;

import org.springframework.stereotype.Service;

import be.vdab.entities.BestelBon;
import be.vdab.repositories.BestelBonRepository;

@Service
@ReadOnlyTransactionService
public class DefaultBestelBonService implements BestelBonService {

	private final BestelBonRepository bestelbonRepository;

	public DefaultBestelBonService(BestelBonRepository bbr) {
		this.bestelbonRepository=bbr;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(BestelBon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}

}
