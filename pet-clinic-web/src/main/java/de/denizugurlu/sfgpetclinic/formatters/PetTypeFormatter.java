package de.denizugurlu.sfgpetclinic.formatters;

import de.denizugurlu.sfgpetclinic.model.PetType;
import de.denizugurlu.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();
        for(PetType type : petTypes) {
            if(type.getName().equals(s)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + s, 0);
    }
}
