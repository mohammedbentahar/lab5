package lab5;

import java.util.Collections;
import java.util.LinkedList;


public class LexiNode {


	 protected char lettre;
	 protected String motCourant;
	 protected  String definition;
	 protected LinkedList< LexiNode > enfant;


	public LexiNode(char lettre, String motCourant , String definition) {

   	 this.lettre = lettre;
   	 this.motCourant = motCourant ;
   	 this. definition =  definition;
   	 this.enfant = new LinkedList< LexiNode >();

     }

   protected void setMotCourant(String motCourant) {
		this.motCourant = motCourant;
	}

   protected void setDefinition(String definition) {
		this.definition = definition;
	}

   protected void addEnfant( LexiNode e) {
   	 this.enfant.add(e);
    }

	 public void sort() {
			Collections.sort(this.enfant, new LexiNodeComparator ());
		}

   @Override
   public String toString(){
	   return( motCourant + " & "+definition);
   }





}
