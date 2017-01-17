package transacoes.e.layers;

import java.util.List;

import entidades.Ambiente;
import singletons.SingletonAmbiente;

public class RecuperarListaAmbienteRT {
	
	public List<Ambiente> retornaListaAmbiente(){
		List<Ambiente> lista = SingletonAmbiente.getInstance().getAmbientes();
		return lista;
	}
	
	public void inserirAmbienteLita(Ambiente ambiente){
		SingletonAmbiente.getInstance().insereAmbiente(ambiente);
	}

}
