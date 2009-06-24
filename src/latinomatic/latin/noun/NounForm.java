package latinomatic.latin.noun;

import latinomatic.Number;
import latinomatic.latin.Case;

public class NounForm {
	private Case kase;
	private Number num;
	
	public NounForm(Case c, Number n) {
		kase = c;
		num = n;
	}
	
	public Case getCase() {
		return kase;
	}
	
	public boolean equals(Object other) {
		if (other == null)
			return false;
		return kase == ((NounForm)other).kase && num == ((NounForm)other).num;
	}
	
	public String toString() {
		return "Case: " + String.valueOf(kase) + ", Number:" + String.valueOf(num);
	}

	public boolean isPlural() {
		return num == Number.PL;
	}

	public Number getNumber() {
		return num;
	}
}
