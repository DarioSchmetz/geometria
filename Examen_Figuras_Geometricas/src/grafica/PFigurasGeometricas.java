package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logica.*;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

public class PFigurasGeometricas extends JFrame {

	private JPanel contentPane;
	private JTextField txtFLargo;
	private JTextField txtFAncho;
	private JTextField txtFRadio;
	private JTextField txtFAltura;

	// Este doubles los uso para guardar las variables de las figuras.
	private double largo = 0;
	private double ancho = 0;
	private double radio = 0;
	private double altura = 0;

	// Estos booleanos los uso en el metodo ExaminarNumeros().
	boolean isRectanguloSelected = false;
	boolean isCircunferenciaSelected = false;
	boolean isTrianguloSelected = false;

	// Botones JRadioButton agrupados.
	private ButtonGroup grupoDeBotones = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PFigurasGeometricas frame = new PFigurasGeometricas();
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
	public PFigurasGeometricas() {
		setTitle("Figuras geometricas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Con el metodo "setLocationRelativeTo(null)" nos ahorramos de llamar al metodo
		 * getScreenSize() y obtener los valores de height y width y luego operar
		 * matematicamente para que el frame nos quede centrado. Solo hay que espeficar
		 * PRIMERO el tamanio de la ventana con setSize() Y LUEGO el metodo mencionado. */
		setSize(500, 390);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTipoFigura = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTipoFigura.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTipoFigura.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de figura",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipoFigura.setBounds(47, 25, 122, 108);
		contentPane.add(panelTipoFigura);

		JRadioButton rdbtnRectangulo = new JRadioButton("Rectangulo");
		rdbtnRectangulo.setHorizontalAlignment(SwingConstants.LEFT);
		panelTipoFigura.add(rdbtnRectangulo);
		grupoDeBotones.add(rdbtnRectangulo);

		JRadioButton rdbtnCircunferencia = new JRadioButton("Circunferencia");
		rdbtnCircunferencia.setHorizontalAlignment(SwingConstants.LEFT);
		panelTipoFigura.add(rdbtnCircunferencia);
		grupoDeBotones.add(rdbtnCircunferencia);

		JRadioButton rdbtnTriangulo = new JRadioButton("Triangulo");
		rdbtnTriangulo.setHorizontalAlignment(SwingConstants.LEFT);
		panelTipoFigura.add(rdbtnTriangulo);
		grupoDeBotones.add(rdbtnTriangulo);

		JPanel panelDatosFigura = new JPanel();
		panelDatosFigura.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Figura",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosFigura.setBounds(10, 144, 187, 145);
		contentPane.add(panelDatosFigura);
		panelDatosFigura.setLayout(null);

		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setBounds(32, 24, 48, 14);
		panelDatosFigura.add(lblLargo);

		txtFLargo = new JTextField();
		txtFLargo.setBounds(69, 24, 86, 20);
		panelDatosFigura.add(txtFLargo);
		txtFLargo.setColumns(10);

		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(29, 49, 51, 14);
		panelDatosFigura.add(lblAncho);

		txtFAncho = new JTextField();
		txtFAncho.setBounds(69, 49, 86, 20);
		panelDatosFigura.add(txtFAncho);
		txtFAncho.setColumns(10);

		JLabel lblRadio = new JLabel("Radio");
		lblRadio.setBounds(32, 74, 48, 14);
		lblRadio.setHorizontalAlignment(SwingConstants.LEFT);
		panelDatosFigura.add(lblRadio);

		txtFRadio = new JTextField();
		txtFRadio.setBounds(69, 74, 86, 20);
		panelDatosFigura.add(txtFRadio);
		txtFRadio.setColumns(10);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(32, 99, 48, 14);
		panelDatosFigura.add(lblAltura);

		txtFAltura = new JTextField();
		txtFAltura.setBounds(70, 99, 86, 20);
		panelDatosFigura.add(txtFAltura);
		txtFAltura.setColumns(10);

		JButton btnCalcularArea = new JButton("Calcular Area");
		btnCalcularArea.setBounds(222, 49, 115, 40);
		contentPane.add(btnCalcularArea);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(222, 162, 64, 23);
		contentPane.add(btnSalir);

		JButton btnLimpiar = new JButton("Ingresar nuevo calculo");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFLargo.setText(null);
				txtFAncho.setText(null);
				txtFAltura.setText(null);
				txtFRadio.setText(null);
			}

		});
		// ----------------------------------------------------------------------
		// Cuando la app inicie, esten todos los campos deshabilitados.
		txtFLargo.setEditable(false);
		txtFAncho.setEditable(false);
		txtFRadio.setEditable(false);
		txtFAltura.setEditable(false);
		// **********************************************************************

		btnLimpiar.setBounds(222, 110, 180, 23);
		contentPane.add(btnLimpiar);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// ----------------------------------------------------------------------
		/* GRUPO DE SENTENCIAS PARA EVALUAR QUE BOTON SE SELECCIONO Y HACER EDITABLES O
		 * NO LOS CAMPOS DE INGRESO DE NUMEROS SEGUN CORRESPONDA LA FIGURA SELECCIONADA. */

		// RECTANGULO
		rdbtnRectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFLargo.setEditable(true);
				txtFAncho.setEditable(true);
				txtFRadio.setEditable(false);
				txtFAltura.setEditable(false);
			}
		});

		// CIRCUNFERENCIA
		rdbtnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFLargo.setEditable(false);
				txtFAncho.setEditable(false);
				txtFRadio.setEditable(true);
				txtFAltura.setEditable(false);
			}
		});

		// TRIANGULO
		rdbtnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFLargo.setEditable(false);
				txtFAncho.setEditable(true);
				txtFRadio.setEditable(false);
				txtFAltura.setEditable(true);
			}
		});
		// **********************************************************************

// ------------------------------------------------------------------------------------------
		// Cuando se hace CLICK en el boton Calcular Area:
		btnCalcularArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Antes de calcular, primero evalua si ya se selecciono algun boton. Si ya se
				 * selecciono, pasa a tomar los datos y hacer los calculos, pero si no se
				 * selecciono ningun boton, lanza un cuadro informando que no se selecciono
				 * ningun boton. */
				if (!(rdbtnRectangulo.isSelected() || rdbtnCircunferencia.isSelected() || rdbtnTriangulo.isSelected())) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna figura.");
				} else { // Si se selecciono una figura antes de pulsar "Calcular area", se ejecuta normalmente el programa.
					
					// ----------------------------------------------------------------------
					// SECCION QUE PREGUNTA CUAL DE TODOS LOS BOTONES SE HA SELECCIONADO.

					// Pregunta si esta seleccionado el boton Rectangulo entonces calcula su area.
					if (rdbtnRectangulo.isSelected()) {
						isRectanguloSelected = true;
						Rectangulo rec = new Rectangulo();
						/* Encierro en un bloque try-catch al pulsar "Calcular area" para capturar el
						 * error: "java.lang.NumberFormatException: empty String." Tambien lo uso para
						 * capturar el error "DatosNoValidosException" requerido. */
						try {
							largo = Double.parseDouble(txtFLargo.getText());
							ancho = Double.parseDouble(txtFAncho.getText());
							ExaminarNumeros();
							rec.setLargo(largo);
							rec.setAncho(ancho);
							JOptionPane.showMessageDialog(null, "El area del rectangulo es: " + rec.CalcularArea());

						} catch (NumberFormatException nfeRectangulo) {
							JOptionPane.showMessageDialog(null, "Digite un valor para Largo y Ancho.");
							nfeRectangulo.printStackTrace();
						} catch (DatosNoValidosException dnveRectangulo) {
							JOptionPane.showMessageDialog(null, "Valores no permitidos.");
							txtFLargo.setText(null);
							txtFAncho.setText(null);
							dnveRectangulo.printStackTrace();
						}
					}

					// Sino, pregunta si esta seleccionado el boton Circunferencia entonces calcula su area.
					else if (rdbtnCircunferencia.isSelected()) {
						isCircunferenciaSelected = true;
						Circunferencia circ = new Circunferencia();
						/* Encierro en un bloque try-catch al pulsar "Calcular area" para capturar el
						 * error: "java.lang.NumberFormatException: empty String." Tambien lo uso para
						 * capturar el error "DatosNoValidosException" requerido. */
						try {
							radio = Double.parseDouble(txtFRadio.getText());
							ExaminarNumeros();
							circ.setRadio(radio);
							JOptionPane.showMessageDialog(null, "El area de la Circunferencia es: " + circ.CalcularArea());

						} catch (NumberFormatException nfeCirc) {
							JOptionPane.showMessageDialog(null, "Digite un valor para Radio.");
							nfeCirc.printStackTrace();
						} catch (DatosNoValidosException dnveCirc) {
							JOptionPane.showMessageDialog(null, "Valores no permitidos.");
							dnveCirc.printStackTrace();
							txtFRadio.setText(null);
						}
					}

					// Sino, pregunta si esta seleccionado el boton Triangulo entonces calcula su area.
					else if (rdbtnTriangulo.isSelected()) {
						isTrianguloSelected = true;
						Triangulo tri = new Triangulo();
						/* Encierro en un bloque try-catch al pulsar "Calcular area" para capturar el
						 * error: "java.lang.NumberFormatException: empty String." Tambien lo uso para
						 * capturar el error "DatosNoValidosException" requerido. */
						try {

							altura = Double.parseDouble(txtFAltura.getText());
							ancho = Double.parseDouble(txtFAncho.getText());
							ExaminarNumeros();
							tri.setAltura(altura);
							tri.setAncho(ancho);
							JOptionPane.showMessageDialog(null, "El area del Triangulo es: " + tri.CalcularArea());

						} catch (NumberFormatException nfeTri) {
							JOptionPane.showMessageDialog(null, "Digite un valor para Alto y Ancho.");
							nfeTri.printStackTrace();
						} catch (DatosNoValidosException dnveTri) {
							JOptionPane.showMessageDialog(null, "Valores no permitidos.");
							dnveTri.printStackTrace();
							txtFAltura.setText(null);
							txtFAncho.setText(null);
						}
					}
				}
			}

			// Metodo que examina si los numeros ingresados cumplen o no con la restriccion requerida.
			private void ExaminarNumeros() throws DatosNoValidosException {

				if (isRectanguloSelected) {
					if (largo <= 0 || ancho <= 0) {
						throw new DatosNoValidosException("Los valores no pueden ser ceros ni negativos.");
					}
				}

				if (isCircunferenciaSelected) {
					if (radio <= 0) {
						throw new DatosNoValidosException("Los valores no pueden ser ceros ni negativos.");
					}
				}

				if (isTrianguloSelected) {
					if (altura <= 0 || ancho <= 0) {
						throw new DatosNoValidosException("Los valores no pueden ser ceros ni negativos.");
					}
				}
			}
		});
// ******************************************************************************************

// ------------------------------------------------------------------------------------------			
		/* SERIE DE METODOS PARA LIMPIAR LOS CAMPOS SEGUN SE SELECCIONE LA FIGURA
		 * GEOMETRICA, PARA INGRESAR NUEVOS VALORES. */

		rdbtnRectangulo.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFAncho.setText(null);
				txtFRadio.setText(null);
				txtFAltura.setText(null);
			}
		}));

		rdbtnCircunferencia.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFAltura.setText(null);
				txtFLargo.setText(null);
				txtFAncho.setText(null);
			}
		}));

		rdbtnTriangulo.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFAltura.setText(null);
				txtFLargo.setText(null);
				txtFAncho.setText(null);
				txtFRadio.setText(null);
			}
		}));
// ******************************************************************************************		
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
// ******************************************************************************************
}