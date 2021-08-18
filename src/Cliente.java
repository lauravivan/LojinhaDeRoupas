
public class Cliente {
	private String nomeDoCliente;
	private String enderecoDeEntrega;
	private String cpf;
	private String cep;

	public Cliente(String nome, String end, String cpf, String cep) {
		setNomeDoCliente(nome);
		setEnderecoDeEntrega(end);
		setCpf(cpf);
		setCep(cep);
	}
	
	public String getNomeDoCliente() {
		return this.nomeDoCliente;
	}
	
	public void setNomeDoCliente(String nome) {
		this.nomeDoCliente = nome;
	}
	
	public String getEnderecoDeEntrega() {
		return this.enderecoDeEntrega;
	}
	
	public void setEnderecoDeEntrega(String endereco) {
		this.enderecoDeEntrega = endereco;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

}
