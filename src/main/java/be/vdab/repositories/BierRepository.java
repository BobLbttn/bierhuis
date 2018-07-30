package be.vdab.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Bier;

public interface BierRepository extends JpaRepository<Bier, Long> {
}
