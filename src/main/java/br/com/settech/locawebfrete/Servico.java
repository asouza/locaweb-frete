package br.com.settech.locawebfrete;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.settech.locawebfrete.generated.Correios;
import br.com.settech.locawebfrete.generated.Frete;
import br.com.settech.locawebfrete.generated.FreteSoap;

public class Servico {
		
	
	public CalculoFrete calculaFrete(Correios correios){
		Frete frete = new Frete();
		FreteSoap freteSoap = frete.getFreteSoap();
		String resultado = freteSoap.correiosXml(correios.getCepOrigem(),correios.getCepDestino(),correios.getPeso(),correios.getVolume(),correios.getCodigo());
		XStream stream = new XStream(new DomDriver());
		stream.alias("CalculoFrete",CalculoFrete.class);		
		CalculoFrete calculoFrete = (CalculoFrete)stream.fromXML(resultado);
		if(calculoFrete.foiCalculadoComSucesso()){
			return calculoFrete;
		}
		throw new FreteNaoPodeSerCalculadoException(calculoFrete.getDescricao());
		
	}
	
}
