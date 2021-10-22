package com.nagarro.productmanagementspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.productmanagementspringboot.models.Book;

@Controller("/display")
public class DisplayController {

	@Autowired
	private ProductController productController;

	@RequestMapping(path = "/addBookAndRedirect", method = RequestMethod.POST)
	public String addBookAndRedirect(@ModelAttribute("book") Book book, Model model) {

		try {
			this.productController.addBook(book);
			return "addBook";
		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
	}

	@RequestMapping(path = "/addAnother", method = RequestMethod.POST)
	public String addAnother(Model model) {
		return "home";
	}

	@RequestMapping(path = "/getAllBooks", method = RequestMethod.POST)
	public String getAllBooks(Model model) {

		List<Book> list = this.productController.getBooks(model);
		model.addAttribute("list", list);

		return "booklist";
	}

	@RequestMapping(path = "/deleteBookAndRedirect/{bookCode}")
	public String deleteBookAndRedirect(@PathVariable("bookCode") int bookCode) {

		try {
			this.productController.deleteBook(bookCode);
			return "deleteBook";
		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
	}

	@RequestMapping(path = "/editBookAndRedirect/{bookCode}")
	public String editBook(@PathVariable("bookCode") int bookCode, @RequestBody Book book) {

		try {
			this.productController.editBook(bookCode, book);
			return "editBook";
		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
	}

	@GetMapping(path = "/list")
	public String list() {
		return "booklist";
	}
}
