package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{
	private final SecteurActiviteRepository secteurActiviteRepository;
	@Autowired
	public SecteurActiviteServiceImpl(SecteurActiviteRepository secteurActiviteRepository) {
		this.secteurActiviteRepository = secteurActiviteRepository;
	}
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActivite saveOrUpdateSecteurActivite(SecteurActivite sa) {
		// Check if the secteurActivite already exists in the database
		Optional<SecteurActivite> existingSecteurActivite = secteurActiviteRepository.findById(sa.getIdSecteurActivite());

		if (existingSecteurActivite.isPresent()) {
			// If the secteurActivite exists, update it
			SecteurActivite updatedSecteurActivite = existingSecteurActivite.get();
			updatedSecteurActivite.setFournisseurs(sa.getFournisseurs());

			return secteurActiviteRepository.save(updatedSecteurActivite);
		} else {
			// If the secteurActivite does not exist, add it
			return secteurActiviteRepository.save(sa);
		}
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		return secteurActiviteRepository.findById(id).orElse(null);
	}

}
