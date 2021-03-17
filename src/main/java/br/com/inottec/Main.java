package br.com.inottec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	// criando uma variavel statica para o contolador da tela pode acessa sem criar
	// objeto
	private static Stage janela;
	private static Scene cenaTelaInicial;
	private static Scene cenaTelaAdicionaGasto;    
	private static Scene cenaTelaPagaDivida;    
	private static Scene cenaTelaRelatorioDosGasto;
	private static Scene cenaTelaLogin;   
	private static Scene cenaTelaCadastro; 
	
	
	private static Scene cenaTelaMeusDados;            
	 
	@Override
	public void start(Stage primaryStage) throws Exception {

		//dicionando primaryStage em janela 
		janela = primaryStage; 
			
		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaLogin = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaLogin = new Scene(fxmlTelaLogin, 395, 186);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaCadastro = FXMLLoader.load(getClass().getResource("/view/TelaCadastroUsuario.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaCadastro = new Scene(fxmlTelaCadastro, 429, 445);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("/view/TelaInicial.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaInicial = new Scene(fxmlTelaInicial, 365, 400);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaAdicionaGasto = FXMLLoader.load(getClass().getResource("/view/TelaAdicionaGasto.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaAdicionaGasto = new Scene(fxmlTelaAdicionaGasto, 440, 360);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaPagaDivida = FXMLLoader.load(getClass().getResource("/view/TelaPagaDivida.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaPagaDivida = new Scene(fxmlTelaPagaDivida, 337, 416);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaRelatorioDosGasto = FXMLLoader.load(getClass().getResource("/view/TelaRelatorioDosGasto.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaRelatorioDosGasto = new Scene(fxmlTelaRelatorioDosGasto, 348, 416);

		// pega o arquivo fxml e converte para gridpane
		Parent fxmlTelaMeusDados = FXMLLoader.load(getClass().getResource("/view/TelaMeusDados.fxml"));
		// criando um senario usando o arquivo fxml
		cenaTelaMeusDados = new Scene(fxmlTelaMeusDados, 320, 340);

		// comando para usuario não pode altera o tamanho da telaadiciona Gasto
		janela.setResizable(false);
		// criando titulo
		janela.setTitle("Gasto do Mes");
		// executando cenaro
		janela.setScene(cenaTelaLogin);
		// executando a tela
		janela.show();    
	}   

	// criando metodo statico para troca tela com parametro do tipo string
	public static void trocaTela(String tela) {

		switch (tela) {
		// se o parametro for telaInicial chama o cenaTelaInicial
		case "telaInicial":
			janela.setScene(cenaTelaInicial);
			break; 
			// se o parametro for telaAdicionaGasto chama o cenaTelaAdicionaGasto
		case "telaAdicionaGasto": 
			janela.setScene(cenaTelaAdicionaGasto);
			break;
			// se o parametro for telaInicial chama o cenaTelaInicial
		case "telaPagaDivida":
			janela.setScene(cenaTelaPagaDivida);
			break;
			// se o parametro for telaPagaDivida chama o cenaTelaPagaDivida
		case "telaRelatorioDosGasto":
			janela.setScene(cenaTelaRelatorioDosGasto);
			break;
			// se o parametro for telaRelatorioDosGasto chama o cenaTelaRelatorioDosGasto
		case "telaMeusDados":
			janela.setScene(cenaTelaMeusDados);
			break;
			// se o parametro for telaMeusDados chama o cenaTelaMeusDados
		case "telaCadastro":  
			janela.setScene(cenaTelaCadastro); 
			break;
			// se o parametro for telaLogin chama o cenaTelalogin
		case "telaLogin":
			janela.setScene(cenaTelaLogin);      
			break;
		}		  
	} 
	public static void main(String[] args) {
		// finalizando a tela
		launch(args);  
	}
}