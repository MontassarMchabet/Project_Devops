package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	void deleteCategorieProduit(Long id);

	CategorieProduit addOrUpdateCategorieProduit(CategorieProduit cp);

	CategorieProduit retrieveCategorieProduit(Long id);

}
