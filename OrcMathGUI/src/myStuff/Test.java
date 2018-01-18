package myStuff;

import guiPlayer.Sampler;
import guiPlayer.Sampler.SampleScreen;
import guiTeacher.GUIApplication;

public class Test extends GUIApplication {

	public Test(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		TestScreen s = new TestScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		Test sample = new Test(800, 600);
		Thread go = new Thread(sample);
		go.start();
	}

}
