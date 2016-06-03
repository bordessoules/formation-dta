package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = PizzaDaoSpringTest.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PizzaDaoTest {
	private static final int NB_INITIAL_PIZZA =7;
	protected IPizzaDao pizzaDao;
	
	public Pizza findOnePizza(String code){
		List <Pizza> pizzas=null;
		Pizza retour =null;
		try {
			pizzas = pizzaDao.findAllPizzas();
			for (Pizza p : pizzas){
				if (code.equals(p.getCode()) ){
					retour = p;
					break;
				}
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	@Test
	public void testfindAllPizza() throws DaoException {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NB_INITIAL_PIZZA, pizzas.size());
	}
	@Test
    public void testSavePizza() throws DaoException {
        Pizza pizza = new Pizza( "PEX", "Pépéroni X", 12.50, CategoriePizza.VIANDE, "http://placehold.it/150x150");
        pizzaDao.saveNewPizza(pizza);
        List<Pizza> pizzas = pizzaDao.findAllPizzas();
        assertEquals(NB_INITIAL_PIZZA + 1, pizzas.size());
        Pizza pizzaResult = findOnePizza("PEX");
        assertEquals("Pépéroni X", pizzaResult.getNom());
    }

    @Test
    public void testUpdatePizza() throws DaoException {
        Pizza onePizza = this.findOnePizza("PEP");
        onePizza.setNom("Pépéroni 2");
        pizzaDao.updatePizza("PEP", onePizza);

        Pizza pizzaResult = findOnePizza("PEP");
        assertEquals("Pépéroni 2", pizzaResult.getNom());
    }

    @Test
    public void testDeletePizza() throws DaoException {
        pizzaDao.deletePizza("PEP");
        List<Pizza> pizzas = pizzaDao.findAllPizzas();
        assertEquals(NB_INITIAL_PIZZA - 1, pizzas.size());
    }

    @Test
    public void testSaveAllPizza() throws DaoException {
        List<Pizza> pizzas = getListePizzas();
        pizzaDao.saveAllPizzas(pizzas, 3);

        List<Pizza> pizzasBdd = pizzaDao.findAllPizzas();
        assertEquals(NB_INITIAL_PIZZA + pizzas.size(), pizzasBdd.size());
    }

    @Test
    public void testSaveAllPizzaRollback() throws DaoException {
        List<Pizza> pizzas = getListePizzasWithErrors();
        try {
            pizzaDao.saveAllPizzas(pizzas, 7);
            fail("une exception aurait dû être lancée");
        } catch ( Exception e ) {


            assertNotNull(findOnePizza("PE1"));
            assertNotNull(findOnePizza("MA1"));
            assertNotNull(findOnePizza("RE1"));
            assertNotNull(findOnePizza("FR1"));
            assertNotNull(findOnePizza("CA1"));
            assertNotNull(findOnePizza("SV1"));
            assertNotNull(findOnePizza("OR1"));

            // IND 1 et SAU 1 ne doivent pas être insérés
            assertNull(findOnePizza("IN1"));
            assertNull(findOnePizza("SA1"));
        }


    }

    private List<Pizza> getListePizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza( "PE1", "Pépéroni 1", 12.50, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "MA1", "Margherita 1", 14.00, CategoriePizza.SANS_VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "RE1", "La Reine 1", 11.50, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        
        pizzas.add(new Pizza( "FR1", "La 4 fromages 1", 12.00, CategoriePizza.SANS_VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "CA1", "La cannibale 1", 12.50, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "SV1", "La savoyarde 1", 13.00, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        
        pizzas.add(new Pizza( "OR1", "L'orientale 1", 13.50, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "IN1", "L'indienne 1", 14.00, CategoriePizza.VIANDE, "http://placehold.it/150x150"));
        pizzas.add(new Pizza( "SA1", "La Saumonéta 1",14.00, CategoriePizza.POISSON, "http://placehold.it/150x150"));

        return pizzas;
    }

    private List<Pizza> getListePizzasWithErrors() {
        List<Pizza> pizzas = getListePizzas();
        pizzas.add(new Pizza( "IN1", "L'indienne 1", 14.00, CategoriePizza.VIANDE, "http://placehold.it/150x150"));

        return pizzas;
    }
}
