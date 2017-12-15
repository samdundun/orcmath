package playground;

import java.util.ArrayList;

public class Catalog {

	private static ArrayList<Song> list;
	
	public Catalog() {
		list = new ArrayList<Song>();
		list.add(new Song("TT", "Twice", 180));
		list.add(new Song("Ooh-Ahh", "Twice", 180));
		list.add(new Song("Cheer Up", "Twice", 180));
		list.add(new Song("Heart Shaker", "Twice", 180));
	}

	public static void main(String[] args) {
		Catalog c = new Catalog();
		
		System.out.println(c.getCSVContent());

	}

	public String getCSVContent() {
		String data = "";
		for(Song s : list) {
			data+=s + "\n";
		}
		return data;
	}
}
