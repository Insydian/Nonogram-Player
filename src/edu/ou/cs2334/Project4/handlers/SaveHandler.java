package edu.ou.cs2334.project4.handlers;
/**
 * @author crlar
 */
import edu.ou.cs2334.project4.interfaces.*;
import javafx.event.*;
import javafx.stage.*;

public class SaveHandler extends AbstractBaseHandler implements EventHandler<Event>{

	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window , fileChooser);
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}

}
