package br.com.settech.locawebfrete;

import java.util.HashMap;
import java.util.Map;

public enum Transporte {

	SEDEX(40096),E_SEDEX(81019),PAC_NORMAL(41025),PAC_TABELAS_COM_PESO_CUBICO(41068);
	
	private int codigo;
	private static Map<Integer,Transporte> nomes;
	
	static{
		nomes = new HashMap<Integer, Transporte>();
		nomes.put(40096,SEDEX);
		nomes.put(81019,E_SEDEX);
		nomes.put(41025, PAC_NORMAL);
		nomes.put(41068, PAC_TABELAS_COM_PESO_CUBICO);
	}
	
	private Transporte(int codigo){
		this.codigo = codigo;
	}
	
	/**
	 * Quando quiser criar o tipo de transporte a partir do número.
	 * @param codigo
	 * @return
	 */
	public static Transporte newTransporte(int codigo){
		return nomes.get(codigo);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.codigo+"";
	}
	
	
}
