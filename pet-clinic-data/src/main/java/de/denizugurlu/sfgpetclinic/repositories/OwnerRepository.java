package de.denizugurlu.sfgpetclinic.repositories;

import de.denizugurlu.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
