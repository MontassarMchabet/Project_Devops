package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	private final FactureRepository factureRepository;
	private final OperateurRepository operateurRepository;
	private final FournisseurRepository fournisseurRepository;
	private final ReglementServiceImpl reglementService;
	@Autowired
	public FactureServiceImpl(FactureRepository factureRepository, OperateurRepository operateurRepository, FournisseurRepository fournisseurRepository, ReglementServiceImpl reglementService) {
		this.factureRepository = factureRepository;
		this.operateurRepository = operateurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.reglementService = reglementService;
	}

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = factureRepository.findAll();
		for (Facture facture : factures) {
			log.info(" facture : " + facture);
		}
		return factures;
	}

	
	public Facture addFacture(Facture f) {
		return factureRepository.save(f);
	}

	/*
	 * calculer les montants remise et le montant total d'un détail facture
	 * ainsi que les montants d'une facture
	 */

	@Override
	public void cancelFacture(Long factureId) {
		Facture facture = factureRepository.findById(factureId).orElse(new Facture());
		factureRepository.save(facture);
	}

	@Override
	public Facture retrieveFacture(Long factureId) {

		Facture facture = factureRepository.findById(factureId).orElse(null);
		log.info("facture :" + facture);
		return facture;
	}

	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);

		// Check if fournisseur is null
		if (fournisseur == null) {
			throw new IllegalArgumentException("Fournisseur not found");
		} else {
			return new ArrayList<>(fournisseur.getFactures());
		}
	}


	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		Facture facture = factureRepository.findById(idFacture).orElse(null);
		Operateur operateur = operateurRepository.findById(idOperateur).orElse(null);

		// Check if either facture or operateur is null
		if (facture == null || operateur == null) {
			throw new IllegalArgumentException("Facture or Operateur not found");
		} else {
			operateur.getFactures().add(facture);
			operateurRepository.save(operateur);
		}
	}


	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		return reglementService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
	}
	

}