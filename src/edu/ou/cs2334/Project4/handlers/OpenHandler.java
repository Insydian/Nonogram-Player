package edu.ou.cs2334.project4.handlers;
/**
 * @author crlar
 */
import java.io.File;



import edu.ou.cs2334.project4.interfaces.Openable;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.*;
public class OpenHandler extends AbstractBaseHandler implements EventHandler<Event>   {

	private Openable opener;

	public OpenHandler(Window window , FileChooser fileChooser, Openable opener)
	{
		super(window , fileChooser);
		this.opener = opener;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
