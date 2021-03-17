package br.com.inottec.controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.inottec.Main;
import br.com.inottec.infra.DAO;
import br.com.inottec.modelo.EntidadeFormaDePagamento;
import br.com.inottec.modelo.EntidadeUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TelaCadastraUsuarioControlador {

	// criando um logger
	private Logger logger = Logger.getLogger(TelaCadastraUsuarioControlador.class);

	// criando uma variavel do tipo EntidadeFormaDePagamento
	private EntidadeFormaDePagamento itemFormaDePagamento;

	// crinado uma mensagem de erro do tipo alerta
	private Alert alertErro = new Alert(Alert.AlertType.ERROR);

	// crinado uma mensagem de confirmação do tipo alerta
	private Alert alertInf = new Alert(Alert.AlertType.CONFIRMATION);

	// criando uma lista de cartões do tipo EntidadeFormaDePagamento
	private List<EntidadeFormaDePagamento> listaDeCartao = new ArrayList<>();
	
	//crinado um DAO do tipo EntidadeFormaDePagamento
	DAO<EntidadeFormaDePagamento> daoFormaDePagamento = new DAO<>();
	//crinado um DAO do tipo EntidadeUsuario
	DAO<EntidadeUsuario> daoUsuario = new DAO<>();

	// id dos componete da tela cadastro
	@FXML
	private TextField campoNome;
	// id dos componete da tela cadastro
	@FXML
	private TextField campoSenha;
	// id dos componete da tela cadastro
	@FXML
	private TextField campoSalario;
	// id dos componete da tela cadastro
	@FXML
	private TextField campoConfimarSenha;
	// id dos componete da tela cadastro
	@FXML
	private TextField campoCartao;
	// id dos componete da tela cadastro
	@FXML
	private DatePicker campoVencimento;
	// id dos componete da tela cadastro
	@FXML
	private ListView<String> campoListaDeCartao;

	// *********** arrey para adiciona cartões na litview só para exibir na
	// tela******=>

	// criando uma lista de cartões do tipo string
	List<String> cartoes = new ArrayList<>();
	// criando um ObservableList do tipo string
	ObservableList<String> obsCartoes;

	// <=*********termina aqui o arrey para adiciona cartões na litview só para
	// exibir na tela**********

	// Evento que adicona cartão
	@FXML
	void botaoAdicionarCartao(ActionEvent event) {

		// crinado uma entidade cartão do tipo EntidadeFormaDePagamento na variavel
		// itemFormaDePagamento
		itemFormaDePagamento = new EntidadeFormaDePagamento(campoCartao.getText(), campoVencimento.getValue());

		// adiconando variavel itemFormaDePagamento na listaDeCartao
		listaDeCartao.add(itemFormaDePagamento);

		// *************os codigos abaixo é para adiciona o cartão na listview só para
		// exibir na tela************

		// pegando a data do campo vencimento
		LocalDate vencimento = campoVencimento.getValue();

		/*
		 * pegando o texto do campo cartão pegando o string " | " pegando a data e
		 * passando para formato String e pasando tudo para string cartão
		 */
		String cartao = "cartão: " + campoCartao.getText() + "  |  vencimeto: " + vencimento.toString();

		// adicionando string cartao na lista de cartões
		cartoes.add(cartao);
        logger.info("Cartão adicionado da litview com suceço ");
        
		// adicionando lista de cartões no obsCartoes do tipo ObservableList
		obsCartoes = FXCollections.observableArrayList(cartoes);
		// adicionando obsCartoes do tipo ObservableList no campo lista de cartões
		campoListaDeCartao.setItems(obsCartoes);

		// **********os codigos para adiciona o cartão na listview só para exibir na
		// tela termina aqui**********

	}

	// Evento que salvar usuario e forma de pagamento
	@FXML
	void salvarUsuario(ActionEvent event) {

		// verificando se os campos obrigatorio nome,salario,senha e confirmar senha
		// estão nulo se for executa
		if (!campoNome.getText().equals("") && !campoSalario.getText().equals("") && !campoSenha.getText().equals("")
				&& !campoConfimarSenha.getText().equals("")) {

			// verificando se o campo salario é número se for executa
			if (campoSalario.getText().length() != 0) {

				// tratando o erro na conveção de salario do tipo String para salario do tipo
				// Double
				try {
					// conveção de salario do tipo String para salario do tipo Double
					Double salario = Double.parseDouble(campoSalario.getText());

					// verificando se o campo senha confirmar com o campo confirmar senha
					if (campoSenha.getText().equalsIgnoreCase(campoConfimarSenha.getText())) {

						// criando um usuario
						EntidadeUsuario usuario = new EntidadeUsuario(campoNome.getText(), salario,
								campoSenha.getText());
						// adicionando usuario no banco de dados
						daoUsuario.incluirEntidade(usuario);
//						logger.info("Usuario adicionado no banco com suceço");
						
						// criando um for para pecore listaDeCartao para adiciona um cartão por vez
						for (EntidadeFormaDePagamento cartao : listaDeCartao) {

							// adicionando forma de pagamento no banco de ado
							daoFormaDePagamento.incluirEntidade(cartao);
//							logger.info("Cartão adicionado no banco com suceço");
						}
						// criando um alerta de confirmação
						// criando titulo do alerta
						alertInf.setTitle("Mensagem");
						// criando cabeçario do alerta
						alertInf.setHeaderText("Usuario cadastrado com sucesso");
						// chamando a tela login
						Main.trocaTela("telaLogin");
						// chamando o alerta
						alertInf.show();

						// executa se a senha não confirmar chama o alerta
					} else {
						// criando titulo do alerta
						alertErro.setTitle("Erro");
						// criando cabeçario do alerta
						alertErro.setHeaderText("A senha não confere");
						// chamando o alerta
						alertErro.show();
					}
					// executa se o campo salario for diferente de número
				} catch (NumberFormatException ex) {
					// criando titulo do alerta
					alertErro.setTitle("Erro");
					// criando cabeçario do alerta
					alertErro.setHeaderText("Esse Campo 'salario' só aceita números ");
					// chamando o alerta
					alertErro.show();
				}
			}
			// executa se os campos obrigatorio nome,salario,senha e confirmar senha for
			// nulo chama
			// o alerta
		} else {
			// criando titulo do alerta
			alertErro.setTitle("Erro");
			// criando cabeçario do alerta
			alertErro.setHeaderText("Preencha os campos obrigatório");
			// chamando o alerta
			alertErro.show();
		}
	}

	// Evento que rrmover cartão
	@FXML
	void botaoRemoverCartao(ActionEvent event) {
		// remove item da lista selecionado
		campoListaDeCartao.getItems().removeAll(campoListaDeCartao.getSelectionModel().getSelectedItems());
		logger.info("Cartão removido da litview com suceço");
	}

	// Evento que cancelar o cadastro do usuario e volta para tela de login
	@FXML
	void butaoCancelar(ActionEvent event) {
		// chamando a tela login
		Main.trocaTela("telaLogin");
	}

}
