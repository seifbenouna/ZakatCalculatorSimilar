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


public class Chameux extends JFrame implements ActionListener {

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
	 
	private int mx=2000000;
	
	public Chameux()
	{
		this.setBounds(0, 0, 350,320);
		this.setTitle("Calculer Zakat de Chameux");
	
		this.setResizable(false);
		this.setLayout(null);
		newfont =new Font("Arial",Font.BOLD,13);
		lab1=new JLabel("Entrer Votre Nombre De Chameux :");lab1.setForeground(nn);lab1.setFont(newfont);
		lab2=new JLabel("Votre Quorum est : ");
		calculer =new JButton("Calculer Le Quorum");

		model = new SpinnerNumberModel(0, 0, mx, 1);
		tf=new JSpinner(model);
		res=new JPanel(null);
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(185, 101, 1));
		img=new ImageIcon(this.getClass().getResource("/image/caml.PNG"));
		limg=new JLabel(img);
		
				
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		
		lab1.setBounds(10, 10, 230, 50);
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
				 if(q>=5 && q<=25){
					 q=q/5;
					 c=(q+"C");
				 }
				 else if(q>=25 && q<=35) c=("M");
					 else if(q>=36 && q<=45)c=("L");
						 else if(q>=46 && q<=60)c=("H");		 
							 else if(q>=61 && q<=75)c=("J");		 
								 else if(q>=76 && q<=90)c=("2L");									 
									 else if(q>=91 && q<=129)c=("2H");
									 	else if(q % 50 == 0){q=q/50;c=(q+"H");}
									 		else if(q % 40 == 0){q=q/40;c=(q+"L");}
									 		else
									 		{
									 			q=q/10;
									 			int h=q % 4;
									 			int l=(q-h*5)/4;
									 			c=(h+"H et "+l+"L");
									 			
									 		}
				 
				 
				 lab2.setText("Votre Quorum est : "+c);
			 }
		}}
	
	
	public boolean virifer()
	{
		int q=(int) tf.getValue();
		if(q<5)
		{
			JOptionPane.showMessageDialog(null, "Votre Nombre a moin de le quorum =5 Chameux,alors ne répond pas au vulk Zakat");
			return false;
		}
		return true;
	}
	

}


