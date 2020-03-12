package bike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import bike.object.Bike;

@Service
public class BikeServiceImpl implements BikeService{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveBike(Bike bike) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(bike, "bikes");
	}
}
