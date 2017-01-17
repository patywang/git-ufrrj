package transacoes.e.layers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RecuperarMapAmbiente {

	public Map<Integer, Integer> retornaMapAmbiente(String[] mobilias, String[] quant){
		
		Map<Integer, Integer> mapAmbiente = new HashMap<Integer, Integer>();
		for(int i = 0; i < quant.length; i++){
			
			if(!mapAmbiente.containsKey(Integer.parseInt(mobilias[i]))){
				mapAmbiente.put(Integer.parseInt(mobilias[i]), Integer.parseInt(quant[i]));
			}else{
				for(Iterator it = mapAmbiente.entrySet().iterator(); it.hasNext();){
					Map.Entry entry = (Map.Entry) it.next();
					if(Integer.parseInt(mobilias[i]) == (Integer)entry.getKey()){
						entry.setValue((Integer)entry.getValue() + Integer.parseInt(quant[i]));
					}
					
				}
			}
			
			
		}
		return mapAmbiente;
	}
}
