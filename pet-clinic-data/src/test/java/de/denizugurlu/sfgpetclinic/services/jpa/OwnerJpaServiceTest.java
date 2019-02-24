package de.denizugurlu.sfgpetclinic.services.jpa;

import de.denizugurlu.sfgpetclinic.model.Owner;
import de.denizugurlu.sfgpetclinic.repositories.OwnerRepository;
import de.denizugurlu.sfgpetclinic.repositories.PetRepository;
import de.denizugurlu.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final Long ID = 1L;
    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService service;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner owner = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        assertEquals(ID, owner.getId());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));

        Owner owner = service.findById(ID);

        assertNotNull(owner);
        assertEquals(ID, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(ID);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);

        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnedOwner);

        verify(ownerRepository).delete(any());
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(ID);

        verify(ownerRepository).deleteById(anyLong());
        assertEquals(0, service.findAll().size());
    }
}