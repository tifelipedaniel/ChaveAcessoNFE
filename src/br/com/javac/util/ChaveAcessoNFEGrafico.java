package br.com.javac.util;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;

public class ChaveAcessoNFEGrafico {

	private JFrame frame;
	private JTextField cUF;
	private JTextField dataAAMM;
	private JTextField cnpjCpf;
	private JTextField mod;
	private JTextField serie;
	private JTextField nNF;
	private JTextField cNF;
	private JTextField chave;

//	private String cUF = "35"; // Código da UF do emitente do Documento Fiscal.  
//	private String dataAAMM = "1906"; // Ano e Mês de emissão da NF-e.  
//	private String cnpjCpf = "03.258.870/0001-53"; // CNPJ do emitente.  
//	private String mod = "55"; // Modelo do Documento Fiscal.  
//	private String serie = "1"; // Série do Documento Fiscal.  
//	private String tpEmis = "1"; // Forma de emissão da NF-e  
//	private String nNF = "127377"; // Número do Documento Fiscal.  
//	private String cNF = "64690"; // Código Numérico que compõe a Chave de Acesso
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChaveAcessoNFEGrafico window = new ChaveAcessoNFEGrafico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		    
		});
	}
    
	/**
	 * Create the application.
	 */
	public ChaveAcessoNFEGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3d. UF:");
		lblNewLabel.setBounds(23, 24, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDataNf = new JLabel("Data NF:");
		lblDataNf.setBounds(23, 49, 63, 14);
		frame.getContentPane().add(lblDataNf);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(23, 74, 46, 14);
		frame.getContentPane().add(lblCnpj);
		
		JLabel lblModeloNf = new JLabel("Modelo NF:");
		lblModeloNf.setBounds(23, 99, 63, 14);
		frame.getContentPane().add(lblModeloNf);
		
		JLabel lblCnpj_1_1 = new JLabel("S\u00E9rie NF:");
		lblCnpj_1_1.setBounds(23, 124, 63, 14);
		frame.getContentPane().add(lblCnpj_1_1);
		
		JLabel lblCnpj_1_2 = new JLabel("Ambiente");
		lblCnpj_1_2.setBounds(23, 153, 63, 14);
		frame.getContentPane().add(lblCnpj_1_2);
		
		JLabel lblCnpj_1_3 = new JLabel("N\u00FAmero NF:");
		lblCnpj_1_3.setBounds(23, 178, 63, 14);
		frame.getContentPane().add(lblCnpj_1_3);
		
		JLabel lblCnpj_1_3_1 = new JLabel("C\u00F3digo NF:");
		lblCnpj_1_3_1.setBounds(23, 203, 63, 14);
		frame.getContentPane().add(lblCnpj_1_3_1);
		
		cUF = new JTextField();
		cUF.setBounds(96, 21, 37, 20);
		frame.getContentPane().add(cUF);
		cUF.setColumns(10);
		
		dataAAMM = new JTextField();
		dataAAMM.setBounds(96, 46, 63, 20);
		frame.getContentPane().add(dataAAMM);
		dataAAMM.setColumns(10);
		
		cnpjCpf = new JTextField();
		cnpjCpf.setBounds(96, 71, 157, 20);
		frame.getContentPane().add(cnpjCpf);
		cnpjCpf.setColumns(10);
		
		mod = new JTextField();
		mod.setBounds(96, 96, 46, 20);
		frame.getContentPane().add(mod);
		mod.setColumns(10);
		
		serie = new JTextField();
		serie.setBounds(96, 121, 46, 20);
		frame.getContentPane().add(serie);
		serie.setColumns(10);
		
		JSpinner tpEmis = new JSpinner();
		tpEmis.setToolTipText("1=Produ\u00E7\u00E3o 2=Homologa\u00E7\u00E3o");
		tpEmis.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		tpEmis.setBounds(96, 150, 57, 20);
		frame.getContentPane().add(tpEmis);
		
		nNF = new JTextField();
		nNF.setBounds(96, 175, 86, 20);
		frame.getContentPane().add(nNF);
		nNF.setColumns(10);
		
		cNF = new JTextField();
		cNF.setBounds(96, 200, 86, 20);
		frame.getContentPane().add(cNF);
		cNF.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ChaveAcessoNFE chave1 = new ChaveAcessoNFE();
				chave1.setcUF(cUF.getText());
				chave1.setDataAAMM(dataAAMM.getText());
				chave1.setCnpjCpf(cnpjCpf.getText());
				chave1.setmod(mod.getText());
				chave1.setserie(serie.getText());
				chave1.settpEmis(tpEmis.getValue().toString());
				chave1.setnNF(nNF.getText());
				chave1.setcNF(cNF.getText());
				
				chave.setText(chave1.geraChave());
				
			}
		});
		
		btnNewButton.setBounds(335, 20, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Chave:");
		lblNewLabel_1.setBounds(23, 234, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		chave = new JTextField();
		chave.setBounds(67, 231, 362, 20);
		frame.getContentPane().add(chave);
		chave.setColumns(10);
	}

}
