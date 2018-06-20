package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Brouwer;


public interface BrouwerService {
	Optional<Brouwer> read(long id);
	List<Brouwer> findAll();
	long findAantalBrouwers();
}
