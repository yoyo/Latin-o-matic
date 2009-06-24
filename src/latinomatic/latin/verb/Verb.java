package latinomatic.latin.verb;

import latinomatic.latin.Word;

public class Verb extends Word {
	String word;
	VerbEnding ending;
	String engInf;
	
	public Verb(String w, VerbEnding e, String s) {
		word = w;
		ending = e;
		engInf = s;
	}
	
	public String toString() {
		return "(\"" + word + "\"->\"" + engInf +"\", " + String.valueOf(ending) + ")";
	}
}
