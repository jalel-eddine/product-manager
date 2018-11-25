package com.riahi;

import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SystemPropertyUtils;

import com.riahi.dao.CategorieRepository;
import com.riahi.dao.ProduitRepository;
import com.riahi.entities.Categorie;
import com.riahi.entities.Produit;
import com.riahi.metier.ProductMangerService;

@SpringBootApplication
public class ProductServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}

@Configuration
class InjectData implements CommandLineRunner {

	@Autowired
	public ProductMangerService productMangerService ;
	@Autowired
	ProduitRepository Product;
	@Autowired 
	CategorieRepository catt ;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//final Log logger = LogFactory.getLog(getClass());
		
		Stream.of("AAAAAAA", "BBBBBBB" , "CCCCCCCC" , "DDDDDDDD" , "EEEEEEE" , "FFFFFFFFFF")
			.forEach(c -> productMangerService.enregistrerCategorie(new Categorie(c)) );
		
		productMangerService.listCategorie()
			.forEach(l -> System.out.println( l.getIdCategori()+ " "+l.getNomCategorie()));
	
		Categorie c1 = productMangerService.getCatByDes("AAAAAAA") ;
		Categorie c2 = productMangerService.getCatByDes("BBBBBBB") ;
		
		
		Stream.of("PROD11111" , "PROD11222" , "PROD11333" , "PROD11444" , "PROD11555").forEach(nP ->{
			productMangerService.enregistrerProduit(new Produit(nP), c1 ) ;
		});
		
		Stream.of("PROD22111" , "PROD22222" , "PROD22333" , "PROD22444" , "PROD22555").forEach(nP ->{
			productMangerService.enregistrerProduit(new Produit(nP), c2 ) ;
		});
		
		System.out.println("-------------------------------------");
		c1.getProduits()
			.forEach(lp -> System.out.println(lp.getIdProduit() + " "+lp.getDesignation()));
		System.out.println("-------------------------------------");
		c2.getProduits()
		.forEach(lp -> System.out.println(lp.getIdProduit() + " "+lp.getDesignation()));
		
	}
	
	
}
