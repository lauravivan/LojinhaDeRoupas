
public class Pedido {
	Carrinho[] carrinho = new Carrinho[9];
	FormaDePagamento pagamento;
	Cliente cliente;
	
	public Carrinho[] getCarrinho() {
		return carrinho;
	}
	
	public void setCarrinho(Carrinho[] carrinho) {
		this.carrinho = carrinho;
	}
	
	public FormaDePagamento getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(FormaDePagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
