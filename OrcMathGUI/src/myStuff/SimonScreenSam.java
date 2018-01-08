package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
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
		t.setText("");
		nextRound();

	}
	
	public void nextRound() {
		acceptingInput = false;
		roundNumber++;

		MoveInterfaceSam moveInterface = randomMove();
		a.add(moveInterface);

		p.setRound(roundNumber);
		p.setSequenceSize(a.size());
		changeText("Simon's turn");
		t.setText("");
		playSequence();

		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void playSequence() {
		ButtonInterfaceSam b = null;
		for(int i = 0; i < a.size(); i++) {
			if(b != null) {
				b.dim();
				b = a.get(i).getButton();
				b.highlight();
				int sleepTime = getTime();
				Thread sleep = new Thread(new Runnable(){
					public void run(){
						try {
							Thread.sleep(sleepTime);
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				sleep.start();
			}
		}
		b.dim();
	}

	public int getTime() {
		if(1500 + (roundNumber * -100) <= 0)
			return 100;
		return 1500 + (roundNumber * -100);
	}

	public void changeText(String s) {
		Thread text = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		text.start();
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
			final ButtonInterfaceSam button = getAButton();
			button.setColor((Color)c[i]);
			button.setX((i*100)+ 50);
			button.setY(100);
			button.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								button.highlight();
								try {
									Thread.sleep(800);
								}catch (InterruptedException e) {
									e.printStackTrace();
								}
								button.dim();
							}
						});
						blink.start();
						if(button == a.get(sequenceIndex).getButton())
							sequenceIndex++;
						else 
							gameOver();
						if(sequenceIndex == a.size()){ 
							Thread nextRound = new Thread(SimonScreenSam.this); 
							nextRound.start(); 
						}
					}
				}

				private void gameOver() {
					// TODO Auto-generated method stub
					
				}
			});
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
