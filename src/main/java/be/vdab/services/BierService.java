package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Bier;

public interface BierService {
	Optional<Bier> read(long id);
	List<Bier> findAll();
	long findAantalBieren();
}
