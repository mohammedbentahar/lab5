package lab5;


import java.util.LinkedList;

public class Lexicographique {


	public LexiNode debut[];
	public int cpt;

	 public Lexicographique() {
		 debut = new LexiNode[26];
		 cpt = 0;
	 }



	 public void ajouteMot(String mot, String definition) {
		 cpt = 0;
		 int pos =  Character.toLowerCase( (int)mot.charAt(0) ) - (int)97;

		 if( debut[ pos ] == null) {
			 debut[pos] = new LexiNode ( mot.charAt(0), mot.substring(0, cpt+1), "");
			 ajouteNouveauMot(debut[pos], mot, definition, ++cpt);
		 }
		 else {
			 findPossitiom(debut[pos], mot, definition, ++cpt);
		 }

	 }


	 public void findPossitiom(LexiNode m1, String mot,String definition, int cpt) {
		 for( int i = 0 ; i<m1.enfant.size(); i++) {
			 if( Character.toLowerCase( mot.charAt(cpt) ) ==  m1.enfant.get(i).lettre ) {

				 if( cpt == mot.length()-1 )
					 m1.enfant.get(i).setDefinition(definition);
				 else
					 findPossitiom(m1.enfant.get(i), mot, definition, ++cpt);
			 }
			 else {
				 ajouteNouveauMot(m1, mot, definition, cpt);
				 return;
			 }
		 }
	 }

	 private void ajouteNouveauMot (LexiNode m1, String mot, String definition, int cpt) {

		 if( cpt < (mot.length()-1) ) {
			 m1.enfant.add(new LexiNode( mot.charAt(cpt), mot.substring(0, cpt+1), "" ) );
			 ///*************************************
			 ajouteNouveauMot(m1.enfant.getLast(), mot, definition, ++cpt);
			 m1.sort();

		 }
		 else{
			 m1.enfant.add(new LexiNode( mot.charAt(cpt), mot.substring(0, cpt+1), definition ) );
			 m1.sort();
		 }
	 }

	 public LinkedList< String > treeToString(){
		 LinkedList< String > data =  new LinkedList< String >();

		 for( int i = 0; i< 26 ;i++){
			 if(debut[i] != null)
				 getData( debut[i], data);
		 }

		return data;
	 }


	 public void getData( LexiNode m ,  LinkedList< String > data ){

		 if( m.definition != "" )
			 data.add(  m.toString() );

		 if( !m.enfant.isEmpty() ){
			 for( int i = 0 ; i < m.enfant.size() ; i++)
				 getData( m.enfant.get(i), data ) ;
		 }



	}


	 public LexiNode  findPos( LinkedList< LexiNode  > m, String mot, int cpt ) {
		for( int i = 0 ; i < m.size() ; i++) {
			if(m.get(i).lettre ==  mot.charAt(cpt) )
				if (findPos( m.get(i).enfant ,  mot , cpt+1) == null)
					return m.get(i);
			else
				return null;
		}
		return null;
	}

}
