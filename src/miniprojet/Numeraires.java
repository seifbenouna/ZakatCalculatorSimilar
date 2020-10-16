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

public class Numeraires extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lab1,lab2,da,title;
	static JSpinner tf;
	JButton calculer;
	JPanel pan,res;
	SpinnerNumberModel model;
	Font f,ff;
	Color p=new Color(210,105,30),gr=new Color(218,165,32);
	
	private final double   sd=12775661640000d;
			
	

	public Numeraires()
	{
		this.setBounds(700, 300, 350,200);
		this.setTitle("Calculer Zakat de Numeraires");
		this.setResizable(false);
		this.setLayout(null);
		f=new Font("Arial", Font.BOLD, 15);
		
		title=new JLabel("Calculer Zakat de Numeraires");
		lab1=new JLabel("Entrer Votre Sommes :");
		title.setFont(f);title.setForeground(p);
		lab2=new JLabel("Votre Quorum est :");
		calculer =new JButton("Calculer Le Quorum");
		
		da=new JLabel("DA");da.setFont(f);

		model = new SpinnerNumberModel(0, 0, sd, 1);
		tf=new JSpinner(model);
		tf.setFont(ff);
		tf.setBackground(Color.BLUE);
		res=new JPanel(new FlowLayout());
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(206, 300, 100));
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		title.setBounds(75, 0, 250, 30);
		lab1.setBounds(10, 15, 200, 50);
		tf.setBounds(lab1.getWidth()-35, title.getY()+27,  135, 30);
		da.setBounds(tf.getX()+tf.getWidth()+5, tf.getY(), 80, 30);
		calculer.setBounds(100, lab1.getHeight()+20, 150, 30);
		res.setBounds(30, calculer.getY()+calculer.getHeight()+5, 270, 50);res.setBackground(gr);
		lab2.setBounds(30,5,260,40);lab2.setForeground(Color.WHITE);
		
		
		pan.add(title);
		pan.add(lab1);
		pan.add(tf);
		pan.add(da);
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
				double cin=(double) tf.getValue();
				cin=cin*0.025;
				lab2.setText("Votre Quorum est : "+cin+" DA");
			}	  
		}
		}
	
	public boolean virifer()
	{
		double c=(double) tf.getValue();
		if(c  < 552500)
		{
			JOptionPane.showMessageDialog(null, "Votre Sommes a moin de le quorum =552500 DA,alors ne répond pas au vulk Zakat");
			return false;
		}
		return true;
		
	}
	
	
	

}
