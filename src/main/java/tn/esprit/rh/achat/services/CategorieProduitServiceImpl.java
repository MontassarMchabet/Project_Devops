package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	private final CategorieProduitRepository categorieProduitRepository;

	@Autowired
	public CategorieProduitServiceImpl(CategorieProduitRepository categorieProduitRepository) {
		this.categorieProduitRepository = categorieProduitRepository;
	}

	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}


	@Override
	public CategorieProduit addOrUpdateCategorieProduit(CategorieProduit cp) {
		return categorieProduitRepository.save(cp);
	}


	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {

		return categorieProduitRepository.findById(id).orElse(null);
	}

}
