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

public class IrrigationArthificielle extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img;/*to get source of image and put it in label*/
	JLabel lab1,lab2,limg,kg,title;
	JSpinner tf;
	JButton calculer;
	JPanel pan,res;
	SpinnerNumberModel model;
	Font f,ff;
	Color violet=new Color(148,0,211);
	private double mx=100000000;
	
	public IrrigationArthificielle()
	{
		this.setBounds(0, 400, 350,370);
		this.setTitle("Calculer Zakat de Blé \"Irrigation Arthificielle\"");
		
		this.setResizable(false);
		this.setLayout(null);
		title=new JLabel("Irrigation Arthificielle");
		lab1=new JLabel("Entrer Votre Poids De blé :");
		lab2=new JLabel("Votre Quorum est : ");
		calculer =new JButton("Calculer Le Quorum");
		f=new Font("Arial", Font.BOLD, 18);
		ff=new Font("Arial", Font.BOLD, 12);
		kg=new JLabel("Kg");
	
		kg.setFont(f);
		model = new SpinnerNumberModel(0, 0, mx, 1);
		tf=new JSpinner(model);
		tf.setFont(ff);
		res=new JPanel(null);
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(185, 101, 27));
		img=new ImageIcon(this.getClass().getResource("/image/irrart.png"));
		limg=new JLabel(img);
		
				
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		title.setBounds(80, 0, 200, 30);title.setFont(f);title.setForeground(violet);
		lab1.setBounds(10, 20, 200, 50);
		tf.setBounds(lab1.getWidth()-38, title.getY()+32,  80, 30);
		kg.setBounds(tf.getX()+tf.getWidth()+5, tf.getY(), 30, 30);
		calculer.setBounds(100, lab1.getHeight()+20, 150, 50);
		res.setBounds(50, 130, 260, 50);res.setBackground(Color.ORANGE);
		lab2.setBounds(30,5,260,40);lab2.setForeground(Color.BLACK);
		limg.setBounds(20, 185,300,150);
		
		pan.add(title);
		pan.add(lab1);
		pan.add(tf);
		pan.add(kg);
		pan.add(calculer);
		pan.add(res);
		res.add(lab2);
		pan.add(limg);
		
		
		calculer.addActionListener(this);
		
		this.add(pan);
		this.setVisible(true);
	}
	
	public void  actionPerformed(ActionEvent e) {
		if(e.getSource().equals(calculer))
		{
			if(virifer())
			{
				 
				double q=(double) tf.getValue();
				q=q*0.05;
				lab2.setText("Votre Quorum est : "+q+" Kg");
				
			}
		}}
	public boolean virifer()
	{
		double q=(double) tf.getValue();
		if(q<675)
		{
			JOptionPane.showMessageDialog(null,"Votre Poids a moin de le quorum =675 Kg, alors ne répond pas au vulk Zakat");
			return false;
		}
		return true;
		
	}
	
	

}
