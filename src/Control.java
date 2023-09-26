import javax.swing.*;
import java.util.*;

public class Control
{
	ArrayList<Object> objectTable;
	ControlPanel parent;
	int xValue, yValue;
	
	public Control(ControlPanel parent)
	{
		this.parent = parent;
		objectTable = new ArrayList<Object>();
		xValue = parent.getSpriteX();
		yValue = parent.getSpriteY();
	}
	
	public void updateSprite()
	{
		xValue = parent.getSpriteX();
		yValue = parent.getSpriteY();
		if (xValue >= 500)
			xValue = 500;
		if (xValue < 0)
			xValue = 0;
		if (yValue >= 500)
			yValue = 500;
		if (yValue < 0)
			yValue = 0;
		parent.setSprite(xValue, yValue);
	}
}
