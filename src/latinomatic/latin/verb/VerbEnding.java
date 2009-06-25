package latinomatic.latin.verb;

import latinomatic.Number;
import latinomatic.Person;
import latinomatic.Tense;
import latinomatic.latin.Conjugation;
import latinomatic.latin.Voice;

public class VerbEnding {	
	private Tense tense;
	private Conjugation conj;
	private Person person;
	private Number number;
	private Voice voice;
	
	public VerbEnding(Tense t, Conjugation c, Person p, Number n, Voice v) {
		tense = t;
		conj = c;
		person = p;
		number = n;
		voice = v;
	}
	
	public Conjugation getConjugation() {
		return conj;
	}
	
	public Tense getTense() {
		return tense;
	}
	
	public String toString() {
		return "Person: " + String.valueOf(person) + ", Number: " + String.valueOf(number) + ", Tense: " + String.valueOf(tense) + ", Voice: " + String.valueOf(voice) + ", Conjugation: " + String.valueOf(conj);
	}

	public Number getNumber() {
		return number;
	}

	public Person getPerson() {
		return person;
	}


}
