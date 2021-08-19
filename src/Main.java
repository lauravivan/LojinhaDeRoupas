import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Pedido meuPedido = new Pedido();
		int roupasQueForamEscolhidas = 0;
		int valorTotalDaCompra = 0;


		//PRIMEIRA ETAPA - CARRINHO
		String bemVindoCliente = JOptionPane.showInputDialog("Bem-vindo cliente!"
				+ "\nInforme 1 para escolher suas compras"
				+ "\nInforme 2 se você quer cancelar essa operação");
		int option = Integer.parseInt(bemVindoCliente);

		if (option == 1) {
			int qndEscolhida = 0;
			int opcao = 0;
			while (opcao != 10) {
				for (int i = 0; i < meuPedido.getCarrinho().length; i++) {
					String escolhaDasRoupas = JOptionPane.showInputDialog("1. Camiseta Hora de Aventura (13 reais)"
							+ "\n2. Camiseta O Incrível Mundo de Gumball (13 reais)"
							+ "\n3. Vestido cinza (38 reais)"
							+ "\n4. Vestido preto (38 reais)"
							+ "\n5. Jaqueta jeans azul claro (72 reais)"
							+ "\n6. Cachecol (20 reais)"
							+ "\n7. Calça jeans azul escuro (55 reais)"
							+ "\n8. Calça jeans preta (55 reais)"
							+ "\n9. Shorts preto (37 reais)"
							+ "\n10. Finalizar");
					opcao = Integer.parseInt(escolhaDasRoupas);

					if (opcao == 10) {
						break;
					}

					roupasQueForamEscolhidas++;

					String InformarQuantidade = JOptionPane.showInputDialog("Informe a quantidade");
					int qnd = Integer.parseInt(InformarQuantidade);

					if (qnd >= 1 || qnd <= 20) {
						qndEscolhida = qnd;
					}

					meuPedido.getCarrinho()[i] = new Carrinho(opcao);
					meuPedido.getCarrinho()[i].setQuantidade(qndEscolhida);
					meuPedido.getCarrinho()[i].setValorEspecifico(meuPedido.getCarrinho()[i].getValor() * qndEscolhida);
					valorTotalDaCompra += meuPedido.getCarrinho()[i].getValorEspecifico();
				}
			}
		} else if (option == 2) {
			JOptionPane.showMessageDialog(null, "Volte sempre!");
		} else {
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
		}

		if (option == 1) {
		//SEGUNDA ETAPA -- DADOS PESSOAIS DO CLIENTE
		String dadosPessoaisCliente = JOptionPane.showInputDialog("Ok! Seu carrinho está cheio!"
				+ "\nAgora é hora de informar seus dados pessoais"
				+ "\nAperte 1 para começar"
				+ "\nAperte 2 se você quer cancelar essa operação");
		int um = Integer.parseInt(dadosPessoaisCliente);

		if (um == 1) {
			String nome = JOptionPane.showInputDialog("Informe o seu nome completo"
					+ " nos parâmetros: (exemplo: José da Silva Oliveira)");
			String endereco = JOptionPane.showInputDialog("Informe o endereço de entrega "
					+ "junto com o complemento nos parâmetros: "
					+ " (exemplo: Rua Tal, XX. Bairro Tal)");
			String cep = JOptionPane.showInputDialog("Informe o cep nos seguintes parâmetros: "
					+ "XXXXX-XX");
			String cpf = JOptionPane.showInputDialog("Informe o cpf nos seguintes parâmetros: "
					+ " XXX.XXX.XXX-XX");
			
			Cliente cliente = new Cliente(nome, endereco, cpf, cep);
			meuPedido.setCliente(cliente);
		} else if (um == 2) {
			JOptionPane.showMessageDialog(null, "Volte sempre!");
		} else {
			JOptionPane.showMessageDialog(null, "Opção inválida");
		}
		
		if (um == 1) {
		//TERCEIRA ETAPA -- PAGAMENTO
		String pagamento = JOptionPane.showInputDialog("Dados pessoais preenchidos!"
				+ " Agora só falta pagar."
				+ "\nEscolha uma forma de pagamento: "
				+ "\n1. Cartão de Crédito"
				+ "\n2. Cartão de Débito"
				+ "\n\n3. Aperte 3 se você quiser cancelar a compra");
		int opcaoCartao = Integer.parseInt(pagamento);

		if(opcaoCartao == 1) {
			String numeroDoCartao = JOptionPane.showInputDialog("Informe o número do cartão: "
					+ " nos seguintes parâmetros: XXXX XXXX XXXX XXXX");

			FormaDePagamento pagamentoCliente = new FormaDePagamento();
			pagamentoCliente.setNumeroCartao(numeroDoCartao);
			
			String parcelas = JOptionPane.showInputDialog("Escolha em quantas parcelas você quer fazer: "
					+ "\n1 X " + valorTotalDaCompra
					+ "\n2 X " + valorTotalDaCompra/2 + " sem juros"
					+ "\n3 X " + valorTotalDaCompra/3 + " sem juros"
					+ "\n4 X " + valorTotalDaCompra/4 + " sem juros"
					+ "\n5 X " + valorTotalDaCompra/5 + " sem juros"
					+ "\n6 X " + valorTotalDaCompra/6 + " sem juros"
					+ "\n7 X " + valorTotalDaCompra/7 + " sem juros");
			int qndDeParcelas = Integer.parseInt(parcelas);

			String notaFiscal = JOptionPane.showInputDialog("Se você quiser a nota fiscal da sua compra aperte 1"
					+ "\nSe você quiser apenas finalizar a compra aperte 2");
			int opcaoNotaFiscal = Integer.parseInt(notaFiscal);

			if (opcaoNotaFiscal == 1) {
				JOptionPane.showMessageDialog(null, "----NOTA FISCAL----"
												+ "\nCliente: "
												+ "\nNome: " + meuPedido.getCliente().getNomeDoCliente()
												+ "\nEndereço de entrega: " + meuPedido.getCliente().getEnderecoDeEntrega()
												+ "\nCEP: " + meuPedido.getCliente().getCep()
												+ "\nCPF: " + meuPedido.getCliente().getCpf()
												+ "\n"
												+ "\nCompra com cartão de crédito"
												+ " terminado em " + pagamentoCliente.getNumeroCartao().subSequence(15, 19)
												+ "\nParcelado em " 
												+ qndDeParcelas + " vezes de "
												+ (float)(valorTotalDaCompra/qndDeParcelas)
												+ " reais"
												+ "\nTOTAL R$ " + valorTotalDaCompra);
				for (int i = 0; i < roupasQueForamEscolhidas; i++) {
					JOptionPane.showMessageDialog(null, "ITEM" + "\n" + meuPedido.getCarrinho()[i].toString()); 
				}
												
			} else if (opcaoNotaFiscal == 2) {
				JOptionPane.showMessageDialog(null, "Parabéns! Você finalizou a sua compra, agora é só esperar!");
			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		} else if (opcaoCartao == 2) {
			String numeroDoCartao = JOptionPane.showInputDialog("Informe o número do cartão: "
					+ " nos seguintes parâmetros: XXXX XXXX XXXX XXXX");

			FormaDePagamento pagamentoCliente = new FormaDePagamento();
			pagamentoCliente.setNumeroCartao(numeroDoCartao);
			
			String notaFiscal = JOptionPane.showInputDialog("Se você quiser a nota fiscal da sua compra aperte 1"
					+ "\nSe você quiser apenas finalizar a compra aperte 2");
			int opcaoNotaFiscal = Integer.parseInt(notaFiscal);

			if (opcaoNotaFiscal == 1) {
				JOptionPane.showMessageDialog(null, "----NOTA FISCAL----"
									+ "\nCliente: "
									+ "\nNome: " + meuPedido.getCliente().getNomeDoCliente()
									+ "\nEndereço de entrega: " + meuPedido.getCliente().getEnderecoDeEntrega()
									+ "\nCEP: " + meuPedido.getCliente().getCep()
									+ "\nCPF: " + meuPedido.getCliente().getCpf()
									+ "\n"
									+ "\nCompra com cartão de débito"
									+ " terminado em " + pagamentoCliente.getNumeroCartao().subSequence(15,19)
									+ "\nTOTAL R$ " + valorTotalDaCompra);
				for (int i = 0; i < roupasQueForamEscolhidas; i++) {
					JOptionPane.showMessageDialog(null, "ITEM \n" + meuPedido.getCarrinho()[i].toString());
				}
			} else if (opcaoNotaFiscal == 2) {
				JOptionPane.showMessageDialog(null, "Parabéns! Você finalizou a sua compra, agora é só esperar!");
			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		} else if (opcaoCartao == 3) {
			JOptionPane.showMessageDialog(null, "Volte sempre!");
		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
		}
		}
		}
	}
}

