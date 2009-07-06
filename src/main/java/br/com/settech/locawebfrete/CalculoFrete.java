package br.com.settech.locawebfrete;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * O retorno do serviço é um xml... então criei essa classe para ser gerada a partir
 * do retorno.
 * @author asouza
 *
 */
public class CalculoFrete {

	private String retorno;
	private String descricao;
	private String codigo;
	private String valor;	
	
	public Transporte getTransporte(){		
		return Transporte.newTransporte(Integer.valueOf(codigo));
	}

	/**
	 * Retorna o valor do frete arrendodado para 2 casas decimais
	 * @return
	 */
	public BigDecimal getValor(){		
		return new BigDecimal(valor.replace(",",".")).setScale(2,RoundingMode.HALF_EVEN);
	}
	
	public String getDescricao(){
		return descricao;
	}

	boolean foiCalculadoComSucesso() {
		// TODO Auto-generated method stub
		return "OK".equals(retorno);
	}
	
	
}
