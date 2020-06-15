package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.LinkedList;


// read and write file
abstract class File {

	protected static Lexicographique readFile() throws IOException{
		Lexicographique dico = new Lexicographique();
		LinkedList< String > data = new LinkedList< String > ();
		FileReader myFile = new FileReader("DictioExemple.txt");
		String line = null;

		BufferedReader bufferedReader = new BufferedReader(myFile);

		while((line = bufferedReader.readLine()) != null) {
			int index = line.indexOf('&');
			dico.ajouteMot( line.substring(0,index-1) ,line.substring(index+1,line.length()-1) );
        }
		bufferedReader.close();

		return dico;
	}

	protected static void writeFile( LinkedList< String > data ) throws IOException{
		FileWriter myFile = new FileWriter("dictionnaire.txt");

		data.forEach( d ->{
			  try {
					myFile.write(d);
					myFile.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		  });
		myFile.close();
	}




}
