package playground;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	private TextField title;
	private TextField author;
	private TextField page;
	private Button create;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextField(40, 40, 200, 30, "", "Title");
		viewObjects.add(title);
		author = new TextField(40, 100, 200, 30, "", "Author");
		viewObjects.add(author);
		page = new TextField(40, 160, 200, 30, "", "Page Number");
		viewObjects.add(page);
		create = new Button(40, 220, 60, 40, "Create",Color.RED, null);
		viewObjects.add(create);

	}

}
