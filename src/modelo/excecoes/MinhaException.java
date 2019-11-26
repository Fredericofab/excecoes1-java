package modelo.excecoes;

public class MinhaException extends RuntimeException{
	// por enquanto aceitar a linha abaixo que foi colocada pelo eclipse
	private static final long serialVersionUID = 1L;

	public MinhaException(String mensagem) {
		super(mensagem);
	}
	
}
