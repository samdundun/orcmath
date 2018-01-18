package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class TestScreen extends FullFunctionScreen {

	private Button b;
	private TextLabel scoreLabel;
	private TextLabel timer;

	private int score;
	private int time;

	public TestScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread();
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		
		timer = new TextLabel(400,100,100,100,"eric");
		viewObjects.add(timer);
		
		b = new Button(300,200,100,100,"Start", new Action() {

			@Override
			public void act() {
				timer.setText("GET READY");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				timer.setText("3");
				/*for(int i = 3; i >-1; i--) {
					timer.setText(Integer.toString(i));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				b.setText("Click me!");

			}
		});
		viewObjects.add(b);

		scoreLabel = new TextLabel(200,100, 100, 100, "Score : " + score);
		viewObjects.add(scoreLabel);

	}

}
