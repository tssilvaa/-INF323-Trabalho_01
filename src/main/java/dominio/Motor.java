package dominio;

public class Motor {

	private boolean ligado;
	
	public Motor() {
		
	}

	
	protected void ligar() {
		ligado = true;
	}

	protected void desligar() {
		ligado = false;
	}
	
	protected boolean isLigado() {
		return ligado;
	}
}
