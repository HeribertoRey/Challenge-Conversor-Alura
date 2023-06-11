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

public class ConversorTemperatura extends JFrame implements ActionListener {

	private JPanel VentanaDivisa;
	private JComboBox cmbSeleccioneTemperatura;
	private JLabel lblResultadoTemp;
	private JTextField txtGrados;
	private JButton btnMostrarGrados;
	private JButton btnSalirTemp;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
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
	public ConversorTemperatura() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(537, 365);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponent();

	}

	private void initComponent() {
		VentanaDivisa = new JPanel();
		VentanaDivisa.setOpaque(false);
		VentanaDivisa.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VentanaDivisa);
		VentanaDivisa.setLayout(null);

		JLabel lblNewLabel = new JLabel("CONVERSOR TEMPERATURA");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 521, 39);
		VentanaDivisa.add(lblNewLabel);

		JLabel lblSeleccionTemp = new JLabel("SELECCIONE LA CONVERSION: ");
		lblSeleccionTemp.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblSeleccionTemp.setBounds(10, 71, 353, 25);
		VentanaDivisa.add(lblSeleccionTemp);

		cmbSeleccioneTemperatura = new JComboBox();
		cmbSeleccioneTemperatura.setOpaque(false);
		cmbSeleccioneTemperatura.setBackground(new Color(0, 255, 128));
		cmbSeleccioneTemperatura.setForeground(new Color(255, 128, 64));
		cmbSeleccioneTemperatura.setFont(new Font("Tahoma", Font.BOLD, 16));
		cmbSeleccioneTemperatura
				.setModel(new DefaultComboBoxModel(new String[] { "Fahrenheit a Celsius", "Celsius a Fahrenheit" }));
		cmbSeleccioneTemperatura.setBounds(272, 72, 233, 25);
		VentanaDivisa.add(cmbSeleccioneTemperatura);

		JLabel lblIngreseLaCantidad = new JLabel("INGRESE LA CANTIDAD A REALIZAR LA CONVERSION");
		lblIngreseLaCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLaCantidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIngreseLaCantidad.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblIngreseLaCantidad.setBounds(0, 104, 505, 25);
		VentanaDivisa.add(lblIngreseLaCantidad);

		JLabel lblTituloResult = new JLabel("EL VALOR DE LA CONVERSION ES");
		lblTituloResult.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTituloResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloResult.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		lblTituloResult.setBounds(0, 185, 505, 25);
		VentanaDivisa.add(lblTituloResult);

		lblResultadoTemp = new JLabel("");
		lblResultadoTemp.setForeground(new Color(128, 0, 255));
		lblResultadoTemp.setHorizontalTextPosition(SwingConstants.CENTER);
		lblResultadoTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoTemp.setFont(new Font("Segoe UI Variable", Font.BOLD, 22));
		lblResultadoTemp.setBounds(86, 207, 330, 63);
		VentanaDivisa.add(lblResultadoTemp);

		txtGrados = new JTextField();
		txtGrados.setBounds(116, 140, 146, 34);
		txtGrados.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
		VentanaDivisa.add(txtGrados);
		txtGrados.setColumns(10);

		btnMostrarGrados = new JButton("ENVIAR");
		btnMostrarGrados.setForeground(new Color(128, 0, 64));
		btnMostrarGrados.setBackground(new Color(255, 255, 255));
		btnMostrarGrados.setFont(new Font("Cambria Math", Font.BOLD, 15));
		btnMostrarGrados.setBounds(272, 140, 117, 34);
		btnMostrarGrados.addActionListener(this);
		VentanaDivisa.add(btnMostrarGrados);

		btnSalirTemp = new JButton("SALIR");
		btnSalirTemp.setForeground(new Color(255, 0, 0));
		btnSalirTemp.setFont(new Font("Cambria Math", Font.BOLD, 13));
		btnSalirTemp.setBackground(new Color(255, 255, 255));
		btnSalirTemp.setBounds(394, 281, 117, 34);
		btnSalirTemp.addActionListener(this);
		VentanaDivisa.add(btnSalirTemp);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(new Color(0, 128, 255));
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(394, 140, 121, 34);
		btnLimpiar.addActionListener(this);
		VentanaDivisa.add(btnLimpiar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnMostrarGrados) {
			try {
				double ConvertirGrados = Double.parseDouble(txtGrados.getText());
				String TemperaturaAConvertir = (String) cmbSeleccioneTemperatura.getSelectedItem();
				double temperaturaResultante = 0;
				String GradosSim = "";

				if (TemperaturaAConvertir == "Fahrenheit a Celsius") {
					temperaturaResultante = (ConvertirGrados - 32) * 5 / 9;
					GradosSim = "°C";
				} else {
					temperaturaResultante = (ConvertirGrados * 9 / 5) + 32;
					GradosSim = "°F";
				}
				lblResultadoTemp.setText(temperaturaResultante + " " + GradosSim);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Solo ingresar numeros");
				txtGrados.setText("");
			}

		}
		if (e.getSource() == btnLimpiar) {
			cmbSeleccioneTemperatura.setSelectedItem(0);
			txtGrados.setText("");
			lblResultadoTemp.setText("");
		} else if (e.getSource() == btnSalirTemp) {
			dispose();
		}

	}
}
