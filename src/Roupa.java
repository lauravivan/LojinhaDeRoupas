
public class Roupa extends Categoria {
	private String nomeDaPeca;
	private int quantidade;
	private int valorEspecifico;
	private int numeroDaRoupa;

	public String getNomeDaPeca() {
		return this.nomeDaPeca;
	}

	public void setNomeDaPeca(String no) {
		this.nomeDaPeca = no;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int qnd) {
		this.quantidade = qnd;
	}
	
	public int getValorEspecifico() {
		return valorEspecifico;
	}

	public void setValorEspecifico(int valor) {
		this.valorEspecifico = valor;
	}

	public int getNumeroDaRoupa() {
		return numeroDaRoupa;
	}

	public void setNumeroDaRoupa(int numero) {
		if (numero == 1) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Camiseta Hora de Aventura");
			this.setCodigo(5);
		} else if (numero == 2) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Camiseta O Incrível Mundo de Gumball");
			this.setCodigo(5);
		} else if (numero == 3) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Vestido cinza");
			this.setCodigo(8);
		} else if (numero == 4) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Vestido preto");
			this.setCodigo(8);
		} else if (numero == 5) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Jaqueta jeans azul claro");
			this.setCodigo(3);
		} else if (numero == 6) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Cachecol");
			this.setCodigo(1);
		} else if (numero == 7) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Calça jeans azul escuro");
			this.setCodigo(2);
		} else if (numero == 8) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Calça jeans preta");
			this.setCodigo(2);
		} else if (numero == 9) {
			this.numeroDaRoupa = numero;
			this.setNomeDaPeca("Shorts preto");
			this.setCodigo(7);
		} else {
			System.out.println("Código da categoria inválido!");
		}
	}

	@Override
	public String toString() {
		return "Nome da peça: " + this.getNomeDaPeca()
				+ "\nQuantidade: " + this.getQuantidade() + " un X "
				+ (float) this.getValor()
				+ "\n";
	}
}
