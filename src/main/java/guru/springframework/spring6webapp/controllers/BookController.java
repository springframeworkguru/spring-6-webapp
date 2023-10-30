package guru.springframework.spring6webapp.controllers;


import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.services.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

}
