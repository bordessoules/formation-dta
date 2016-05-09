package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	
	private PizzaDaoImpl dao;
	private List<Pizza> listePizzasInitiales;

	@Before
	public void setUp() throws Exception {
		dao = new PizzaDaoImpl();
		listePizzasInitiales = new ArrayList<Pizza>();
		//gerer l'ajout des pizza par fichier sans utilis� findall
		listePizzasInitiales.add(new Pizza("PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("MAR","Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		listePizzasInitiales.add(new Pizza("REI","La Reine", 11.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		listePizzasInitiales.add(new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("IND", "L'indienne", 14.00,CategoriePizza.VIANDE));
		/*
		listePizzasInitiales.add(new Pizza("PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		
		listePizzasInitiales.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		
		listePizzasInitiales.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		
		listePizzasInitiales.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		
		listePizzasInitiales.add(new Pizza("SAU", "La Saumon�ta", 14.00, CategoriePizza.POISSON));
		*/
		listePizzasInitiales.sort(Comparator.comparing(Pizza::getCode));
	}
	
	@Test
	public void testFindAllPizzas() throws DaoException {
		List<Pizza> resultat = dao.findAllPizzas();
		resultat.sort(Comparator.comparing(Pizza::getCode));
		Pizza[] tabPizzasInitiales = listePizzasInitiales.<Pizza> toArray(new Pizza[0]);
		Pizza[] tabResultatObtenu = resultat.<Pizza> toArray(new Pizza[0]);
		assertArrayEquals(tabPizzasInitiales, tabResultatObtenu);

	}

	@Test
	public void testSavePizzaCodeNonExistant() throws DaoException {
		Pizza newPizza = new Pizza("CODE_INEXISTANT", "Nouveau nom", 15, CategoriePizza.VIANDE);
		dao.saveNewPizza(newPizza);
		List<Pizza> listPizzas = dao.findAllPizzas();
		assertTrue(listPizzas.contains(newPizza));
	}

	@Test(expected = SavePizzaException.class)
	public void testSavePizzaCodeExistant() throws DaoException {
		Pizza newPizza = new Pizza("PEP", "Nouveau nom", 15, CategoriePizza.VIANDE);
		dao.saveNewPizza(newPizza);
	}

	@Test
	public void testUpdatePizzaCodeExistant() throws DaoException {
		Pizza updatePizza = new Pizza("PEP", "PEP2", 15, CategoriePizza.VIANDE);
		dao.updatePizza("PEP", updatePizza);
		List<Pizza> listPizzas = dao.findAllPizzas();
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertTrue(pizzaOpt.isPresent());
		Pizza pizzaTrouve = pizzaOpt.get();
		assertEquals("PEP", pizzaTrouve.getCode());
		assertEquals("PEP2", pizzaTrouve.getNom());
		assertTrue(pizzaTrouve.getPrix() == 15.0);
		assertEquals(CategoriePizza.VIANDE, pizzaTrouve.getCategorie());
	}

	@Test
	public void testDeletePizza() throws DaoException {
		List<Pizza> listPizzas = dao.findAllPizzas();
		assertEquals(8, listPizzas.size());
		dao.deletePizza("PEP");
		listPizzas = dao.findAllPizzas();
		assertEquals(7, listPizzas.size());
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertFalse(pizzaOpt.isPresent());
	}
	
	@Test(expected = DeletePizzaException.class)
	public void testDeletePizzaCodeInexistant() throws DaoException {
		dao.deletePizza("PEP1");
	}

}
