package playground;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	private TextField title;
	private TextField artist;
	private TextField songlength;
	private TextArea text;
	private Button add;
	private Button save;
	private FileOpenButton fileOpen;

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextField(40, 40, 200, 30, "", "Title");
		viewObjects.add(title);
		artist = new TextField(40, 100, 200, 30, "", "Artist");
		viewObjects.add(artist);
		songlength = new TextField(40, 160, 200, 30, "", "Song Length");
		viewObjects.add(songlength);
		text = new TextArea(40,280, 400, 30, "");
		viewObjects.add(text);
		add = new Button(40, 220, 60, 40, "Add",Color.MAGENTA, new Action() {

			@Override
			public void act() {
				addClicked();

			}
		});
		viewObjects.add(add);
		save = new Button(120, 220, 60, 40, "Save",Color.MAGENTA, new Action() {

			@Override
			public void act() {
				addClicked();

			}
		});
		viewObjects.add(save);
		fileOpen = new Button(200, 220, 60, 40, "Open",Color.MAGENTA, new Action() {

			@Override
			public void act() {
				addClicked();

			}
		});
		viewObjects.add(fileOpen);

	}

	protected void addClicked() {
		text.setText(title.getText() + ", " + artist.getText() + ", " + songlength.getText());

	}

}
