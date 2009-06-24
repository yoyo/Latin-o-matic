package latinomatic.latin.noun;

import latinomatic.Number;
import latinomatic.latin.Case;
import latinomatic.latin.Declension;
import latinomatic.latin.Gender;

public class NounEnding {
	private NounForm nf;
	private NounClassification nc;
	
	public NounEnding(NounForm form, NounClassification classification) {
		nf = form;
		nc = classification;
	}
	
	public NounEnding(Case c, Number n, Gender g, Declension d) {
		nf = new NounForm(c, n);
		nc = new NounClassification(g, d);
	}
	
	public Case getCase() {
		return nf.getCase();
	}

	public NounClassification getNounClassification() {
		return nc;
	}
	
	public boolean equals(Object other) {
		return nf.equals(((NounEnding)other).nf) && nc.equals(((NounEnding)other).nc);
	}
	
	public String toString() {
		return String.valueOf(nf) + ", " + String.valueOf(nc);
	}

	public boolean isPlural() {
		return nf.isPlural();
	}

	public Number getNumber() {
		return nf.getNumber();
	}
}
