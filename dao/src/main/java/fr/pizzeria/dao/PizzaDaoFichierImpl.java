package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class PizzaDaoFichierImpl implements IPizzaDao {

	private static final String REPERTOIRE_DATA = "Data";
  
	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		try (Stream<Path> s = Files.list(Paths.get(REPERTOIRE_DATA))) {
			return s.map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(Double.valueOf(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (Exception e) {
					e.printStackTrace();
				}

				return p;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws DaoException {
		
		
		try {
			Path nf = Paths.get(REPERTOIRE_DATA + "/" + pizza.getCode() + ".txt");
			System.out.println(nf);
			String ligne = pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCategorie();
			Files.write(nf,Arrays.asList(ligne),StandardOpenOption.CREATE_NEW );

		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		throw new DaoException("méthode non implémentée");		
	}

}