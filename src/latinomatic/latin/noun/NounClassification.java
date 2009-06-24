package latinomatic.latin.noun;

import latinomatic.latin.Declension;
import latinomatic.latin.Gender;

public class NounClassification {
	Gender gend;
	Declension decl;
	
	public NounClassification(Gender g, Declension d) {
		gend = g;
		decl = d;
	}
	
	public boolean equals(Object other) {
		if (other == null) 
			return false;
		return gend == ((NounClassification)other).gend && decl == ((NounClassification)other).decl;
	}
	
	public String toString() {
		return "Gender: " + String.valueOf(gend) + ", Declension: " + String.valueOf(decl);
	}
}
