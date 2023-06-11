package com.alura.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.MathContext;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConversorDivisa extends JFrame implements ActionListener {

	private JPanel VentanaDivisa;
	private JTextField txtValorAConvertir;
	private JComboBox cmbSeleccionDivisa;
	private JLabel lblResultado;
	private JButton btnEnviar;
	private JButton btnLimpiarDiv;
	private JButton btnSalirDiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDivisa frame = new ConversorDivisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorDivisa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(537, 365);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponent();

	}

	private void initComponent() {
		VentanaDivisa = new JPanel();
		VentanaDivisa.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VentanaDivisa);
		VentanaDivisa.setLayout(null);

		JLabel lblNewLabel = new JLabel("CONVERSOR DIVISAS");
		lblNewLabel.setBackground(new Color(0, 255, 64));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 505, 39);
		VentanaDivisa.add(lblNewLabel);

		JLabel lblSeleccion = new JLabel("SELECCIONE LA CONVERSION: ");
		lblSeleccion.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblSeleccion.setBounds(10, 71, 353, 25);
		VentanaDivisa.add(lblSeleccion);

		cmbSeleccionDivisa = new JComboBox();
		cmbSeleccionDivisa.setForeground(new Color(128, 0, 0));
		cmbSeleccionDivisa.setFont(new Font("Tahoma", Font.BOLD, 16));
		cmbSeleccionDivisa.setModel(new DefaultComboBoxModel(new String[] { "Dolar a Euro", "Dolar a Libra Esterlina",
				"Dolar a Yen Japones", "Dolar a Won sur-coreano", "Euro a Dolar", "Libra Esterlina a Dolar",
				"Yen Japones a Dolar", "Won sur-coreano a Dolar" }));
		cmbSeleccionDivisa.setBounds(272, 72, 233, 25);
		VentanaDivisa.add(cmbSeleccionDivisa);

		JLabel lblIngreseLaCantidad = new JLabel("INGRESE LA CANTIDAD A REALIZAR LA CONVERSION");
		lblIngreseLaCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLaCantidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIngreseLaCantidad.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblIngreseLaCantidad.setBounds(0, 104, 505, 25);
		VentanaDivisa.add(lblIngreseLaCantidad);

		txtValorAConvertir = new JTextField();
		txtValorAConvertir.setBounds(42, 140, 196, 39);
		txtValorAConvertir.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		VentanaDivisa.add(txtValorAConvertir);
		txtValorAConvertir.setColumns(10);

		JLabel lblTituloResult = new JLabel("EL VALOR DE LA CONVERSION ES");
		lblTituloResult.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTituloResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloResult.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblTituloResult.setBounds(0, 185, 505, 25);
		VentanaDivisa.add(lblTituloResult);

		lblResultado = new JLabel("");
		lblResultado.setForeground(new Color(128, 0, 255));
		lblResultado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Segoe UI Variable", Font.BOLD, 22));
		lblResultado.setBounds(86, 207, 330, 63);
		VentanaDivisa.add(lblResultado);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnviar.setBounds(243, 140, 128, 39);
		btnEnviar.addActionListener(this);
		VentanaDivisa.add(btnEnviar);
		
		btnLimpiarDiv = new JButton("LIMPIAR");
		btnLimpiarDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLimpiarDiv.setBounds(375, 140, 128, 39);
		btnLimpiarDiv.addActionListener(this);
		VentanaDivisa.add(btnLimpiarDiv);
		
		btnSalirDiv = new JButton("SALIR");
		btnSalirDiv.setForeground(new Color(255, 0, 128));
		btnSalirDiv.setFont(new Font("Stencil", Font.BOLD, 16));
		btnSalirDiv.setBounds(375, 281, 128, 34);
		btnSalirDiv.addActionListener(this);
		VentanaDivisa.add(btnSalirDiv);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnviar) {
			try {
				double cantidadMoneda = Double.parseDouble(txtValorAConvertir.getText());
				String divisaSeleccionada = (String) cmbSeleccionDivisa.getSelectedItem();
				double resultado =0;
				String simbologia = "";
				
				 switch (divisaSeleccionada) {
	             case "Dolar a Euro":
	                 resultado = cantidadMoneda*0.92894;
	                 simbologia ="EUR";
	                 break;
	             case "Dolar a Libra Esterlina":
	                 resultado = cantidadMoneda * 0.79586;
	                 simbologia ="GBP";
	                 break;
	             case "Dolar a Yen Japones":
	                 resultado = cantidadMoneda * 139.354;
	                 simbologia ="JPY";
	                 break;
	             case "Dolar a Won sur-coreano":
	                 resultado = cantidadMoneda * 1290.41;
	                 simbologia ="KRW";
	                 break;
	             case "Euro a Dolar":
	                 resultado = cantidadMoneda * 1.07633;
	                 simbologia ="USD";
	                 break;
	             case "Libra Esterlina a Dolar":
	                 resultado = cantidadMoneda * 1.25631;
	                 simbologia ="USD";
	                 break;
	             case "Yen Japones a Dolar":
	                 resultado = cantidadMoneda * 0.00717;
	                 simbologia ="USD";
	                 break;
	             case "Won sur-coreano a Dolar":
	                 resultado = cantidadMoneda * 0.00077;
	                 simbologia ="USD";
	                 break;
				 }
				 lblResultado.setText(resultado+" "+simbologia);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Favor solamente ingresar numeros del 0 - 9");
				txtValorAConvertir.setText("");
			}
		}if(e.getSource()==btnLimpiarDiv) {
			cmbSeleccionDivisa.setSelectedItem(0);
			txtValorAConvertir.setText("");
			lblResultado.setText("");
		}else if(e.getSource() == btnSalirDiv) {
			dispose();
		}
	}

}
