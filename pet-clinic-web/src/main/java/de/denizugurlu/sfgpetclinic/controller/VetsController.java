package de.denizugurlu.sfgpetclinic.controller;

import de.denizugurlu.sfgpetclinic.model.Vet;
import de.denizugurlu.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @RequestMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
