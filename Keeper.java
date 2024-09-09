package daniel_gerbi_natanel_michel7;

import java.util.ArrayList;
import java.util.List;

public class Keeper {
	private List<StoreMemento> savedStates = new ArrayList<>();
	private int currentState = -1;

	public void saveState(StoreFacade storeFacade) {
		while (savedStates.size() > currentState + 1) {
			savedStates.remove(savedStates.size() - 1);
		}
		savedStates.add(storeFacade.saveToMemento());
		currentState = savedStates.size() - 1;
	}

	public void restoreState(StoreFacade storeFacade, int index) {
		if (index >= 0 && index < savedStates.size()) {
			storeFacade.restoreMemento(savedStates.get(index));
			currentState = index;
		}
	}
}
