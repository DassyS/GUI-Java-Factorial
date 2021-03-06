
//Dassy Stenge

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Factorial extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 100;
	private JTextField xBox; // user entry
	private JTextField xfBox; // generated factorial
	private JButton btn= new JButton("Factorial");

	public Factorial() {
		setTitle("Factorial Calculator");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
	}

	private void createContents(){
		JLabel xLabel = new JLabel ("x:");
		JLabel xfLabel = new JLabel ("x!:");
		Listener listener = new Listener();
		KeyListener keyListener= new KeyListener();

		xBox = new JTextField(2);
		xfBox = new JTextField(10);
		xfBox.setEditable(false);
		add(xLabel);
		add(xBox);
		add(xfLabel);
		add(xfBox);
		add(btn);
		btn.setEnabled(false);
		xBox.addKeyListener(keyListener);
		btn.addActionListener(listener);
	}
	private class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int x;
			int xf;
			if (e.getSource()==xBox){
				JOptionPane.showMessageDialog(null, "Click factorial button to perform calculation.");
			}
			else{
				try{
					x=Integer.parseInt(xBox.getText());
				}
				catch(NumberFormatException nfe){
					x=-1;
				}
				if (x<0){
					xfBox.setText("undefined");
				}
				else{
					if(x==0||x==1){
						xf=1;
					}
					else{
						xf=1;
						for(int i=2; i<=x; i++){
							xf *=i;
						}
					}//end else
					xfBox.setText(Integer.toString(xf));
				}//end else
			}
		}
	}//end of listener class

	private class KeyListener extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			btn.setEnabled(true);
		}
	}//end of KeyListener class


	public static void main(String[] args) {
		new Factorial();
	}
}
