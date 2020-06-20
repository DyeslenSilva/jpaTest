package br.com.jpa.banco.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.jpa.banco.model.Clients;
import br.com.jpa.banco.persist.ClientDAO;

public class CadClientes {

	private JFrame cadastroDeClientes;
	private JLabel lbLogin,lbSenha;
	private JTextField txLogin, txSenha;
	private JButton btCadastro, btFechar;
	
	public void setCadastroDeClientes() {
		cadastroDeClientes = new JFrame();
		cadastroDeClientes.setSize(300, 200);
		cadastroDeClientes.getContentPane().add(getLbLogin());
		cadastroDeClientes.getContentPane().add(getLbSenha());
		cadastroDeClientes.getContentPane().add(getTxLogin());
		cadastroDeClientes.getContentPane().add(getTxSenha());
		cadastroDeClientes.getContentPane().add(getBtCadastro());
		cadastroDeClientes.getContentPane().add(getBtFechar());
		cadastroDeClientes.setLocationRelativeTo(null);
		cadastroDeClientes.setLayout(null);
		cadastroDeClientes.setVisible(true);
	}
	
	public JLabel getLbLogin() {
		lbLogin = new JLabel("Login");
		lbLogin.setBounds(10, 10, 100, 20);
		return lbLogin;
	}
	
	public JLabel getLbSenha() {
		lbSenha = new JLabel("Senha");
		lbSenha.setBounds(10, 40, 100, 20);
		return lbSenha;
	}
	
	public JTextField getTxLogin() {
		txLogin = new JTextField();
		txLogin.setBounds(60, 10, 100, 20);
		return txLogin;
	}
	
	public JTextField getTxSenha() {
		txSenha = new JTextField();
		txSenha.setBounds(60, 40, 100, 20);
		return txSenha;
	}
	
	public JButton getBtCadastro() {
		btCadastro = new JButton("Cadastro");
		btCadastro.setBounds(10, 80, 100, 40);
		btCadastro.addActionListener(new ActionListener() {
					@Override
			public void actionPerformed(ActionEvent e) {
				if(txLogin.getText().equals("")&&txSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Entre com login e senha");
				}else {
					Clients client = new Clients();
					ClientDAO dao = new ClientDAO();
					client.setLoginCliente(txLogin.getText());
					client.setPassword(txSenha.getText());
					
					try {
						dao.saveClients(client);
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}					
					
					JOptionPane.showMessageDialog(null, "cadastrado");
					txLogin.setText("");
					txSenha.setText("");
				}
			}
		});
		return btCadastro;
	}
	
	public JButton getBtFechar() {
		btFechar = new JButton("Fechar");
		btFechar.setBounds(120, 80, 100, 40);
		btFechar.setBackground(Color.red);
		btFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroDeClientes.dispose();
			}
		});
		return btFechar;
	}
	
	public static void main(String[] args) {
		new CadClientes().setCadastroDeClientes();
	}
}
