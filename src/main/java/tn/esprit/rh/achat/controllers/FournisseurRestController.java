package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;


@RestController
@Api(tags = "Gestion des fournisseurss")
@RequestMapping("/fournisseur")
public class FournisseurRestController {
	private final IFournisseurService fournisseurService;
	@Autowired
	public FournisseurRestController(IFournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	public List<Fournisseur> getFournisseurs() {
		return fournisseurService.retrieveAllFournisseurs();
	}
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/8
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}
	// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")
	public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
		return fournisseurService.addFournisseur(f);
	}
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
	@PutMapping("/modify-fournisseur")
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.updateFournisseur(fournisseur);
	}
	// http://localhost:8089/SpringMVC/fournisseur/assignSecteurActiviteToFournisseur/1/5
		@PutMapping(value = "/assignSecteurActiviteToFournisseur/{idSecteurActivite}/{idFournisseur}")
		public void assignProduitToStock(@PathVariable("idSecteurActivite") Long idSecteurActivite, @PathVariable("idFournisseur") Long idFournisseur) {
			fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
		}

}
