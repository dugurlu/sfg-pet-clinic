package de.denizugurlu.sfgpetclinic.repositories;

import de.denizugurlu.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
