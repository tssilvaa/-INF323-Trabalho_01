package dominio;

public class CompartimentoCarga extends Compartimento<Float> {
	
	private static final float capacidateTotal = 1000;
	private static final float qntInicial = 0;
	
	public CompartimentoCarga() {
		super(capacidateTotal, qntInicial);		
	}

	
	public boolean carregarCarga(float valor) {
		if (valor < 0 || (this.getQntAtual() + valor) > this.getCapacidadeTotal()) {
			return false;
		}
		else {
			this.setQntAtual(getQntAtual() + valor);
			
			return true;
		}
	}

	public boolean descarregarCarga(float valor) {
		if (valor < 0 || (this.getQntAtual() - valor) < 0) {
			return false;
		}
		else {
			this.setQntAtual(getQntAtual() - valor);
			
			return true;
		}
	}
}
