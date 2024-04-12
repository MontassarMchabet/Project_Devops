package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.List;

@Service
public class OperateurServiceImpl implements IOperateurService {
	private final OperateurRepository operateurRepository;
	@Autowired
	public OperateurServiceImpl(OperateurRepository operateurRepository) {
		this.operateurRepository = operateurRepository;
	}

	@Override
	public List<Operateur> retrieveAllOperateurs() {
		return (List<Operateur>) operateurRepository.findAll();
	}


	@Override
	public void deleteOperateur(Long id) {
		operateurRepository.deleteById(id);
		
	}


	@Override
	public Operateur addOrUpdateOperateur(Operateur o){
		return operateurRepository.save(o);
	}


	@Override
	public Operateur retrieveOperateur(Long id) {
		return operateurRepository.findById(id).orElse(null);
	}

}
