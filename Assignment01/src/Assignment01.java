import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Assignment01 extends JFrame implements ActionListener{//extended JFrame for using GUI and implemented ActionListener for actions
	/*
	 * ----------------------------------------------------
	 Defined objects for using in design part.
	 */
	private JLabel lblSelect, lblBev, lblNumber,lblAdd;
	private JButton btnAdd, btnOrder;
	private JTextField txtHowMany;
	private JComboBox<String> cmbSize;
	private JRadioButton rbJuice,rbWater,rbTea,rbCoffee;
	private ButtonGroup btnGrp;//button group is for selecting only one radio button. It doesn't allow more than one selection
	
	/*
	 * ----------------------------------------------------------------
	 * defined 2 arraylist one is for the names of the beverages and the other one is for prices
	 */
	ArrayList<String> arrStr = new ArrayList<String>();
	ArrayList<Double> arrPrc = new ArrayList<Double>();
	
	
	public Assignment01() {//constructor
		setLayout(null);//set null layout. It means locations will be determined by myself
		
		/*
		 * -------------------------------------------------------------
		 * defined all objects with sizes and locations
		 */
		lblSelect = new JLabel("Select Size:");
		lblSelect.setSize(100,100);
		lblSelect.setLocation(80, 20);
		add(lblSelect);
		
		lblBev = new JLabel("Select which type of beverage you want to order:");
		lblBev.setSize(300,100);
		lblBev.setLocation(80, 80);
		add(lblBev);
		
		lblNumber = new JLabel("Select how many glasses you want to order:");
		lblNumber.setSize(300,100);
		lblNumber.setLocation(80, 130);
		add(lblNumber);
		
		lblAdd = new JLabel("You added");
		lblAdd.setSize(300,100);
		lblAdd.setLocation(80, 280);
		lblAdd.setVisible(false);
		add(lblAdd);
		
		btnAdd = new JButton("Add");
		btnAdd.setSize(100,50);
		btnAdd.setLocation(80, 250);
		add(btnAdd);
		
		btnOrder = new JButton("Order");
		btnOrder.setSize(100,50);
		btnOrder.setLocation(280, 250);
		add(btnOrder);
		
		txtHowMany = new JTextField();
		txtHowMany.setSize(300, 30);
		txtHowMany.setLocation(80, 200);
		add(txtHowMany);
		
		cmbSize = new JComboBox<String>();
		cmbSize.addItem("Small");
		cmbSize.addItem("Medium");
		cmbSize.addItem("Large");
		cmbSize.setSize(100,20);
		cmbSize.setLocation(80, 90);
		add(cmbSize);
		
		rbJuice = new JRadioButton("Juice");
		rbJuice.setSize(60,20);
		rbJuice.setLocation(80, 140);
		add(rbJuice);
		
		rbWater = new JRadioButton("Water");
		rbWater.setSize(60,20);
		rbWater.setLocation(160, 140);
		add(rbWater);
		
		rbTea = new JRadioButton("Tea");
		rbTea.setSize(50,20);
		rbTea.setLocation(240, 140);
		add(rbTea);
		
		rbCoffee = new JRadioButton("Coffee");
		rbCoffee.setSize(65,20);
		rbCoffee.setLocation(320, 140);
		add(rbCoffee);
		/*
		 * ---------------------------------------
		 * defined all objects up.
		 */
		
		/*
		 * radio buttons added to button group. button group's purpose explained up.
		 */
		btnGrp = new ButtonGroup();
		btnGrp.add(rbJuice);
		btnGrp.add(rbWater);
		btnGrp.add(rbTea);
		btnGrp.add(rbCoffee);
		
		
		
		
		/*
		 * -----------------------------------------------------
		 * set size visibility and title of the window
		 */
		
		setSize(600, 600);
		setVisible(true);
		setTitle("Assignment01");
		
		
		/*
		 * ---------------------------------------------------
		 * added actionlistener for using in actionPerformed method
		 */
		
		btnOrder.addActionListener(this);
		btnAdd.addActionListener(this);
		txtHowMany.addActionListener(this);
		cmbSize.addActionListener(this);
		rbCoffee.addActionListener(this);
		rbJuice.addActionListener(this);
		rbTea.addActionListener(this);
		rbWater.addActionListener(this);
		lblAdd.addAncestorListener(null);
	}
	
	
	public static void main(String[] args) {//main method.
		new Assignment01();//called the constructor
	}


	@Override
	public void actionPerformed(ActionEvent e) {//implemented actionListener's method
		
		if (e.getSource().equals(btnAdd)) {//if add button has been clicked...
			errors();//call errors class and do inside
			txtHowMany.setText("");//reset processes
			cmbSize.setSelectedIndex(0);//reset processes
			btnGrp.clearSelection();//reset processes
		}
		else if (e.getSource().equals(btnOrder)) {//if order button has been clicked...
			
			prices();//call prices method and do inside
		}
		
		
		
	}
	
	
	
	public void prices() {//this method works when clicked to order button
		
		if (arrStr.isEmpty()) {//if string array is empty...
			JOptionPane.showMessageDialog(this, "Make selection.");//show window and say "make selection"
		}
		else {//if string array is not empty...
			String warner = "";//initializing
			double price = 0;
			
			for (int i = 0; i < arrStr.size(); i++) {//get all elements of arraylist
				warner = warner + arrStr.get(i) + " - " + arrPrc.get(i).toString() +"\n";//writing names of the products and prices in warner
				price = price + arrPrc.get(i);//calculating total price
			}
			
			JOptionPane.showMessageDialog(this, warner);//show products and prices
			JOptionPane.showMessageDialog(this, "You'll pay "+price);//show total price
		}
		
	}
	
	public void errors() {//could be written in actionPerformed method but I preferred to write in another method.
		
		
		try {//try catch for errors
			//initializing of the prices
			double sOrangeJuice = 6;
			double sAppleJuice = 10;
			double sPineAppleJuice = 12;
			double mOrangeJuice = 8;
			double mAppleJuice = 12;
			double mPineAppleJuice = 16;
			double lOrangeJuice = 10;
			double lAppleJuice = 14;
			double lPineAppleJuice = 20;
			double sWater = 2;
			double sTea = 3.5;
			double sCoffee = 10;
			double mWater = 3;
			double mTea = 5;
			double mCoffee = 15;
			double lWater = 4;
			double lTea = 6;
			double lCoffee = 20;
			double ice = 0.5;
			double sugar = 1;
			double milk = 4;
			
			int glasses =Integer.parseInt(txtHowMany.getText().trim());//number of the glasses converted to int
			if (rbJuice.isSelected() || rbCoffee.isSelected() || rbTea.isSelected() || rbWater.isSelected()) {//if any radio button selected...
				if (rbJuice.isSelected()) {//if juice has selected...
					
					String[] juices = {"Apple","Orange","Pineapple"};//array for juice types
					String j = (String)JOptionPane.showInputDialog(this,"Select a fruit.","Select a fruit",JOptionPane.QUESTION_MESSAGE,null,juices,juices[0]);//Input
					lblAdd.setVisible(true);

					lblAdd.setText(glasses+" glass(es) of "+j+" juice added ("+cmbSize.getSelectedItem()+")");//set text
					if (j.equals("Apple")) {//if apple has chosen in combobox...
						arrStr.add("Apple Juice ("+glasses+")");//add products' arraylist
						if (cmbSize.getSelectedIndex() == 0) {//if 0th index of combobox selected...(small)
							arrPrc.add(sAppleJuice * glasses);//small price times glasses added to price arraylist
						}
						else if (cmbSize.getSelectedIndex() == 1) {//if 1st index of combobox selected...(medium)
							arrPrc.add(mAppleJuice * glasses);//medium price times glasses added to price arraylist
						}
						else {//if 2nd index of combobox selected...(large)
							arrPrc.add(lAppleJuice * glasses);//large price times glasses added to price arraylist
						}
						
					}
					/*
					 * ------------------------------------------------
					 * same things with apple up.
					 */
					else if (j.equals("Orange")) {
						arrStr.add("Orange Juice ("+glasses+")");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add(sOrangeJuice * glasses);
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add(mOrangeJuice * glasses);
						}
						else {
							arrPrc.add(lOrangeJuice * glasses);
						}
					}
					else if (j.equals("Pineapple")) {
						arrStr.add("Pineapple Juice ("+glasses+")");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add(sPineAppleJuice * glasses);
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add(mPineAppleJuice * glasses);
						}
						else {
							arrPrc.add(lPineAppleJuice * glasses);
						}
					}
					
				}
				else if (rbWater.isSelected()) {//if radio button water has selected...
					int data = JOptionPane.showConfirmDialog(this, "Would you like ice?","Ice",JOptionPane.YES_NO_CANCEL_OPTION );//you wanna ice? yes?no?
					if (data == 0) {//If YES chosen...
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of water added ("+cmbSize.getSelectedItem()+" + ice)");
						arrStr.add("Water ("+glasses+" + ice)");//add product arraylist
						if (cmbSize.getSelectedIndex() == 0) {//Small
							arrPrc.add((sWater * glasses) + (glasses * ice));//added price in price arraylist
						}
						else if (cmbSize.getSelectedIndex() == 1) {//medium
							arrPrc.add((mWater * glasses) + (glasses * ice));
						}
						else {//large
							arrPrc.add((lWater * glasses) + (glasses * ice));
						}
					}
					else if (data == 1) {//if NO chosen
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of water added ("+cmbSize.getSelectedItem()+" + No ice)");
						arrStr.add("Water ("+glasses+")");
						if (cmbSize.getSelectedIndex() == 0) {//small
							arrPrc.add(sWater * glasses);
						}
						else if (cmbSize.getSelectedIndex() == 1) {//medium
							arrPrc.add(mWater * glasses);
						}
						else {//large
							arrPrc.add(lWater * glasses);
						}
					}
					
				}
				
				/*
				 * --------------------------------------------------------------
				 * Water's logic is same with tea and coffee, the difference is: in tea there is sugar instead of ice, in coffee
				 * there is milk instead of ice. That's why I'm not writing comment on them.
				 * 
				 */
				else if (rbTea.isSelected()) {
					int data = JOptionPane.showConfirmDialog(this, "Would you like sugar?","Sugar",JOptionPane.YES_NO_CANCEL_OPTION);
					if (data == 0) {
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of tea added ("+cmbSize.getSelectedItem()+" + sugar)");
						arrStr.add("Tea ("+glasses+" + ice)");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add((sTea * glasses) + (glasses * sugar));
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add((mTea * glasses) + (glasses * sugar));
						}
						else {
							arrPrc.add((lTea * glasses) + (glasses * sugar));
						}
					}
					else if (data == 1) {
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of tea added ("+cmbSize.getSelectedItem()+" + No sugar)");
						arrStr.add("Tea ("+glasses+")");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add(sTea * glasses);
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add(mTea * glasses);
						}
						else {
							arrPrc.add(lTea * glasses);
						}
					}
				}
				else if (rbCoffee.isSelected()) {
					int data = JOptionPane.showConfirmDialog(this, "Would you like milk?","Milk",JOptionPane.YES_NO_CANCEL_OPTION);
					if (data == 0) {
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of coffee added ("+cmbSize.getSelectedItem()+" + milk)");
						arrStr.add("Coffee ("+glasses+" + milk)");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add((sCoffee * glasses) + (glasses * milk));
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add((mCoffee * glasses) + (glasses * milk));
						}
						else {
							arrPrc.add((lCoffee * glasses) + (glasses * milk));
						}
					}
					else if (data == 1) {
						lblAdd.setVisible(true);
						lblAdd.setText(glasses+" glass(es) of coffee added ("+cmbSize.getSelectedItem()+" + No milk)");
						arrStr.add("Coffee ("+glasses+")");
						if (cmbSize.getSelectedIndex() == 0) {
							arrPrc.add(sCoffee * glasses);
						}
						else if (cmbSize.getSelectedIndex() == 1) {
							arrPrc.add(mCoffee * glasses);
						}
						else {
							arrPrc.add(lCoffee * glasses);
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Select beverage and amount","Error!",JOptionPane.ERROR_MESSAGE);//Exception Option Pane
		}
		
		
		}
			
	}
	
	
	

