package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonSam extends Button implements ButtonInterfaceSam {

	public Color color;
	public Color finalColor;

	public ButtonSam(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, 35, 35, "", Color.BLACK, null);
		update();
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		if(hover) {
			highlight();
			g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
		else {
			dim();
			g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		this.finalColor = color;

	}

	@Override
	public void dim() {
		this.color = this.finalColor;

	}

	@Override
	public void highlight() {
		this.color = this.color.brighter();

	}

}
