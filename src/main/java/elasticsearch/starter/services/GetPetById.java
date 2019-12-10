package elasticsearch.starter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import elasticsearch.starter.PetImpl.IGetPetById;
import io.swagger.model.Pet;

public class GetPetById implements IGetPetById {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetPetById.class);

	@Override
	public ResponseEntity<Pet> execute(String id) {
		LOGGER.info("Entered GetPetById class");
		return null;
	}

}
