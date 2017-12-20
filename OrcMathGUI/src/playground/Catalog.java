package playground;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;

public class Catalog {

	private static ArrayList<Song> list;
	private static boolean adding;
	private static boolean running;

	public static Scanner in;

	public Catalog() {
		list = new ArrayList<Song>();

		adding = true;
		running = true;
	}

	public static void main(String[] args) {
		Catalog maker = new Catalog();
		in = new Scanner(System.in);
		maker.menu();

		

		maker.save();

	}

	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	public static String getCSVContent() {
		String data = "";
		for(Song s : list) {
			data+=s + "\n";
		}
		return data;
	}

	private void save() {
		try{    
			FileWriter fw=new FileWriter("SongCatalog.csv");
			for(Song b: list){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"SongCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		list = new ArrayList<Song>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read the file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(", ");
					//add a new Book for each line in the save file
					list.add(new Song(param[0],param[1],Integer.parseInt(param[2])));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}

	private void create() {

		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Songs:\n");
		for(Song b: list){
			displayMessage("   "+b.toString()+"\n");
		}
	}
	
	private static void displayMessage(String message){
		System.out.println(message);
	}
	
	private void add() {
		String title = null;
		String author = null;
		int pages = 0;
		displayMessage("Please enter a title");
		title = getStringInput();
		displayMessage("Please enter an artist");
		author = getStringInput();
		displayMessage("Please enter the song length.");
		pages = getIntegerInput();
		addSong(new Song(title, author, pages));
	}
	
	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}
	
	public void addSong(Song b){
		list.add(b);
	}
	
	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
			text = in.nextLine();
		}
		return value;
	}
	
	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}
	
	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}
}
