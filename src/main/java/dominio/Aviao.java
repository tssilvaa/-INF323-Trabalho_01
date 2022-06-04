package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Aviao {

	private final TanqueCombustivel tanqueCombustivel;
	private final CompartimentoCarga compartimentoCarga;
	private final ArrayList<Turbina> lsTurbinas;
	
	public Aviao() {
		tanqueCombustivel = new TanqueCombustivel();
		compartimentoCarga = new CompartimentoCarga();
		
		lsTurbinas = new ArrayList<Turbina>();
		lsTurbinas.add(new Turbina());
		lsTurbinas.add(new Turbina());
	}
	
	
	public void ligarTurbinas() {
		if (tanqueCombustivel.getQntAtual().compareTo(new BigDecimal(0)) == 1) {
			lsTurbinas.forEach(x -> x.ligar());	
		}
	}

	public void desligarTurbinas() {
		lsTurbinas.forEach(x -> x.desligar());
	}
	
	public boolean isTurbinasLigadas() {
		for (Turbina turbina : lsTurbinas) {
			if(!turbina.isLigado()) {
				return false;
			}
		}
		
		return true;
	}

	public int nivelPotenciaTurbinas() {
		int somaDasPotencias = 0;
		
		for (Turbina turbina : lsTurbinas) {
				somaDasPotencias += turbina.getNivelPotencia();
			}

		return somaDasPotencias / lsTurbinas.size();
	}

	public void aumentarPotenciaTurbinas() {
		lsTurbinas.forEach(x -> {
			try {
				x.aumentarPotencia(5);
			} catch (DesligadoException e) {
				
			}
		});
	}

	public void diminuirPotenciaTurbinas() {
		lsTurbinas.forEach(x -> {
			try {
				x.diminuirPotencia(5);
			} catch (DesligadoException e) {
				
			}
		});
	}
	
	public void abastecer(double valor) {
		tanqueCombustivel.abastecer(valor);
	}

	public void consumir(double value) {
		tanqueCombustivel.consumir(value);
	}

	public double getCapacidadeTotalCombustivel() {
		return tanqueCombustivel.getCapacidadeTotal().doubleValue();
	}

	public double getQntdAtualCombustivel() {
		return tanqueCombustivel.getQntAtual().doubleValue();
	}

	public void carregarCarga(int value) {
		compartimentoCarga.carregarCarga(value);
	}
	
	public void descarregarCarga(int value) {
		compartimentoCarga.descarregarCarga(value);
	}
	
	public float getCapacidadeTotalCarga() {
		return compartimentoCarga.getCapacidadeTotal();
	}
	
	public float getQntdAtualCarga() {
		return compartimentoCarga.getQntAtual();
	}
}
