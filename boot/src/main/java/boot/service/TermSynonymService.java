package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TermSynonymRepository;
import boot.model.TermSynonym;

@Service @Transactional
public class TermSynonymService {
	private final TermSynonymRepository termSynonymRepository;

	public TermSynonymService(TermSynonymRepository termSynonymRepository) {
		super();
		this.termSynonymRepository = termSynonymRepository;
	}
	public List<TermSynonym> findAll(){
		List<TermSynonym> termSynonyms = new ArrayList<TermSynonym>();
		for (TermSynonym termSynonym : termSynonymRepository.findAll()) {
			termSynonyms.add(termSynonym);
		}
		return termSynonyms;
	}
	
	public void saveTermSynonym(TermSynonym termSynonym){
		termSynonymRepository.save(termSynonym);
	}
	
	public void deleteTermSynonym(int id){
		termSynonymRepository.delete(id);
	}
	
	public TermSynonym findTermSynonym(int id){
		return termSynonymRepository.findOne(id);
	}
	
}
