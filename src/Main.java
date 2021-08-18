import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Pedido meuPedido = new Pedido();
		int roupasQueForamEscolhidas = 0;
		int valorTotalDaCompra = 0;


		//PRIMEIRA ETAPA - CARRINHO
		String bemVindoCliente = JOptionPane.showInputDialog("Bem-vindo cliente!"
				+ "\nAperte 1 para escolher suas compras"
				+ "\nAperte 2 se voc� quer cancelar essa opera��o");
		int option = Integer.parseInt(bemVindoCliente);

		if (option == 1) {
			int qndEscolhida = 0;
			int opcao = 0;
			while (opcao != 10) {
				for (int i = 0; i < meuPedido.getCarrinho().length; i++) {
					String escolhaDasRoupas = JOptionPane.showInputDialog("1. Camiseta Hora de Aventura (13 reais)"
							+ "\n2. Camiseta O Incr�vel Mundo de Gumball (13 reais)"
							+ "\n3. Vestido cinza (38 reais)"
							+ "\n4. Vestido preto (38 reais)"
							+ "\n5. Jaqueta jeans azul claro (72 reais)"
							+ "\n6. Cachecol (20 reais)"
							+ "\n7. Cal�a jeans azul escuro (55 reais)"
							+ "\n8. Cal�a jeans preta (55 reais)"
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
			System.out.println("Volte sempre!");
		} else {
			System.out.println("Opc�o inv�lida!");
		}

		if (option == 1) {
		//SEGUNDA ETAPA -- DADOS PESSOAIS DO CLIENTE
		String dadosPessoaisCliente = JOptionPane.showInputDialog("Ok! Seu carrinho est� cheio!"
				+ "\nAgora � hora de informar seus dados pessoais"
				+ "\nAperte 1 para come�ar"
				+ "\nAperte 2 se voc� quer cancelar essa opera��o");
		int um = Integer.parseInt(dadosPessoaisCliente);

		if (um == 1) {
			String nome = JOptionPane.showInputDialog("Informe o seu nome completo"
					+ " nos par�metros: (exemplo: Jos� da Silva Oliveira)");
			String endereco = JOptionPane.showInputDialog("Informe o endere�o de entrega "
					+ "junto com o complemento nos par�metros: "
					+ " (exemplo: Rua Tal, XX. Bairro Tal)");
			String cep = JOptionPane.showInputDialog("Informe o cep nos seguintes par�metros: "
					+ "XXXXX-XX");
			String cpf = JOptionPane.showInputDialog("Informe o cpf nos seguintes par�metros: "
					+ " XXX.XXX.XXX-XX");
			
			Cliente cliente = new Cliente(nome, endereco, cpf, cep);
			meuPedido.setCliente(cliente);
		} else if (um == 2) {
			System.out.println("Volte sempre!");
		} else {
			System.out.println("Op��o inv�lida");
		}
		
		if (um == 1) {
		//TERCEIRA ETAPA -- PAGAMENTO
		String pagamento = JOptionPane.showInputDialog("Dados pessoais preenchidos!"
				+ " Agora s� falta pagar."
				+ "\nEscolha uma forma de pagamento: "
				+ "\n1. Cart�o de Cr�dito"
				+ "\n2. Cart�o de D�bito"
				+ "\n\n3. Aperte 3 se voc� quiser cancelar a compra");
		int opcaoCartao = Integer.parseInt(pagamento);

		if(opcaoCartao == 1) {
			String numeroDoCartao = JOptionPane.showInputDialog("Informe o n�mero do cart�o: "
					+ " nos seguintes par�metros: XXXX XXXX XXXX XXXX");

			FormaDePagamento pagamentoCliente = new FormaDePagamento();
			pagamentoCliente.setNumeroCartao(numeroDoCartao);
			
			String parcelas = JOptionPane.showInputDialog("Escolha em quantas parcelas voc� quer fazer: "
					+ "\n1 X " + valorTotalDaCompra
					+ "\n2 X " + valorTotalDaCompra/2 + " sem juros"
					+ "\n3 X " + valorTotalDaCompra/3 + " sem juros"
					+ "\n4 X " + valorTotalDaCompra/4 + " sem juros"
					+ "\n5 X " + valorTotalDaCompra/5 + " sem juros"
					+ "\n6 X " + valorTotalDaCompra/6 + " sem juros"
					+ "\n7 X " + valorTotalDaCompra/7 + " sem juros");
			int qndDeParcelas = Integer.parseInt(parcelas);

			String notaFiscal = JOptionPane.showInputDialog("Se voc� quiser a nota fiscal da sua compra aperte 1"
					+ "\nSe voc� quiser apenas finalizar a compra aperte 2");
			int opcaoNotaFiscal = Integer.parseInt(notaFiscal);

			if (opcaoNotaFiscal == 1) {
				JOptionPane.showMessageDialog(null, "----NOTA FISCAL----"
												+ "\nCliente: "
												+ "\nNome: " + meuPedido.getCliente().getNomeDoCliente()
												+ "\nEndere�o de entrega: " + meuPedido.getCliente().getEnderecoDeEntrega()
												+ "\nCEP: " + meuPedido.getCliente().getCep()
												+ "\nCPF: " + meuPedido.getCliente().getCpf()
												+ "\n"
												+ "\nCompra com cart�o de cr�dito"
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
				System.out.println("Parab�ns! Voc� finalizou a sua compra, agora � s� esperar!");
			} else {
				System.out.println("Op��o inv�lida");
			}

		} else if (opcaoCartao == 2) {
			String numeroDoCartao = JOptionPane.showInputDialog("Informe o n�mero do cart�o: "
					+ " nos seguintes par�metros: XXXX XXXX XXXX XXXX");

			FormaDePagamento pagamentoCliente = new FormaDePagamento();
			pagamentoCliente.setNumeroCartao(numeroDoCartao);
			
			String notaFiscal = JOptionPane.showInputDialog("Se voc� quiser a nota fiscal da sua compra aperte 1"
					+ "\nSe voc� quiser apenas finalizar a compra aperte 2");
			int opcaoNotaFiscal = Integer.parseInt(notaFiscal);

			if (opcaoNotaFiscal == 1) {
				System.out.println("----NOTA FISCAL----");
				System.out.println("Cliente: ");
				System.out.println("Nome: " + meuPedido.getCliente().getNomeDoCliente());
				System.out.println("Endere�o de entrega: " + meuPedido.getCliente().getEnderecoDeEntrega());
				System.out.println("CEP: " + meuPedido.getCliente().getCep());
				System.out.println("CPF: " + meuPedido.getCliente().getCpf()
						+ "\n");
				System.out.println("Compra com cart�o de d�bito"
						+ " terminado em " + pagamentoCliente.getNumeroCartao().subSequence(15,19));
				System.out.println("TOTAL R$ " + valorTotalDaCompra);
				System.out.println();
				System.out.println("---ITENS---");
				for (int i = 0; i < roupasQueForamEscolhidas; i++) {
					System.out.println(meuPedido.getCarrinho()[i].toString());
				}
			} else if (opcaoNotaFiscal == 2) {
				System.out.println("Parab�ns! Voc� finalizou a sua compra, agora � s� esperar!");
			} else {
				System.out.println("Op��o inv�lida");
			}

		} else if (opcaoCartao == 3) {
			System.out.println("Volte sempre!");
		} else {
			System.out.println("Op��o Inv�lida!");
		}
		}
		}
	}
}
