package fr.pizzeria.aspect;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.SpringJpaDataConfig;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Performance;
import fr.pizzeria.repos.IPerformanceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={PerformanceMonitorConfig.class,SpringJpaDataConfig.class})

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PerformanceMonitorTest {
	@Autowired 
	@Qualifier	("pizzaDaoJpaDataSpring") IPizzaDao pizzaDao;
    @Autowired IPerformanceRepository performanceRepository;

    @Test
    public void testfindAllPizzas() throws DaoException {
        pizzaDao.findAllPizzas();
        List<Performance> performances = performanceRepository.findAll();
        performances.forEach(System.out::println);

        assertEquals(1, performances.size());
        assertEquals("IPizzaDao.findAllPizzas()", performances.get(0).getService());

    }


}
