package miniprojet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class Testfram extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	ImageIcon image,agriimg,betailimg,money,gold;
	 JPanel ptop,pdawn,pbetail,pproduitagricole,porarg,pnumerique;
	JLabel backimg,backagriimg,backbetail,backmoney,backgold;
	 JButton bhome,
	bchameaux,bbovins,bovins,/*les button de betail*/
	birrigationnaturelle,birrigationartificielle,/*les button de produit agricoles*/
	bagent,bor,/*les button de or et argent*/
	bnumeraires;/*les button de Numeraires*/
	TitledBorder tbetail,tproduitagricole,torarg,tnumerique;
	Color brown=new Color(210,105,30);
	
	{
		this.setSize(800,700);this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mini Projet IHM :\"Calculer Zakat\" ");
		this.setResizable(false);
		this.setLayout(null);
		brown=new Color(185, 101, 27);
		
		ptop=new JPanel(null);
		pdawn=new JPanel(new FlowLayout());
		
		
		image=new   ImageIcon(this.getClass().getResource("/image/profile.png"));
		agriimg=new   ImageIcon(this.getClass().getResource("/image/ble.png"));
		betailimg=new   ImageIcon(this.getClass().getResource("/image/betail.png"));
		money=new	ImageIcon(this.getClass().getResource("/image/money.png"));
		gold=new	ImageIcon(this.getClass().getResource("/image/gold.png"));
		
		backimg=new JLabel(image);
		backagriimg=new JLabel(agriimg);
		backbetail=new JLabel(betailimg);
		backmoney=new JLabel(money);
		backgold=new JLabel(gold);
		
		pdawn=new JPanel(null);
		
		
		ptop.setBorder(new LineBorder(Color.ORANGE,5,true));
		pdawn.setBorder(new LineBorder(Color.GRAY,5,true));
		
		pbetail         =new JPanel(null);
		pproduitagricole=new JPanel(null);
		porarg          =new JPanel(null);
		pnumerique      =new JPanel(null);
		

		bchameaux=new JButton();
		bbovins=new JButton();
		bovins=new JButton();
	
		//pbetail.setBackground(brown);
		/* TitledBorder de le 4 panel */
		tbetail=BorderFactory.createTitledBorder("Betail");
		tbetail.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		tbetail.setTitleJustification(TitledBorder.CENTER);
		
		tproduitagricole=BorderFactory.createTitledBorder("Produits agricoles");
		tproduitagricole.setBorder(BorderFactory.createLineBorder(brown,5));
		tproduitagricole.setTitleJustification(TitledBorder.CENTER);
		
		torarg=BorderFactory.createTitledBorder("L'or et l'argent");
		torarg.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));
		torarg.setTitleJustification(TitledBorder.CENTER);
		
		tnumerique=BorderFactory.createTitledBorder("Numeraires");
		tnumerique.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
		tnumerique.setTitleJustification(TitledBorder.CENTER);
		
		/******add le boderder factory pour chaque panel*******/
		pbetail.setBorder(tbetail);
		pproduitagricole.setBorder(tproduitagricole);
		porarg.setBorder(torarg);
		pnumerique.setBorder(tnumerique);
		
		
		/*** indefinie les button */
		bchameaux=new JButton("Chameaux");bbovins=new JButton("Bovins");bovins=new JButton("Ovins");
		birrigationnaturelle=new JButton("Irrigation naturelle");birrigationartificielle=new JButton("Irrigation artificielle");
		bagent=new JButton("Argent");bor=new JButton("L'or");
		bnumeraires=new JButton("Numeraires");

		/*panel de image*/
		ptop.setBounds(0, 0, this.getWidth()-15, 240);
		ptop.setBackground(Color.WHITE);
		backimg.setBounds(22,5,740,image.getIconHeight());
		ptop.add(backimg);
		
		/* panel down   */
		
	
		pdawn.setBounds(0,image.getIconHeight()+30,this.getWidth()-15,400);
		
		pbetail.setBounds(40,10 , 350,200 );
		pproduitagricole.setBounds(400, 10,350,200);
		porarg.setBounds(40, 210,350,180);
		pnumerique.setBounds(400,210 , 350, 180);
	
		backbetail.setBounds(0, 3, 350, 200);
		bchameaux.setBounds(125,40, 100, 50);
		bbovins.setBounds(15,120, 100, 50);
		bovins.setBounds(235,120, 100, 50);
		pbetail.add(bchameaux);pbetail.add(bbovins);pbetail.add(bovins);
		pbetail.add(backbetail);
		
		birrigationartificielle.setBounds(100,40, 150, 50);
		birrigationnaturelle.setBounds(100, 120, 150, 50);
		backagriimg.setBounds(5,13,pproduitagricole.getWidth()-10, pproduitagricole.getHeight()-20);
		
		pproduitagricole.add(birrigationartificielle);pproduitagricole.add(birrigationnaturelle);
		pproduitagricole.add(backagriimg);
		
		backgold.setBounds(0, -6, 350, 200);
		bor.setBounds(80,50,80,80);	bagent.setBounds(200,50, 80, 80);
		porarg.add(bor);porarg.add(bagent);
		porarg.add(backgold);
	
		
		
		backmoney.setBounds(0, -6,350, 200);
		bnumeraires.setBounds(120, 50, 120, 80);
		pnumerique.add(bnumeraires);
		pnumerique.add(backmoney);
		
		
		pdawn.add(pbetail);pdawn.add(pproduitagricole);pdawn.add(porarg);pdawn.add(pnumerique);
		
		bbovins.addActionListener(this);
		bchameaux.addActionListener(this);
		bovins.addActionListener(this);
		birrigationnaturelle.addActionListener(this);
		birrigationartificielle.addActionListener(this);
		bagent.addActionListener(this);
		bor.addActionListener(this);
		bnumeraires.addActionListener(this);
		
		this.add(ptop);
		this.add(pdawn);
		
		
		 Dimension windowSize = getSize();
	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	     Point centerPoint = ge.getCenterPoint();
	     int dx = centerPoint.x - windowSize.width / 2;
	     int dy = centerPoint.y - windowSize.height / 2;    
	     this.setLocation(dx, dy);
		this.setVisible(true);}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(bchameaux)) new Chameux();
		else if(e.getSource().equals(bbovins)) new Bovins();
		else if(e.getSource().equals(bovins)) new Ovins();
		else if(e.getSource().equals(birrigationartificielle)) new IrrigationArthificielle();
		else if(e.getSource().equals(birrigationnaturelle)) new IrrigationNaturelle();
		else if(e.getSource().equals(bor)) new Lor();
		else if(e.getSource().equals(bagent)) new Largent();
		else new Numeraires();
		
			
		
	
	}
	
	
	
}


