package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressSam extends Component implements ProgressInterfaceSam {

	public int round;
	public int sequenceSize;
	
	public ProgressSam(int x, int y, int w, int h) {
		super(200, 150, 400, 200);
	}
	
	@Override
	public void gameOver() {
		

	}

	@Override
	public void setRound(int i) {
		this.round = i;

	}

	@Override
	public void setSequenceSize(int i) {
		this.sequenceSize = i;

	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString("Round: " + this.round, this.getX(), this.getX());

	}

}
