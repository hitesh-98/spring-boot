package com.nagarro.productmanagementspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.productmanagementspringboot.models.Book;

@RestController
@RequestMapping("/template/books")
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public List<Book> getBooks(Model model) {

		ObjectMapper mapper = new ObjectMapper();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String result = restTemplate.exchange("http://localhost:9090/books/", HttpMethod.GET, entity, String.class)
				.getBody();

		List<Book> list = null;
		try {
			list = mapper.readValue(result, new TypeReference<List<Book>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addBook(@RequestBody Book book) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);

		return restTemplate.exchange("http://localhost:9090/books/", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/{bookCode}", method = RequestMethod.PUT)
	public String editBook(@PathVariable("bookCode") int bookCode, @RequestBody Book book) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);

		return restTemplate.exchange("http://localhost:9090/books/" + bookCode, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/{bookCode}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bookCode") int bookCode) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Book> entity = new HttpEntity<Book>(headers);

		return restTemplate.exchange("http://localhost:9090/books/" + bookCode, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}

}