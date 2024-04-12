package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
@CrossOrigin("*")
public class OperateurController {
	private final IOperateurService operateurService;
	@Autowired
	public OperateurController(IOperateurService operateurService) {
		this.operateurService = operateurService;
	}

	// http://localhost:8089/SpringMVC/operateur/retrieve-all-operateurs
	@GetMapping("/retrieve-all-operateurs")
	public List<Operateur> getOperateurs() {
		return operateurService.retrieveAllOperateurs();
	}

	// http://localhost:8089/SpringMVC/operateur/retrieve-operateur/8
	@GetMapping("/retrieve-operateur/{operateur-id}")
	public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
		return operateurService.retrieveOperateur(operateurId);
	}

	// http://localhost:8089/SpringMVC/operateur/add-operateur
	@PostMapping("/add-operateur")
	public Operateur addOperateur(@RequestBody Operateur op) {
		return operateurService.addOrUpdateOperateur(op);
	}

	@DeleteMapping("/remove-operateur/{operateur-id}")
	public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
		operateurService.deleteOperateur(operateurId);
	}

	// http://localhost:8089/SpringMVC/operateur/modify-operateur
	@PutMapping("/modify-operateur")
	public Operateur modifyOperateur(@RequestBody Operateur operateur) {
		return operateurService.addOrUpdateOperateur(operateur);
	}

	
}
