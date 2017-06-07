package br.com.season.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.season.springproject.entity.Produto;

@Controller
public class ProdutoController {
	@RequestMapping("/produto")
	public String produto(ModelMap map){
		Produto produto = new Produto();
		map.addAttribute("produto", produto);
		return "produto";
	}
	
	@RequestMapping("/produto/save")
	public String save(Produto produto, ModelMap map){
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println("Preço: " + produto.getPreco());
		produto = new Produto();
		map.addAttribute("produto", produto);
		return "produto";
	}
}
