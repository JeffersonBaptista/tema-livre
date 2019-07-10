package com.br.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.livraria.services.LivrariaService;

@Controller
public class LivroController {

	@Autowired
	LivrariaService livrariaservice;

	@GetMapping("/")
	public ModelAndView exibirAcervo() {
		ModelAndView modelAndView = new ModelAndView("acervo.html");
		modelAndView.addObject("livros", livrariaservice.exibirAcervo());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cadastrar.html");
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrarLivro(String titulo, String autor, String categotia, String editora, String isbn,
			String codigoBarras, double preco) {
		
		livrariaservice.cadastrarLivro(titulo, autor, categotia, editora, isbn, codigoBarras, preco);
		return "redirect:/";

	}

	@GetMapping("/fichaCatalografica/{id}")
	public ModelAndView fichaCatalografica(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("fichaCatalografica.html");
		modelAndView.addObject("livros", livrariaservice.buscarLivro(id));
		return modelAndView;
	}


}
