package dominio;

public class Compartimento<T extends Number> {
	
	private final T capacidadeTotal;
	private T qntAtual;
	
	public Compartimento(T capacidadeTotal, T qntAtual){
		this.capacidadeTotal = capacidadeTotal;
		this.qntAtual = qntAtual;
	}
	
	
	public T getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public T getQntAtual() {
		return qntAtual;
	}
	
	protected void setQntAtual(T qntAtual) {
		this.qntAtual = qntAtual;
	}
}
