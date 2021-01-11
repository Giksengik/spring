package ru.vlasov.MVCFirstApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlasov.MVCFirstApp.dao.PersonDao;
import ru.vlasov.MVCFirstApp.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDAO;

    @Autowired
    public PeopleController(PersonDao personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("perspn") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }
}
