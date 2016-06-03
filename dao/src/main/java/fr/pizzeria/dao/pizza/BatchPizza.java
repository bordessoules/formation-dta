package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.IPizzaRepository;

public class BatchPizza {
	
	@PersistenceContext 
	private EntityManager em;
	
	@Autowired(required = false)
	private IPizzaRepository pizzaRepository ;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(List<Pizza> list) {
		list.forEach(em::persist);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveData(List<Pizza> list) {
		for (Pizza pizza : list) {
			if (pizzaRepository.findByCode(pizza.getCode())!=null)
			{
				throw new RuntimeException();
			}
			else{
				pizzaRepository.save(pizza);

			}
		}
	}
}