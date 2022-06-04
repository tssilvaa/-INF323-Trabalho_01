package dominio;

import java.math.BigDecimal;

public interface Tanque {
	
	boolean abastecer(double valor);
	
	boolean consumir(double valor);
	
	BigDecimal getCapacidadeTotal();
	
	BigDecimal getQntAtual();
}
