package dominio;

import java.math.BigDecimal;

public class TanqueCombustivel extends Compartimento<BigDecimal> implements Tanque{

	public TanqueCombustivel() {
		super(new BigDecimal(1000), new BigDecimal(0));
	}

	public boolean abastecer(double valor) {
		if (valor > 0) {
			double qntNova = getQntAtual().doubleValue() + valor;
			
			if (qntNova > getCapacidadeTotal().doubleValue()) {
				setQntAtual(new BigDecimal(getCapacidadeTotal().doubleValue() ));
				return false ;
			}
			else {
				setQntAtual(new BigDecimal(qntNova));
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean consumir(double valor) {
		double qntAnterior = getQntAtual().doubleValue();
		
		if (valor > 0 && qntAnterior != 0) {
			valor = valor > qntAnterior ? qntAnterior : valor;
			
			setQntAtual(new BigDecimal(qntAnterior - valor));

			return true;
		}
		else {
			return false;
		}
	}
}
