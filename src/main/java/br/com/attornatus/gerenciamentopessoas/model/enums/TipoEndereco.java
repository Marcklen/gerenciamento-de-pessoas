package br.com.attornatus.gerenciamentopessoas.model.enums;

public enum TipoEndereco {

	PRINCIPAL(0, "ENDERECO_PRINCIPAL"), 
	SECUNDARIO(1, "ENDERECO_SECUNDARIO");

	private Integer codigo;
	private String descricao;

	private TipoEndereco (Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoEndereco toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoEndereco x : TipoEndereco.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Tipo de Endereço Inválido");
	}
}