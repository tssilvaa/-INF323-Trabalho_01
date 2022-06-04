package dominio;

public class Turbina extends Motor {

	private int nivelPotencia;
	
	public Turbina() {
		nivelPotencia = 0;
	}
	
	protected void ligar() {
		super.ligar();
		
		nivelPotencia = 5;
	}
	
	protected void desligar() {
		super.desligar();
		
		nivelPotencia = 0;
	}
	
	public void aumentarPotencia(int aumento) throws DesligadoException{
		if (!isLigado()) {
			throw new DesligadoException("Desligado");
		}
		else {
			nivelPotencia = aumento > 0 ? Math.min(nivelPotencia + aumento, 100) : nivelPotencia;
		}
	}
	
	public void diminuirPotencia(int diminuicao)  throws DesligadoException{
		if (!isLigado()) {
			throw new DesligadoException("Desligado");
		}
		else {
			nivelPotencia = diminuicao > 0 ? Math.max(nivelPotencia - diminuicao, 0) : nivelPotencia;
		}
	}
	
	public int getNivelPotencia() {
		 return nivelPotencia;
	}
}
