package com.alura.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel ModuloPrincipal;
	private JButton btnDivisas;
	private JButton btnSalir;
	private JButton btnTemperatura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(521, 365);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponent();
		
	}
	
	private void initComponent() {
		ModuloPrincipal = new JPanel();
		ModuloPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ModuloPrincipal);
		ModuloPrincipal.setLayout(null);
		
		JLabel lblTitle = DefaultComponentFactory.getInstance().createLabel("CONVERSOR ALURA");
		lblTitle.setBackground(new Color(0, 128, 255));
		lblTitle.setOpaque(true);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 516, 43);
		ModuloPrincipal.add(lblTitle);
		
		btnDivisas = new JButton("");
		btnDivisas.setIcon(new ImageIcon("C:\\Users\\HeribertoRey\\Desktop\\WORKSPACE\\Conversor\\img\\dinero.jpg"));
		btnDivisas.setBounds(56, 85, 148, 128);
		btnDivisas.addActionListener(this);
		ModuloPrincipal.add(btnDivisas);
		
		btnTemperatura = new JButton("");
		btnTemperatura.setIcon(new ImageIcon("C:\\Users\\HeribertoRey\\Desktop\\WORKSPACE\\Conversor\\img\\temperatura.png"));
		btnTemperatura.setBounds(294, 85, 148, 128);
		btnTemperatura.addActionListener(this);
		ModuloPrincipal.add(btnTemperatura);
		
		JLabel lblNewLabel = new JLabel("DIVISAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 211, 148, 25);
		ModuloPrincipal.add(lblNewLabel);
		
		JLabel lblTemperatura = new JLabel("TEMPERATURA");
		lblTemperatura.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperatura.setBounds(294, 211, 148, 25);
		ModuloPrincipal.add(lblTemperatura);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(new Color(0, 255, 255));
		btnSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnSalir.setBounds(195, 247, 115, 48);
		btnSalir.addActionListener(this);
		ModuloPrincipal.add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDivisas) {
			ConversorDivisa ventanaDivisa = new ConversorDivisa();
			ventanaDivisa.setVisible(true);
		}if(e.getSource()==btnTemperatura) {
			ConversorTemperatura ventanaTemperatura = new ConversorTemperatura();
			ventanaTemperatura.setVisible(true);
		}else if(e.getSource()== btnSalir) {
			System.exit(0);
			
		}
	}
}
