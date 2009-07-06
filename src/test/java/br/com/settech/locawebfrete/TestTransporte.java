package br.com.settech.locawebfrete;

import org.junit.Test;

import junit.framework.Assert;

public class TestTransporte {

	@Test
	public void testCriarTransporteAPartirDoCodigo(){
		Assert.assertEquals(Transporte.SEDEX,Transporte.newTransporte(40096));
		Assert.assertEquals(Transporte.E_SEDEX,Transporte.newTransporte(81019));
		Assert.assertEquals(Transporte.PAC_NORMAL,Transporte.newTransporte(41025));
		Assert.assertEquals(Transporte.PAC_TABELAS_COM_PESO_CUBICO,Transporte.newTransporte(41068));
	}
}
