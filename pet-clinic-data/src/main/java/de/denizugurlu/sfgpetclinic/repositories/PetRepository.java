package de.denizugurlu.sfgpetclinic.repositories;

import de.denizugurlu.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
