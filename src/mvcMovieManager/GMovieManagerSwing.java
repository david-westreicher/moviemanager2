package mvcMovieManager;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class GMovieManagerSwing extends javax.swing.JFrame implements
		IGMovieManager {

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GMovieManagerSwing inst = new GMovieManagerSwing();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public GMovieManagerSwing() {
		super("MovieManager");
		initGUI();
	}

	private void initGUI() {
		try {
			this.setBounds(0, 0, 600, 800);
			this.setSize(600, 800);
			this.setMinimumSize(new Dimension(600, 800));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			TableLayout thisLayout = new TableLayout(
					new double[][] {
							{ TableLayout.FILL },
							{ TableLayout.PREFERRED, TableLayout.FILL,
									TableLayout.FILL } });
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
