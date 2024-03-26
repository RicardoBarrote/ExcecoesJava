package model.exceptions;

public class DomainExceptions extends Exception {// Classe serializable que necessita um número de versão.
	private static final long serialVersionUID = 1L; // Número de versão padrão.

	public DomainExceptions (String msg) {
			super(msg);
		}

	// O que é uma classe Serializable ?
	//
	// Classes que são serializable os objetos dessa classe podem ser convertidos
	// para bytes e trafegar em redes, artigos e etc...
}
