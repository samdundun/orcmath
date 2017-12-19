package playground;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {

	private static final long serialVersionUID = -2452328323352199392L;
	
	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		CatalogScreen s = new CatalogScreen(getWidth(), getHeight());
		setScreen(s);

	}

	public static void main(String[] args) {
		CatalogMakerGUI sample = new CatalogMakerGUI(800, 600);
		Thread go = new Thread(sample);
		go.start();

	}

}
