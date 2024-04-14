package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
}
