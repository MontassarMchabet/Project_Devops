package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Reglement;

import java.util.List;

@Repository
public interface ReglementRepository extends CrudRepository<Reglement, Long>{
	@Query("SELECT r FROM Reglement r where r.facture.idFacture=:idFacture")
	List<Reglement> retrieveReglementByFacture(@Param("idFacture") Long idFacture);
}
