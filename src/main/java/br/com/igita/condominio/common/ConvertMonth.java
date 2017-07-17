package br.com.igita.condominio.common;

import java.util.HashMap;
import java.util.Map;


public class ConvertMonth {
	
	private Map<String, Integer> mapMeses = null;
	
	public final Integer getMes(String mes) throws Exception {
		
		if (this.mapMeses == null) {
			this.loadMeses();
		}
		
		Integer mesOut = mapMeses.get(mes);
		
		if(mesOut == null) {
			throw new Exception("Mes nao encontrado: " + mes);
		}
		
		return mesOut;
	}
	
	private void loadMeses() {
		
		this.mapMeses = new HashMap<String, Integer>();
		
		mapMeses.put("Jan", 1);
		mapMeses.put("Fev", 2);
		mapMeses.put("Mar", 3);
		mapMeses.put("Abr", 4);
		mapMeses.put("Mai", 5);
		mapMeses.put("Jun", 6);
		mapMeses.put("Jul", 7);
		mapMeses.put("Ago", 8);
		mapMeses.put("Set", 9);
		mapMeses.put("Out", 10);
		mapMeses.put("Nov", 11);
		mapMeses.put("Dez", 12);
		
	}
	

}
