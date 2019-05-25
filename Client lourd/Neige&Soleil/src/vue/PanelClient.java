package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Tableau;
import modele.Modele;
import modele.ModeleClient;

public class PanelClient extends Panel implements ActionListener {

	private JTable uneTable;
	private Tableau unTableau;
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtIdClient = new JTextField();
	private JTextField txtSexe = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtDate = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btModifier = new JButton("Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btOk = new JButton("Ok");
	private JTextField txtMot = new JTextField();
	private JPanel unPanelRecherche = new JPanel();
	private JPanel unPanelBoutons = new JPanel();
	
	public PanelClient() {
		super();
		this.setBackground(Color.white);
		String entetes[] = {"ID Client","Sexe", "Nom", "Prénom", "Email", "Téléphone", "Date de Naissance", "Mot de passe"};
		unTableau = new Tableau(this.getLesClients(ModeleClient.SelectAllClients()), entetes);
		uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20, 10, 750, 150);
		this.add(uneScroll);
	

		//Construction du panel
		this.unPanelRecherche.setLayout(new GridLayout(1,3));
		this.unPanelRecherche.add(new JLabel("Filtre par colonnes : "));
		this.unPanelRecherche.add(txtMot);
		this.unPanelRecherche.add(btOk);
		this.unPanelRecherche.setBounds(150, 170, 500, 30);
		this.add(unPanelRecherche);
		this.btOk.addActionListener(this);
		
		//Construction du panel Ajouter
		this.unPanelAjout.setLayout(new GridLayout(4,6));
		
		this.txtIdClient.setEditable(false);
		this.unPanelAjout.add(new JLabel("ID Client : "));
		this.unPanelAjout.add(txtIdClient);
		this.unPanelAjout.add(new JLabel("Sexe : "));
		this.unPanelAjout.add(txtSexe);
		this.unPanelAjout.add(new JLabel("Nom :"));
		this.unPanelAjout.add(txtNom);
		this.unPanelAjout.add(new JLabel("Prénom : "));
		this.unPanelAjout.add(txtPrenom);
		this.unPanelAjout.add(new JLabel("Email : "));
		this.unPanelAjout.add(txtEmail);
		this.unPanelAjout.add(new JLabel("Téléphone : "));
		this.unPanelAjout.add(txtTel);
		this.unPanelAjout.add(new JLabel("Date de Naissance : "));
		this.unPanelAjout.add(txtDate);
		this.unPanelAjout.add(new JLabel("Mot de passe : "));
		this.unPanelAjout.add(txtMdp);
		this.unPanelAjout.setBounds(20, 220, 750, 60);
		this.add(this.unPanelAjout);
		
		//Construction du panel Boutons
		this.unPanelBoutons.setLayout(new GridLayout(1,4));
		this.unPanelBoutons.setBounds(20, 300, 750, 25);
		this.unPanelBoutons.add(this.btAnnuler);
		this.unPanelBoutons.add(this.btAjouter);
		this.unPanelBoutons.add(this.btModifier);
		this.unPanelBoutons.add(this.btSupprimer);
		this.add(this.unPanelBoutons);
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		this.btOk.addActionListener(this);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			int ligne = uneTable.getSelectedRow();
			txtIdClient.setText((int)uneTable.getValueAt(ligne, 0) + "");
			txtSexe.setText((String)uneTable.getValueAt(ligne, 1));
			txtNom.setText((String)uneTable.getValueAt(ligne, 2));
			txtPrenom.setText((String)uneTable.getValueAt(ligne, 3));
			txtEmail.setText((String)uneTable.getValueAt(ligne, 4));
			txtTel.setText((String)uneTable.getValueAt(ligne, 5));
			txtDate.setText((String)uneTable.getValueAt(ligne, 6));
			txtMdp.setText((String)uneTable.getValueAt(ligne, 7));
			}
		});
	
	}
	public Object [][] getLesClients(ArrayList<Client> lesClients) {
		
		Object [][] matrice = new Object[lesClients.size()][8];
		int i = 0;
		for (Client unClient : lesClients) {
			matrice[i][0] = unClient.getIDCL();
			matrice[i][1] = unClient.getSexecl();
			matrice[i][2] = unClient.getNomcl();
			matrice[i][3] = unClient.getPrenomcl();
			matrice[i][4] = unClient.getAdrmailcl();
			matrice[i][5] = unClient.getTelcl();
			matrice[i][6] = unClient.getDatenaicl();
			matrice[i][7] = unClient.getMdpcl();
			i++;
		}
		return matrice;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btOk) {
			String mot = this.txtMot.getText();
			Object [][] matrice = this.getLesClients(ModeleClient.SelectWhereClient(mot));
			unTableau.setDonnees(matrice);
		}else if (e.getSource() == this.btAnnuler){
			txtIdClient.setText("");
			txtSexe.setText("");
			txtNom.setText("");
			txtPrenom.setText("");
			txtEmail.setText("");
			txtTel.setText("");
			txtDate.setText("");
			txtMdp.setText("");
		}else if(e.getSource() == this.btAjouter) {
			Client unClient = new Client(txtSexe.getText(),
					txtNom.getText(), txtPrenom.getText(), txtEmail.getText(),
					txtTel.getText(),txtDate.getText(), txtMdp.getText());
			ModeleClient.insertClient(unClient);
			Object ligne [] = { unClient.getIDCL(), unClient.getSexecl(),
								unClient.getNomcl(), unClient.getPrenomcl() ,unClient.getAdrmailcl(),
								unClient.getTelcl(), unClient.getDatenaicl(), unClient.getMdpcl()};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie !", "Insertion d'un client", JOptionPane.INFORMATION_MESSAGE);
			txtIdClient.setText("");
			txtSexe.setText("");
			txtNom.setText("");
			txtPrenom.setText("");
			txtEmail.setText("");
			txtTel.setText("");
			txtDate.setText("");
			txtMdp.setText("");
		}else if(e.getSource() == this.btModifier) {
			int idcl = Integer.parseInt(txtIdClient.getText());
			Client unClient = new Client(idcl, txtSexe.getText(),
					txtNom.getText(), txtPrenom.getText(), txtEmail.getText(),
					txtTel.getText(),txtDate.getText(), txtMdp.getText());
			ModeleClient.updateClient(unClient);
			Object ligne [] = { unClient.getIDCL(), unClient.getSexecl(),
					unClient.getNomcl(), unClient.getPrenomcl(), unClient.getAdrmailcl(), unClient.getTelcl(), unClient.getDatenaicl(), unClient.getMdpcl()};
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.updateTable(ligne, indiceLigne);
		
		}else if (e.getSource() == this.btSupprimer) {
			int idclient = Integer.parseInt(txtIdClient.getText());
			ModeleClient.deleteClient(idclient);
			int indiceLigne = uneTable.getSelectedRow();		
			unTableau.deleteTable(indiceLigne);
		
		}
		
	}

}
