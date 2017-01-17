package singletons;

import java.util.ArrayList;
import java.util.List;

import entidades.Ambiente;

public class SingletonAmbiente {

	private static SingletonAmbiente instance = null;
	
	private List<Ambiente> ambientes = new ArrayList<Ambiente>();
	
	public static SingletonAmbiente getInstance(){
		
		if(instance == null){
			instance = new SingletonAmbiente();
		}
		return instance;
	}
	
	public void insereAmbiente(Ambiente a){
		ambientes.add(a);
	}
	
	public List<Ambiente> getAmbientes(){
		return this.ambientes;
	}
}
