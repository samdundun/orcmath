package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameSam extends GUIApplication{
	
	private static final long serialVersionUID = 7548071104587737267L;
	
	public static SimonGameSam game;
	public static SimonScreenSam screen;

	public static void main(String[] args) {
		game = new SimonGameSam(800, 500);
		Thread runner = new Thread(game);
		runner.start();
	}
	
	public SimonGameSam(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new SimonScreenSam(getWidth(), getHeight());
		setScreen(screen);
	}

}
