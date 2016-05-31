package fr.pizzeria.admin.rest;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {
	private Set<String> tokens = new HashSet<>();
	
	public String generateNEwToken(){
		String t =UUID.randomUUID().toString();
		tokens.add(t);
		return t;
	}
	public boolean isTokenValid(String token) {
		// TODO Auto-generated method stub
		return tokens.contains(token);
	}
	
}
