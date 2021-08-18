
public class Categoria {
	private String nomeDaCategoria;
	private int codigo;
	private String estacao;
	private int valor;

	public String getNomeDaCategoria() {
		return this.nomeDaCategoria;
	}
	
	private void setNomeDaCategoria(String nome) {
		this.nomeDaCategoria = nome;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) {	
		if (codigo == 1) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Cachecol");
			this.setValor(20);
			this.setEstacao("inverno/outono");
		} else if (codigo == 2) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Calça");
			this.setValor(55);
			this.setEstacao("inverno/outono");
		} else if (codigo == 3) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Jaqueta");
			this.setValor(72);
			this.setEstacao("inverno/outono");
		} else if (codigo == 4) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Blusa");
			this.setValor(35);
			this.setEstacao("inverno/outono");
		} else if (codigo == 5) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Camiseta");
			this.setValor(13);
			this.setEstacao("primavera/verão");
		} else if (codigo == 6) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Jardineira");
			this.setValor(64);
			this.setEstacao("primavera/verão");
		} else if (codigo == 7) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Shorts");
			this.setValor(37);
			this.setEstacao("primavera/verão");
		} else if (codigo == 8) {
			this.codigo = codigo;
			this.setNomeDaCategoria("Vestido");
			this.setValor(38);
			this.setEstacao("primavera/verão");
		} else {
			System.out.println("Código da categoria inválido!");
		}
	}
	
	public String getEstacao() {
		return this.estacao;
	}
	
	private void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Nome da categoria: " + this.getNomeDaCategoria()
		+ "\nCódigo: " + this.getCodigo()
		+ "\nEstação: " + this.getEstacao()
		+ "\nValor: R$ " + this.getValor()
		+ "\n";
	}

}

