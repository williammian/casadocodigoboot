package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProductDAO;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
		
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	@Cacheable(value="books")
	public ModelAndView list(){
		System.out.println("Exibindo os livros");
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}
	
}
