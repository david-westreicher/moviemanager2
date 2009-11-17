package mvcMovieComposite;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import info.clearthought.layout.TableLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GMovieCompositeSwing extends javax.swing.JPanel {
	public JLabel jLabel1;
	public GMovieInformationSwing gMovieInformationSwing1;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GMovieCompositeSwing());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public GMovieCompositeSwing() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			TableLayout thisLayout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.FILL} });
			thisLayout.setHGap(0);
			thisLayout.setVGap(0);
			this.setPreferredSize(new Dimension(500, 150));
			this.setLayout(thisLayout);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, "0,0,l,c");
				jLabel1.setPreferredSize(new Dimension(99,140));
			}
			{
				gMovieInformationSwing1 = new GMovieInformationSwing();
				this.add(gMovieInformationSwing1, "1,0,f,f");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
