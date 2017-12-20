package playground;

import java.awt.Color;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Button;
import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	private static final long serialVersionUID = 258186143576427947L;
	private TextField title;
	private TextField artist;
	private TextField songlength;
	private TextArea text;
	private Button add;
	private Button save;
	private FileOpenButton open;
	private Catalog c;

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
		songlength.setInputType(TextField.INPUT_TYPE_NUMERIC);
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
		open = new FileOpenButton(200, 220, 60, 40, null,this);
		viewObjects.add(open);

	}

	protected void addClicked() {
		Song s = new Song(title.getText(), artist.getText(), Integer.parseInt(songlength.getText()));
		c.addSong(s);
		text.setText(text.getText()+"\n" + title.getText() + artist.getText() + songlength.getText());
		title.setText("");
		artist.setText("");
		songlength.setText("");

	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
