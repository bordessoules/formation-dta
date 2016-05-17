package fr.pizzeria.ihm.menu.option;


public class ConnectionOptionMenu extends OptionMenu {

	
	private static final String LIBELLE_MENU = "Se connecter";

	public ConnectionOptionMenu( ) {
		super(LIBELLE_MENU, null, null);
		
	}
	
	@Override
	public boolean execute() {

		return true;
	}

}