package guru.springframework.spring7webapp.controllers;

import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.services.Bookservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final Bookservice bookservice;

    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @RequestMapping(path = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", this.bookservice.findAll());

        return "books";
    }
}
