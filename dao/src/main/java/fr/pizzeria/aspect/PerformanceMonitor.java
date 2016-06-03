package fr.pizzeria.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;
import fr.pizzeria.repos.IPerformanceRepository;

@Aspect
@Component
public class PerformanceMonitor {
	@Autowired IPerformanceRepository performanceRepository;
	
	@Around("execution (* fr.pizzeria.dao.pizza.IPizzaDao.*(..))")
	public Object perfomanceMonitor(ProceedingJoinPoint pjp) throws Throwable {

		long debut = System.nanoTime();		
			Object valeurRetournee = pjp.proceed();
		long fin = System.nanoTime()-debut;
		Performance p =new Performance( pjp.getSignature().toShortString(), new Date(), fin);
		performanceRepository.save(p);
		
		return valeurRetournee;
	}
	
}