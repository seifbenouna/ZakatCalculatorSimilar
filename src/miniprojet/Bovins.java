package miniprojet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Bovins extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img;/*to get source of image and put it in label*/
	JLabel lab1,lab2,limg;
	JSpinner tf;
	JButton calculer;
	JPanel pan,res;
	SpinnerNumberModel model;
	Font newfont;
	Color nn=new Color(139,69,19),brown=new Color(210,105,30);
	public Bovins()
	{
		this.setBounds(350, 0, 350,320);
		this.setTitle("Calculer Zakat de Bovins");
	
		this.setResizable(false);
		this.setLayout(null);
		newfont =new Font("Arial",Font.BOLD,13);
		lab1=new JLabel("Entrer Votre Nombre De Bovins :");lab1.setForeground(nn);lab1.setFont(newfont);
		lab2=new JLabel("Votre Quorum est : ");
		calculer =new JButton("Calculer Le Quorum");
		
		model = new SpinnerNumberModel(0, 0, 2000000, 1);
		tf=new JSpinner(model);
		res=new JPanel(null);
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(185, 101, 1));
		img=new ImageIcon(this.getClass().getResource("/image/Bovin.png"));
		limg=new JLabel(img);
		
				
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		
		lab1.setBounds(10, 10, 220, 50);
		tf.setBounds(lab1.getWidth()+20, 20,  80, 30);
		calculer.setBounds(100, lab1.getHeight()+20, 150, 50);
		res.setBounds(50, 130, 260, 50);res.setBackground(brown);
		lab2.setBounds(30,5,260,40);lab2.setForeground(Color.WHITE);
		limg.setBounds(20, 180,300,100);
		

		pan.add(lab1);
		pan.add(tf);
		pan.add(calculer);
		pan.add(res);
		res.add(lab2);
		pan.add(limg);
		
		
		calculer.addActionListener(this);
		
		this.add(pan);
		this.setVisible(true);}
	
	public void  actionPerformed(ActionEvent e) {
		if(e.getSource().equals(calculer))
		{
			 if(virifer())
			 {
				 int q=(int) tf.getValue();
				 String c="";
				 if(q>=30 && q<=39)c=("T");
				 else if(q>=40 && q<=59) c=("Mo");
					 else if(q>=60 && q<=69)c=("2T");
						 else if(q>=70 && q<=79)c=("Mo + T");		 
							 else if(q>=80 && q<=89)c=("2Mo");		 
								 else if(q>=90 && q<=99)c=("3T");									 
									 else if(q>=100 && q<=119)c=("Mo +2T");
									 	else if(q>=120 && q<=129)c=("3Mo ou 4T");
									 		else if(q % 40 == 0){q=q/40;c=(q+"Mo");}
									 			else if(q % 30 == 0){q=q/30;c=(q+"T");}
									 				else
											 		{
											 			q=q/10;
											 			int m=q % 4;
											 			int t=(q-m*4)/3;
											 			c=(m+"Mo et "+t+"T");							 			
											 		}
				 lab2.setText("Votre Quorum est : "+c);
			 }
		}}
	public boolean virifer()
	{
		int q=(int) tf.getValue();
		if(q<30)
		{
			JOptionPane.showMessageDialog(null, "Votre Nombre a moin de le quorum =30 Bovins,alors ne répond pas au vulk Zakat");
			return false;
		}
		return true;
		
	}
}
