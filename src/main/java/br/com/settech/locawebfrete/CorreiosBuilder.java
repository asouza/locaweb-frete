package br.com.settech.locawebfrete;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import br.com.settech.locawebfrete.generated.Correios;

public class CorreiosBuilder {

	private String cepOrigem;
	private String cepDestino;
	private Double peso;
	private Double volume;
	private Transporte transporte;

	public CorreiosBuilder(String cepOrigem, String cepDestino, Double peso,
			Double volume, Transporte transporte) {
		super();
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso;
		this.volume = volume;
		this.transporte = transporte;
	}

	public CorreiosBuilder(String cepOrigem, String cepDestino, Double peso,
			Transporte transporte) {
		super();
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.peso = peso;
		this.transporte = transporte;
	}

	public Correios createCorreios(){
		
		Locale locale = new Locale("pt_BR");
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(locale);
		formatSymbols.setGroupingSeparator('.');
		formatSymbols.setDecimalSeparator(',');
		DecimalFormat decimalFormat = new DecimalFormat("##,###,##0.00",formatSymbols);
		String volumeFormatado = "";
		if(transporte.equals(Transporte.PAC_NORMAL) || transporte.equals(Transporte.PAC_TABELAS_COM_PESO_CUBICO)){
			if(volume==null || volume.equals(0d)){
				throw new IllegalStateException("Para PAC Normal ou PAC Tabelas com pesos publicos o volume é obrigatório");
			}						
			volumeFormatado = decimalFormat.format(volume);
		}
		   Correios correios = new Correios();
		   correios.setCepDestino(cepDestino);
		   correios.setCepOrigem(cepOrigem);
		   correios.setCodigo(transporte.toString());
		   correios.setPeso(decimalFormat.format(peso));
		   correios.setVolume(volumeFormatado);
		   return correios;
	}
	
	
		
	
}
