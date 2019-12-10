package elasticsearch.starter;

import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.ApiParam;
import io.swagger.api.PetApi;
import io.swagger.model.Pet;

@Controller
@Scope(value = "prototype")
public class PetImpl implements PetApi, ApplicationContextAware {

	@Inject
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public interface IGetPetById {
		public ResponseEntity<Pet> execute(String id);
	}

	@Override
	public ResponseEntity<Pet> getPetById(
			@ApiParam(value = "ID of pet to return", required = true) @PathVariable("petId") String petId) {
		PetImpl.IGetPetById service = this.applicationContext.getBean(PetImpl.IGetPetById.class);
		return service.execute(petId);
	}

}
