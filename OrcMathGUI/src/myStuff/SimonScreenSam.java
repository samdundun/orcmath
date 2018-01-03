package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSam extends ClickableScreen implements Runnable {

	private static final long serialVersionUID = 7548071104587737267L;
	
	TextLabel t;
	ButtonInterfaceSam[] b;
	ProgressInterfaceSam p;
	ArrayList<MoveInterfaceSam> a;
	
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenSam(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceSam b: b){ 
		    viewObjects.add(b); 
		}
		p = getProgress();
		t = new TextLabel(130,230,300,40,"Let's play Simon!");
		a = new ArrayList<MoveInterfaceSam>();
		//add 2 moves to start
		lastSelectedButton = -1;
		a.add(randomMove());
		a.add(randomMove());
		roundNumber = 0;
		viewObjects.add(p);
		viewObjects.add(t);

	}

	private void addButtons() {
		int numberOfButtons = 6;
		b = new ButtonInterfaceSam[numberOfButtons];
		Color[] c = new Color[numberOfButtons];
		for(int i = 0; i < c.length; i++) {
			c[i] = new Color(i*40, i*20, i*10);
		}
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceSam button = getAButton();
			button.setColor(c[i]);
			button.setX(x);
			b[i] = button;
		}
		
	}
	
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/

	private ButtonInterfaceSam getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	private MoveInterfaceSam randomMove() {
		int bIndex = (int)(Math.random()*b.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*b.length);
	    }
	    return getMove(bIndex);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/

	private MoveInterfaceSam getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 * @return
	 */
	
	private ProgressInterfaceSam getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

}
