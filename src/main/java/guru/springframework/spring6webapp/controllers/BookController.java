package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.IBookService;

@Controller
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books",bookService.findAll());

        return "books";
    }

}
