package mvcMovieList;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import movie.Movie;
import mvcMovieManager.CMovieManagerSwing;

public class CMovieListSwing extends CMovieList implements
		ListSelectionListener {
	private JTable gui;
	private AbstractTableModel tableModel;
	private List<Movie> movies;

	public CMovieListSwing(CMovieManagerSwing par) {
		super(par);
		movies = new ArrayList<Movie>();
		tableModel = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;
			private String[] columnNames = new String[] { "Name", "Director",
					"Actors", "IMDB-Rating" };

			public String getColumnName(int col) {
				return columnNames[col].toString();
			}

			@Override
			public int getColumnCount() {
				return columnNames.length;
			}

			@Override
			public int getRowCount() {
				return movies.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				if (rowIndex < movies.size()) {
					Movie m = movies.get(rowIndex);
					switch (columnIndex) {
					case 0:
						return m.getName();
					case 1:
						return m.getDirector();
					case 2:
						return m.getActors();
					case 3:
						return m.getRating();
					}
				}
				return 0.0F;
			}
		};
		gui = new JTable(tableModel);
		gui.getColumnModel().getColumn(3).setCellRenderer(
				new ProgressRenderer());
		gui.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gui.setAutoCreateRowSorter(true);
		gui.getSelectionModel().addListSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane(gui);
		par.getGUI().add(scrollPane, "0,1,f,f");
	}

	@Override
	protected void addMovieComposite(Movie m) {
		movies.add(m);
		tableModel.fireTableDataChanged();
	}

	@Override
	protected void addSimpleComposite(Movie m) {
		movies.add(m);
		tableModel.fireTableDataChanged();
	}

	@Override
	protected void draw(List<Movie> result) {
		movies.clear();
		for (Movie m : result) {
			movies.add(m);
		}
		tableModel.fireTableDataChanged();
	}

	@Override
	protected void resize() {
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int viewRow = gui.getSelectedRow();
		if (viewRow > -1) {
			int modelRow = gui.convertRowIndexToModel(viewRow);
			if (modelRow >= 0 && modelRow < movies.size())
				parent.showMovie(movies.get(modelRow));
		}
	}

	private static class ProgressRenderer extends JProgressBar implements
			TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Float val = (Float) value;
			this.setValue((int) (val * 10));
			return this;
		}

	}

}
