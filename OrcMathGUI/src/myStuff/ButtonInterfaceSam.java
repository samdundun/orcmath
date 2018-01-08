package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceSam extends Clickable {

	void setColor(Color color);
	void dim();
	void highlight();
}
