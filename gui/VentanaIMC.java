package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import clases.Procesos;

public class VentanaIMC extends JFrame implements ActionListener{

	JPanel panel;
	
	JLabel titulo;
	
	JLabel nombre;
	JTextField nombreInput;
	
	JLabel peso;
	JTextField pesoInput;
	
	JLabel altura;
	JTextField alturaInput;
	
	
	JLabel resultado;
	JButton calcular;
	JButton limpiar;
	
	Procesos miValidacion;
	
	public VentanaIMC() {
		iniciarComponentes();
		setTitle("Sergio Chica");
		setSize(500,350);
		setLocationRelativeTo(null);
	}
	
	private void iniciarComponentes() {
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		
		titulo=new JLabel();
		titulo.setText("SISTEMA DE CONTROL DE IMC");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(100,30,300,30);
		titulo.setFont(titulo.getFont().deriveFont(15f));
		
		nombre=new JLabel();
		nombre.setText("Nombre: ");
		nombre.setBounds(50,90,220,30);
		
		nombreInput=new JTextField();
		nombreInput.setBounds(110, 92, 150, 30);
		
		peso=new JLabel();
		peso.setText("Peso: ");
		peso.setBounds(60,150,220,30);
		
		pesoInput=new JTextField();
		pesoInput.setBounds(110,152,80,30);
		
		altura=new JLabel();
		altura.setText("Altura: ");
		altura.setBounds(195,150,220,30);
		
		alturaInput=new JTextField();
		alturaInput.setBounds(235,152,80,30);
		
		resultado=new JLabel();
		resultado.setText("Resultado: ");
		resultado.setBounds(60,210,420,30);
		
		calcular=new JButton();
		calcular.setText("Calcular");
		calcular.setBounds(110,260,150,30);
		calcular.setOpaque(false);
		calcular.setContentAreaFilled(false);
		calcular.addActionListener(this);
		
		limpiar=new JButton();
		limpiar.setText("Limpiar");
		limpiar.setBounds(300,260,150,30);
		limpiar.setOpaque(false);
		limpiar.setContentAreaFilled(false);
		limpiar.addActionListener(this);
		
		panel.add(titulo);
		
		panel.add(nombre);
		panel.add(nombreInput);
		
		panel.add(peso);
		panel.add(pesoInput);
		panel.add(altura);
		panel.add(alturaInput);
		
		panel.add(resultado);
		panel.add(calcular);
		panel.add(limpiar);
		
		add(panel);
		
	}
	
	
	public void calcular() {
		
		Double pesoDouble = Double.parseDouble(pesoInput.getText());
		Double alturaDouble = Double.parseDouble(alturaInput.getText());
		
		miValidacion = new Procesos();
		
		double resultadoimc = miValidacion.calcularIMC(pesoDouble,alturaDouble);
		
		if (resultadoimc != -1) {
			if (resultadoimc < 18) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en pajo peso");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 18 && resultadoimc <=24) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en peso normal");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 25 && resultadoimc <=29) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en Sobrepeso");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 30 && resultadoimc <=34) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en Obesidad I");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 35 && resultadoimc <=39) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en Obesidad II");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 40 && resultadoimc <=49) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en Obesidad III");
				resultado.setForeground(Color.black);
			}else if (resultadoimc >= 50) {
				resultado.setText("Resultado: Hola" + nombreInput.getText() +" , su imc es de "+ resultadoimc+ " Esta en Obesidad IV");
				resultado.setForeground(Color.black);
			}
		}else {
			resultado.setText("Resultado: Debe ingresar un numero positivo mayor a 0");
			resultado.setForeground(Color.RED);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==calcular) {
			calcular();
		}else if (e.getSource()==limpiar){
			nombreInput.setText("");
			pesoInput.setText("");
			alturaInput.setText("");
			resultado.setText("Resultado:");
			resultado.setForeground(Color.BLACK);
		}
		
	}
	
	

}
