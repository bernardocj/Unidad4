package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.TravelRepository;

import boot.model.Travel;

@Service @Transactional
public class TravelService {
	private final TravelRepository travelRepository;

	public TravelService(TravelRepository travelRepository) {
		super();
		this.travelRepository = travelRepository;
	}
	public List<Travel> findAll(){
		List<Travel> travels = new ArrayList<Travel>();
		for (Travel travel : travelRepository.findAll()) {
			travels.add(travel);
		}
		return travels;
	}
	
	public void saveTravel(Travel travel){
		travelRepository.save(travel);
	}
	
	public void deleteTravel(int id){
		travelRepository.delete(id);
	}
	
	public Travel findTravel(int id){
		return travelRepository.findOne(id);
	}
	
}
