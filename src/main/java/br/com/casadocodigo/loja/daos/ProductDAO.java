package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

public interface ProductDAO extends Repository<Product, Integer> {
	
	@Query("select distinct(p) from Product p join fetch p.prices")
	public List<Product> list();
	
	@Query("select sum(price.value) from Product p join	p.prices price where price.bookType =:bookType")
	public BigDecimal sumPricesPerType(@Param("book")BookType book);
	
}
