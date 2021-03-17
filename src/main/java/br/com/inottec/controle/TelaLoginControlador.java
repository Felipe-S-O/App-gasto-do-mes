package br.com.inottec.controle;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import br.com.inottec.Main;

public class TelaLoginControlador {
	//criando um logger
	Logger logger = Logger.getLogger(TelaLoginControlador.class);

	@FXML
	private TextField campoEmail;

	@FXML
	private PasswordField campoSenha;
	
	@FXML
    public void botaoEntrar() {
		//pegando texto digitado e imprimindo
		logger.info(campoEmail.getText());
		//pegando texto digitado e imprimindo
		logger.info(campoSenha.getText());		
                  
    }

	@FXML
    public void telaCadastro() {
        //chamando tela cadastro usuario
		Main.trocaTela("telaCadastro");
		
    }
}
