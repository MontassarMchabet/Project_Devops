package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.List;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {
	private final ISecteurActiviteService secteurActiviteService;
	@Autowired
	public SecteurActiviteController(ISecteurActiviteService secteurActiviteService) {
		this.secteurActiviteService = secteurActiviteService;
	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivite
	@GetMapping("/retrieve-all-secteurActivite")
	public List<SecteurActivite> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();
	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-secteurActivite/8
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/add-secteurActivite
	@PostMapping("/add-secteurActivite")
	public SecteurActivite addSecteurActivite(@RequestBody SecteurActivite sa) {
		return secteurActiviteService.saveOrUpdateSecteurActivite(sa);
	}

	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	@PutMapping("/modify-secteurActivite")
	public SecteurActivite modifySecteurActivite(@RequestBody SecteurActivite secteurActivite) {
		return secteurActiviteService.saveOrUpdateSecteurActivite(secteurActivite);
	}

	
}
