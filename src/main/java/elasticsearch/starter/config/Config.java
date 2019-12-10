package elasticsearch.starter.config;

import org.springframework.context.annotation.Bean;

import elasticsearch.starter.PetImpl;
import elasticsearch.starter.PetImpl.IGetPetById;
import elasticsearch.starter.services.GetPetById;
import io.swagger.api.PetApi;

public class Config {

	@Bean
	public IGetPetById getPetById() {
		return new GetPetById();
	}

	@Bean
	public PetApi petApi() {
		return new PetImpl();
	}
}
