package br.com.inottec.controle;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.inottec.Main;
import br.com.inottec.modelo.OpcoesDePagamento;
import br.com.inottec.modelo.OpcoesDeParcelas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/*classe de controle da tela adiciona gasto
 * 
 *faz a implementação da  classe Initializable para pode executa o metodo 
 *@Override
	public void initialize(URL location, ResourceBundle resources) {
		obiterTipoDePagamento();
	}
 * esse metodo é tipo o meto main que executa o combobox
 */

public class TelaAdicionaGastoControlador implements Initializable  {

    //criando atributo com o mesmo nome do id do comboBox no arquivo fxml
    @FXML  
    private ComboBox<OpcoesDePagamento> formaDePagamento;
    //criando atributo com o mesmo nome do id do comboBox no arquivo fxml
    @FXML
    private ComboBox<OpcoesDeParcelas> quantidadeDeParcelas;
    
    //criando um arrey de tipo de pagamento 
    private List<OpcoesDePagamento> listaTipoDePagamentos = new ArrayList<OpcoesDePagamento>();
    //criando um arrey de Parcelas 
    private List<OpcoesDeParcelas> listaParcelas = new ArrayList<OpcoesDeParcelas>();
	
	//metodo que inicializa o comboBox
	public void initialize(URL location, ResourceBundle resources) {
		//chamando metodo para executa
		obiterTipoDePagamento();
		//chamndo metodo para executa
		obiterParcelas();
	}
	
    //metodo que cria o comboBox
	public void obiterTipoDePagamento() {
		//criando item de pagamento
		OpcoesDePagamento itemDePagamento1 = new OpcoesDePagamento(1,"cartão itau");
		//criando item de pagamento
		OpcoesDePagamento itemDePagamento2 = new OpcoesDePagamento(2,"dinheiro");
		//adicionando item de pagamento na lista do tipo de pagamento
		listaTipoDePagamentos.add(itemDePagamento1);
		//adicionando item de pagamento na lista do tipo de pagamento
		listaTipoDePagamentos.add(itemDePagamento2);
		
		/*
		 * adicionado lista tipo de pagamento no atributo listaDeItem do tipo TipoDePagamento 
		 * no formato ObservableList pq o comboBox só aceita um ObservableList
		 */
		ObservableList<OpcoesDePagamento> listaDeItem = FXCollections.observableArrayList(listaTipoDePagamentos);
		//adicionando listaDeItem no comboBox
	    formaDePagamento.setItems(listaDeItem);
	}
	
	 //metodo que cria o comboBox
		public void obiterParcelas() {
			//criando item de parcelas
			OpcoesDeParcelas itemDeParcelas1 = new OpcoesDeParcelas("1x");
			//criando item de parcelas
			OpcoesDeParcelas itemDeParcelas2 = new OpcoesDeParcelas("2x");
			//adicionando item de parcelas na lista parcelas
			listaParcelas.add(itemDeParcelas1);
			//adicionando item de parcelas na lista parcelas
			listaParcelas.add(itemDeParcelas2);
			
			/*
			 * adicionado lista parcelas no atributo listaDeItemDeParcels do Opções de Parcelas
			 * no formato ObservableList pq o comboBox só aceita um ObservableList
			 */
			ObservableList<OpcoesDeParcelas> listaDeItemDeParcelas = FXCollections.observableArrayList(listaParcelas);
			//adicionando listaDeItemDeParcels no comboBox
			quantidadeDeParcelas.setItems(listaDeItemDeParcelas);
		}
		
		//chamando tela inicial
		 @FXML
		    void telaInicial() {
                  Main.trocaTela("telaInicial");
		    }

}
