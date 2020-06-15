package lab5;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {


			Lexicographique l1 = new  Lexicographique();
			l1.ajouteMot("banane", " rien a dire ");
			l1.ajouteMot("mohammed", " rien a dire ");
			l1.ajouteMot("ju", " rien a dire ");
			l1.ajouteMot("bANque", " rien a dire ");
			l1.ajouteMot("ban", " rien a dire ");
			l1.ajouteMot("bab", " rien a dire ");
			l1.ajouteMot("babe", " rien a dire ");
			File.writeFile(l1.treeToString());

			//l1=File.readFile();
			//System.out.println(l1.treeToString().toString());


	}

}
