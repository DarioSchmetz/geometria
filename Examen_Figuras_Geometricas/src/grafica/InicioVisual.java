package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class InicioVisual extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioVisual frame = new InicioVisual();
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
	public InicioVisual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Con el metodo "setLocationRelativeTo(null)" nos ahorramos de llamar al metodo
		 * getScreenSize() y obtener los valores de height y width y luego dividirlos, etc.
		 * Solo hay que espeficar PRIMERO el tamanio de la ventana con setSize() Y LUEGO
		 * el metodo mencionado. */
		setSize(450,300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresar = new JLabel("Bienvenido al sistema");
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblIngresar.setBounds(41, 22, 342, 32);
		contentPane.add(lblIngresar);
		
		
		JButton btnSeleciones = new JButton("Ingresar");
		btnSeleciones.setBounds(149, 155, 89, 65);
		contentPane.add(btnSeleciones);
		
		JLabel lblDeOperacionesGeometricas = new JLabel("de operaciones geometricas");
		lblDeOperacionesGeometricas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeOperacionesGeometricas.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDeOperacionesGeometricas.setBounds(41, 75, 342, 32);
		contentPane.add(lblDeOperacionesGeometricas);
		btnSeleciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PFigurasGeometricas g = new PFigurasGeometricas();	
				g.setVisible(true);
			}
		});
		
		//-------------------------------------------------
		// GRUPO DE SENTENCIAS PARA COLOCAR UNA IMAGEN DEFINIDA POR EL PROGRAMADOR.
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image Icono;
		// Si no encuentra la imagen lanza una excepcion informando.
		try {
			Icono = miPantalla.getImage("src/grafica/Icono.gif");
			setIconImage(Icono);
			
		} catch (Exception e) {
			System.out.println("No se ha encotrado el icono de la ventana.");
			System.err.println(e);
		}
		//-------------------------------------------------
	}
}