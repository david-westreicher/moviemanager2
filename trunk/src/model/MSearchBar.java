package model;

import java.util.Observable;

import tools.GUIAccess;
import tools.Stoppable;
import tools.StoppableRunnable;

public class MSearchBar extends Observable implements Stoppable {
	protected static final long UPDATE_TIME = 1000;
	private String filterKey;
	private boolean hasChanged = false;
	private StoppableRunnable timer;

	public MSearchBar() {
		filterKey = "";
		timer = new StoppableRunnable() {

			@Override
			public void execute() {
				try {
					Thread.sleep(UPDATE_TIME);
					if (hasChanged) {
						setChanged();
						new GUIAccess() {
							@Override
							protected void execute() {
								notifyObservers();
							}
						};
						hasChanged = false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(timer).start();
	}

	public void filterKeyChanged(String text) {
		this.filterKey = text;
		this.hasChanged = true;
	}

	public String getFilterKey() {
		return this.filterKey;
	}

	public void stop() {
		timer.stop();
	}

}
