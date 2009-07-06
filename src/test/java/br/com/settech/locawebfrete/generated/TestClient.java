package br.com.settech.locawebfrete.generated;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import junit.framework.Assert;
import br.com.settech.locawebfrete.CalculoFrete;
import br.com.settech.locawebfrete.CorreiosBuilder;
import br.com.settech.locawebfrete.FreteNaoPodeSerCalculadoException;
import br.com.settech.locawebfrete.Servico;
import br.com.settech.locawebfrete.Transporte;

public class TestClient {

	@Test
	public void testCalculaFrete(){
		Servico servico = new Servico();
		CalculoFrete calculoFrete = servico.calculaFrete(new CorreiosBuilder("41940060","49032290",1d,Transporte.SEDEX).createCorreios());	
		Assert.assertEquals(new BigDecimal(16.78).setScale(2,RoundingMode.HALF_EVEN),calculoFrete.getValor().setScale(2,RoundingMode.HALF_EVEN));
	}
	
	
	@Test(expected=FreteNaoPodeSerCalculadoException.class)
	public void testCalculaFreteComCepDestinoInvalido(){
		Servico servico = new Servico();
		CalculoFrete calculoFrete = servico.calculaFrete(new CorreiosBuilder("41940060","43748964787",1d,Transporte.SEDEX).createCorreios());		
	}
}
