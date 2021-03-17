package br.com.inottec.controle;



import br.com.inottec.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaInicialControlador {

	@FXML
	private Button butAdicionaGasto;

	@FXML
	private Button butPgaDivida;

	@FXML

	private Button butRelatorioDosGastos;

	@FXML
	private Button butMeusDados;

	// chamando a tela adicionar divida
	@FXML
	public void adicionaGasto() {
		// chamando metodo que troca tela quando preciona botão adiciona Gasto
		Main.trocaTela("telaAdicionaGasto");
		
	}

	// hamando a tela aga divida
	@FXML
	public void pagaDivida() {
		// chamando metodo que troca tela quando preciona botão paga Divida
		Main.trocaTela("telaPagaDivida");
	}

	// chamando a tela relatorio dos gastos
	@FXML
	public void relatorioDosGasto() {
		// chamando metodo que troca tela quando preciona botão paga Divida
		Main.trocaTela("telaRelatorioDosGasto");
	}

	// chamando a tela meus dados
	@FXML
	public void meusDados() {
		// chamando metodo que troca tela quando preciona botão paga Divida
		Main.trocaTela("telaMeusDados");
	}

	// saindo do sistema
	@FXML
	void sairDoSistema() {
		Main.trocaTela("sairDoSistema");
	}

}
