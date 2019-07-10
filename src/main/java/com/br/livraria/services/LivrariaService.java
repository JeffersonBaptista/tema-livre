package com.br.livraria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.livraria.models.LivrariaModel;

@Service
public class LivrariaService {

	List<LivrariaModel> listaLivros = new ArrayList<LivrariaModel>();

	public List<LivrariaModel> exibirAcervo() {
		return listaLivros;
	}

	public void cadastrarLivro(String titulo, String autor, String categotia, String editora, String isbn,
			String codigoBarras, double preco) {
		if (listaLivros.isEmpty() == true) {
			LivrariaModel livro = new LivrariaModel(0, titulo, autor, categotia, editora, isbn, codigoBarras, preco);
			listaLivros.add(livro);
		} else {
			int id = listaLivros.size();
			LivrariaModel livro = new LivrariaModel(id, titulo, autor, categotia, editora, isbn, codigoBarras, preco);
			listaLivros.add(livro);

		}
	}

	public LivrariaModel buscarLivro(int id) {
		LivrariaModel livro = null;

		for (LivrariaModel livrariaModel : listaLivros) {
			if (livrariaModel.getId() == id) {
				livro = livrariaModel;
			}

		}
		return livro;

	}

}
