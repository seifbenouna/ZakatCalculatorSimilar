package miniprojet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Lor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*to get source of image and put it in label*/
	JLabel lab1,lab2,title,g;
	JSpinner tf;
	JButton calculer;
	JPanel panradio,pan,res;
	SpinnerNumberModel model;
	Font f,ff;
	JRadioButton c1,c2,c3;
	ButtonGroup group;
	Color p=new Color(210,105,30),gr=new Color(218,165,32);
	private double mx=100000000;
	
	public Lor()
	{
		this.setBounds(0, 300, 300,200);
		this.setTitle("Calculer Zakat de L\'or");
		
		this.setResizable(false);
		this.setLayout(null);
		f=new Font("Arial", Font.BOLD, 15);
		title=new JLabel("Selectioner le carats de votre \"Or\"");title.setFont(f);title.setForeground(p);
		lab1=new JLabel("Entrer Votre Poids D\'or  :");
		lab2=new JLabel("Votre Quorum est :");lab2.setForeground(Color.WHITE);
		calculer =new JButton("Calculer Le Quorum");
		
		
		model = new SpinnerNumberModel(0, 0,mx , 1);
		tf=new JSpinner(model);
		tf.setFont(ff);
		g=new JLabel("grames");
	
		res=new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan=new JPanel(null);pan.setBackground(Color.getHSBColor(206, 300, 100));
		
		
		panradio=new JPanel(new FlowLayout());
		c1=new JRadioButton("24 carats");
		c2=new JRadioButton("21 carats");
		c3=new JRadioButton("18 carats");
		group=new ButtonGroup();
		
		title.setBounds(20, 0,250, 30);
		
		group.add(c1);	    group.add(c2);	   group.add(c3);
		panradio.add(c1);	panradio.add(c2);  panradio.add(c3);	
		panradio.setBackground(Color.GREEN);
		panradio.setBounds(20, 30, 260, 35);
		
		pan.setBounds(0,0,this.getWidth(),this.getHeight());
		lab1.setBounds(panradio.getX()-15, panradio.getY()+panradio.getHeight()+5, 180, 30);
		tf.setBounds(lab1.getX()+lab1.getWidth()-25, panradio.getY()+panradio.getHeight()+5, 80, 30);
		g.setBounds(tf.getX()+tf.getWidth()+5, tf.getY()+3, 50,20);
		calculer.setBounds(panradio.getX()+30, lab1.getY()+lab1.getHeight()+5, 150, 25);
		res.setBounds(20, calculer.getY()+calculer.getHeight()+5, 250, 30);res.setBackground(gr);
		
		
		calculer.addActionListener(this);
		
		pan.add(title);
		pan.add(panradio);
		pan.add(lab1);
		pan.add(tf);
		pan.add(g);
		pan.add(calculer);
		res.add(lab2);
		pan.add(res);
		this.add(pan);
		this.setVisible(true);
	}
	
	public void  actionPerformed(ActionEvent e) {
		if(e.getSource().equals(calculer))
		{
			if(selected()&&virifer()){
				double q=(double) tf.getValue();
				q=q/40;
				lab2.setText("Votre Quorum est :"+q+" grames");
			}	
		}}
	public boolean virifer()
	{
		double q=(double) tf.getValue();
		if(c1.isSelected())
		{
			if(q<85){
			JOptionPane.showMessageDialog(null, "Votre Poids a moin de le quorum =85 grames(24 carates),alors ne répond pas au vulk Zakat");
			return false;}
		}
		else if(c2.isSelected())
		{
			if(q<97){
			JOptionPane.showMessageDialog(null, "Votre Poids a moin de le quorum =95 grames(21 carates),alors ne répond pas au vulk Zakat");
				return false;}
		}
		else if(c3.isSelected())
		{
			if(q<113){
			JOptionPane.showMessageDialog(null, "Votre Poids a moin de le quorum =113 grames(18 carates),alors ne répond pas au vulk Zakat");
				return false;}
		}
		return true;
		
	}
	public boolean selected()
	{
		if(c1.isSelected()|c2.isSelected()|c3.isSelected())
		return true;
		else{
		JOptionPane.showMessageDialog(null, "selectioner quel carate de votre \"OR\"");
		return false;}
		
	}
	
}
