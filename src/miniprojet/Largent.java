package miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Largent extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*to get source of image and put it in label*/
	JLabel lab1,lab2,g,title;
	static JSpinner tf;
	JButton calculer;
	JPanel pan,res;
	SpinnerNumberModel model;
	Font f,ff;
	Color p=new Color(210,105,30),gr=new Color(218,165,32);
	private double mx=100000000;
	public Largent()
	{
		this.setBounds(300, 300, 350,200);
		this.setTitle("Calculer Zakat de L\'argent");
		this.setResizable(false);
		this.setLayout(null);
		f=new Font("Arial", Font.BOLD, 15);
		ff=new Font("Arial", Font.BOLD, 12);
		title=new JLabel("Calculer Zakat de L\'argent");
		lab1=new JLabel("Entrer Votre Poids D\'or  :");
		title.setFont(f);title.setForeground(p);
		lab2=new JLabel("Votre Quorum est :");lab2.setForeground(p);
		calculer =new JButton("Calculer Le Quorum");
		
		g=new JLabel("grames");
	
		g.setFont(f);
		model = new SpinnerNumberModel(0, 0, mx, 1);
		tf=new JSpinner(model);
		tf.setFont(ff);
		tf.setBackground(Color.BLUE);
		res=new JPanel(new FlowLayout());
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(206, 300, 100));

	
		
				
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		title.setBounds(75, 0, 200, 30);
		lab1.setBounds(10, 15, 200, 50);
		tf.setBounds(lab1.getWidth()-35, title.getY()+27,  80, 30);
		g.setBounds(tf.getX()+tf.getWidth()+5, tf.getY(), 80, 30);
		calculer.setBounds(100, lab1.getHeight()+20, 150, 30);
		res.setBounds(50, calculer.getY()+calculer.getHeight()+5, 240, 45);res.setBackground(gr);
		lab2.setBounds(30,5,260,40);lab2.setForeground(Color.WHITE);
		
		
		pan.add(title);
		pan.add(lab1);
		pan.add(tf);
		pan.add(g);
		pan.add(calculer);
		pan.add(res);
		res.add(lab2);
		
		
		
		calculer.addActionListener(this);
		
		this.add(pan);
		this.setVisible(true);
	}
	
	
	public void  actionPerformed(ActionEvent e) {
		if(e.getSource().equals(calculer))
		{
			if(virifer())
			{
				 
				double lf=(double) tf.getValue();
				lf=lf/40;
				lab2.setText("Votre Quorum est : "+lf+" grames");
				
			}
			
		}}
	public static boolean virifer()
	{
		double lf=(double) tf.getValue();
		if(lf<595)
		{
			JOptionPane.showMessageDialog(null, "Votre Poids a moin de le quorum =595 grames,alors ne répond pas au vulk Zakat");
			return false;
		}
		return true;
		
	}
	

}
