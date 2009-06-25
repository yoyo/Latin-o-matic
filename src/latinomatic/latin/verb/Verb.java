package latinomatic.latin.verb;

import latinomatic.Number;
import latinomatic.Person;
import latinomatic.Tense;
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

	public Number getNumber() {
		return ending.getNumber();
	}
	
	public String getMeaning() {
		return engInf;
	}

	public Person getPerson() {
		return ending.getPerson();
	}

	public Tense getTense() {
		return ending.getTense();
	}
}
