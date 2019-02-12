package de.denizugurlu.sfgpetclinic.services.map;

import de.denizugurlu.sfgpetclinic.model.Pet;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
