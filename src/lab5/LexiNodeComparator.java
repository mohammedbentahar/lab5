package lab5;

import java.util.Comparator;

public class LexiNodeComparator implements Comparator<LexiNode> {


	@Override
	public int compare(LexiNode arg0, LexiNode arg1) {
		return Character.compare( Character.toLowerCase(arg0.lettre) , Character.toLowerCase(arg1.lettre)) > 0 ? 1 :
				Character.compare( Character.toLowerCase(arg0.lettre) , Character.toLowerCase(arg1.lettre)) < 0 ? -1 : 0 ;
	}
}
