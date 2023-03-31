package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller implements Initializable {

	@FXML
	private Label Pantalla;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void clicSiete(ActionEvent event) {
		digitoPantalla("7");

	}

	@FXML
	private void clicOcho(ActionEvent event) {
		digitoPantalla("8");

	}

	@FXML
	private void clicNueve(ActionEvent event) {
		digitoPantalla("9");

	}

	@FXML
	private void clicCuatro(ActionEvent event) {
		digitoPantalla("4");

	}

	@FXML
	private void clicCinco(ActionEvent event) {
		digitoPantalla("5");

	}

	@FXML
	private void clicSeis(ActionEvent event) {
		digitoPantalla("6");

	}

	@FXML
	private void clicUno(ActionEvent event) {
		digitoPantalla("1");

	}

	@FXML
	private void clicDos(ActionEvent event) {
		digitoPantalla("2");

	}

	@FXML
	private void clicTres(ActionEvent event) {
		digitoPantalla("3");

	}

	@FXML
	private void clicCero(ActionEvent event) {
		digitoPantalla("0");

	}

	@FXML
	private void clicPunto(ActionEvent event) {
		if (!punto && !digito) {
			Pantalla.setText("0.");
			digito = true;
		} else if (!punto) {
			String valActual = Pantalla.getText();
			Pantalla.setText(valActual + ".");
		}

		punto = true;

	}

	private boolean digito = false;
	private boolean punto = false;
	private int numOperandos = 0;
	private double num1, num2;
	private char operador = ' ';

	private void digitoPantalla(String numero) {
		if (!digito && numero.equals("0"))
			return;

		if (!digito) {
			Pantalla.setText("");
			punto = false;
		}

		String valActual = Pantalla.getText();
		Pantalla.setText(valActual + numero);
		digito = true;
	}

	@FXML
	private void clicBorrar(ActionEvent event) {
		digito = false;
		punto = false;
		numOperandos = 0;
		num1 = 0;
		num2 = 0;
		operador = ' ';
		Pantalla.setText("0");

	}

	@FXML
	private void clicDividir(ActionEvent event) {
		evalOperador("/");

	}

	@FXML
	private void clicIgual(ActionEvent event) {
		evalOperador("=");

	}

	@FXML
	private void clicMultiplicar(ActionEvent event) {
		evalOperador("*");

	}

	@FXML
	private void clicPorcentaje(ActionEvent event) {
		if (numOperandos == 0) {
			Pantalla.setText("0");
			return;
		}

		double valor = Double.parseDouble(Pantalla.getText());
		double porcentaje = (num1 * valor) / 100;
		Pantalla.setText(String.valueOf(porcentaje));
		digito = true;
		punto = true;

	}

	@FXML
	private void clicRestar(ActionEvent event) {
		evalOperador("-");

	}

	@FXML
	private void clicSumar(ActionEvent event) {
		evalOperador("+");

	}

	@FXML
	private void clicValor(ActionEvent event) {
		if (digito)
			Pantalla.setText("-" + Pantalla.getText());

	}

	private void evalOperador(String operador) {

		if (digito)
			numOperandos++;

		if (numOperandos == 1)
			num1 = Double.parseDouble(Pantalla.getText());

		if (numOperandos == 2) {
			num2 = Double.parseDouble(Pantalla.getText());
			switch (this.operador) {
			case '+':
				num1 = num1 + num2;
				break;

			case '-':
				num1 = num1 - num2;
				break;
			case '*':
				num1 = num1 * num2;
				break;
			case '/':
				num1 = num1 / num2;
				break;
			case '=':
				num1 = num2;
				break;
			}
			Pantalla.setText(String.valueOf(num1));
			numOperandos = 1;
			punto = false;
		}
		digito = false;
		this.operador = operador.charAt(0);

	}

}
