package guru.springframework.spring7webapp.controllers;

import guru.springframework.spring7webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(path = "/authors")
    public String authors(Model model) {
        model.addAttribute("authors", this.authorService.findAll());

        return "authors";
    }
}
