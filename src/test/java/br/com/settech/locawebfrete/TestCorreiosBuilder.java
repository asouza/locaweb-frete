package br.com.settech.locawebfrete;

import junit.framework.Assert;

import org.junit.Test;

import br.com.settech.locawebfrete.generated.Correios;

public class TestCorreiosBuilder {

	@Test(expected=IllegalStateException.class)
	public void testFreteComTransporteQuePrecisaDeVolume(){
		CorreiosBuilder correiosBuilder = new CorreiosBuilder("543553","432423",1d,Transporte.PAC_NORMAL);
		correiosBuilder.createCorreios();
	}
	
	@Test
	public void testBuildCorreios(){
		CorreiosBuilder correiosBuilder = new CorreiosBuilder("543553","432423",0.5d,4.5d,Transporte.PAC_NORMAL);
		Correios correios = correiosBuilder.createCorreios();
		Assert.assertEquals("543553",correios.getCepOrigem());
		Assert.assertEquals("432423",correios.getCepDestino());
		Assert.assertEquals("0,50",correios.getPeso());
		Assert.assertEquals("4,50",correios.getVolume());
		Assert.assertEquals("41025",correios.getCodigo());
		
	}
	
	@Test
	public void testBuildCorreiosComPesosEVolumesExatos(){
		CorreiosBuilder correiosBuilder = new CorreiosBuilder("543553","432423",1d,4d,Transporte.PAC_NORMAL);
		Correios correios = correiosBuilder.createCorreios();
		Assert.assertEquals("543553",correios.getCepOrigem());
		Assert.assertEquals("432423",correios.getCepDestino());
		Assert.assertEquals("1,00",correios.getPeso());
		Assert.assertEquals("4,00",correios.getVolume());
		Assert.assertEquals("41025",correios.getCodigo());
		
	}	
}
