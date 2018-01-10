package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonSam extends Button implements ButtonInterfaceSam {

	public Color color1;
	public Color finalColor;

	public ButtonSam(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, 50, 50, "", Color.BLACK, null);
		update();
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		if(hover) {
			highlight();
			g.setColor(Color.BLACK);
			g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			g.setColor(Color.WHITE);
			g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
		else {
			dim();
			g.setColor(Color.RED);
			g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void setColor(Color color) {
		this.color1 = color;
		this.finalColor = color;

	}

	@Override
	public void dim() {
		this.color1 = this.finalColor;

	}

	@Override
	public void highlight() {
		this.color1 = Color.WHITE;

	}

}
