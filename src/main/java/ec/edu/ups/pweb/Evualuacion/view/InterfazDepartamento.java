package ec.edu.ups.pweb.Evualuacion.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.pweb.Evaluacion.business.DepartamentoONRemoto;
import ec.edu.ups.pweb.demoapp.model.Departamento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class InterfazDepartamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtDireccion;
	private JTextField txtNumeroCuarto;
	private JTextField txtNumeroPiso;
	
	private DepartamentoONRemoto depRemote;
	private JButton btnActualizar;
	private JLabel lblNewLabel_3;
	private JTextField txtCodigo;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDepartamento frame = new InterfazDepartamento();
					frame.conectar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:18080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");  
              
            final Context context = new InitialContext(jndiProperties);  
              
                     
            final String lookupName5 = "ejb:/demoApp/DepartamentoON!ec.edu.ups.pweb.Evaluacion.business.DepartamentoONRemoto";  
            
            this.depRemote = (DepartamentoONRemoto) context.lookup(lookupName5);
            
            
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void crearDepartamento () {
		
		String direccionD = txtDireccion.getText();
		int numeroCuartosD = Integer.parseInt(txtNumeroCuarto.getText()) ;
		int numeroPisoD = Integer.parseInt(txtNumeroPiso.getText()) ;
		
		Departamento dep = new Departamento();
		dep.setDireccion(direccionD);
		dep.setNumeroCuartos(numeroCuartosD);
		dep.setNumeroPiso(numeroPisoD);
		
		try {
			depRemote.insertar(dep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public InterfazDepartamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Direccion:");
		lblNewLabel.setBounds(32, 29, 83, 13);
		contentPane.add(lblNewLabel);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(125, 26, 96, 19);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Cuartos:");
		lblNewLabel_1.setBounds(32, 68, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		txtNumeroCuarto = new JTextField();
		txtNumeroCuarto.setBounds(165, 65, 96, 19);
		contentPane.add(txtNumeroCuarto);
		txtNumeroCuarto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de Piso:");
		lblNewLabel_2.setBounds(32, 111, 123, 13);
		contentPane.add(lblNewLabel_2);
		
		txtNumeroPiso = new JTextField();
		txtNumeroPiso.setBounds(165, 108, 96, 19);
		contentPane.add(txtNumeroPiso);
		txtNumeroPiso.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearDepartamento();
			}
		});
		btnIngresar.setBounds(64, 149, 85, 21);
		contentPane.add(btnIngresar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(176, 149, 85, 21);
		contentPane.add(btnActualizar);
		
		lblNewLabel_3 = new JLabel("Codigo:");
		lblNewLabel_3.setBounds(280, 29, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(330, 26, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscar.setBounds(319, 64, 85, 21);
		contentPane.add(btnBuscar);
	}
	
	
}
