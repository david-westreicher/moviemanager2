package mvcMovieComposite;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GMovieInformationSwing extends javax.swing.JPanel {
	public JLabel jTextField1;
	public JLabel jLabel2;
	public JButton jButton1;
	public JLabel jLabel3;
	public JProgressBar jProgressBar1;
	public JLabel jLabel1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GMovieInformationSwing());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GMovieInformationSwing() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1,0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7,7};
			thisLayout.columnWeights = new double[] {0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7};
		this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jTextField1 = new JLabel();
				this.add(jTextField1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jTextField1.setText("jTextField1");
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setText("jLabel1");
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setText("jLabel2");
			}
			{
				jButton1 = new JButton();
				this.add(jButton1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jButton1.setText("jButton1");
			}
			{
				jProgressBar1 = new JProgressBar();
				this.add(jProgressBar1, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				jLabel3.setText("jLabel3");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
