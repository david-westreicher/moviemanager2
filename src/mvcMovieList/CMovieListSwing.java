package mvcMovieList;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import movie.Movie;
import mvcMovieComposite.CMovieCompositeSwing;
import mvcMovieManager.CMovieManagerSwing;

public class CMovieListSwing extends CMovieList {

	private List<CMovieCompositeSwing> comps = new ArrayList<CMovieCompositeSwing>();

	private JList gui;
	private DefaultListModel listmodel;

	public CMovieListSwing(CMovieManagerSwing par) {
		super(par);
		listmodel = new DefaultListModel();
		gui = new JList(listmodel);
		final CMovieListSwing inst = this;
		gui.setCellRenderer(new ListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList arg0, Object o,
					int index, boolean arg3, boolean arg4) {
				if (comps.size() - 1 < index || index < 0 || comps.size() == 0)
					return new CMovieCompositeSwing(inst, (Movie) o).getGui();
				else
					return comps.get(index).getGui();
			}
		});
		JScrollPane scrollPane = new JScrollPane(gui);
		par.getGUI().add(scrollPane, "0,1,f,f");
	}

	@Override
	protected void addMovieComposite(Movie m) {
		listmodel.addElement(m);
		comps.add(new CMovieCompositeSwing(this, m));
	}

	@Override
	protected void addSimpleComposite(Movie m) {
		listmodel.addElement(m);
		comps.add(new CMovieCompositeSwing(this, m));
	}

	@Override
	protected void draw(List<Movie> result) {
		listmodel.clear();
		comps.clear();
		for (Movie m : result) {
			listmodel.addElement(m);
			comps.add(new CMovieCompositeSwing(this, m));
		}
		gui.updateUI();
	}

	@Override
	protected void resize() {
	}

}
