package myStuff;

import java.awt.Color;

import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceSam extends Clickable {

	void setColor(Color color);
	void setAction(Action a);
	void dim();
	void highlight();
}
