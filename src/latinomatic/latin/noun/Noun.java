package latinomatic.latin.noun;

import latinomatic.Number;
import latinomatic.latin.Case;
import latinomatic.latin.Word;


public class Noun extends Word{
	private String word;
	private NounEnding ending;
	private String meaning;
	
	public Noun(String wo, NounEnding end, String m) {
		word = wo;
		ending = end;
		meaning = m;
	}
	
	public Case getCase() {
		return ending.getCase();
	}
	
	public boolean isPlural() {
		return ending.isPlural();
	}
	
	public boolean equals(Object other) {
		if (other == null)
			return false;
		return word.equals(((Noun)other).word) && ending.equals(((Noun)other).ending);
	}
	
	public String toString() {
		return "(\"" + String.valueOf(word) + "\"->\"" + meaning + "\", " + String.valueOf(ending) + ")";
	}

	public String getMeaning() {
		return meaning;
	}

	public Number getNumber() {
		return ending.getNumber();
	}
}
