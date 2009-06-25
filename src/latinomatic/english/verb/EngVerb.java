/* Adapted from the Nodebox Python linguistics libraries:
 * http://nodebox.net/code/index.php/Linguistics
 */

package latinomatic.english.verb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import latinomatic.Person;
import latinomatic.Number;
import latinomatic.Tense;
import latinomatic.VerbForm;
import latinomatic.latin.verb.Verb;

public class EngVerb {
	private static HashMap<String,String[]> verbTenses;
	
//    "infinitive"           : 0,
//    "1st singular present" : 1,
//    "2nd singular present" : 2,
//    "3rd singular present" : 3,
//    "present plural"       : 4,
//    "present participle"   : 5,
//    "1st singular past"    : 6,
//    "2nd singular past"    : 7,
//    "3rd singular past"    : 8,
//    "past plural"          : 9,
//    "past"                 : 10,
//    "past participle"      : 11
    
	private static HashMap<String,String> verbLemmas;
	static {
		verbTenses = new HashMap<String,String[]>();
		verbLemmas = new HashMap<String,String>();
		try {
			Scanner scan = new Scanner(new File("EngVerbDict.txt"));
			while (scan.hasNextLine()) {
				String[] tenses = scan.nextLine().split(",");
				verbTenses.put(tenses[0], tenses);
			}
			
			for (String infinitive : verbTenses.keySet()) {
				for (String tense : verbTenses.get(infinitive)) {
					if (tense != "")
						verbLemmas.put(tense, infinitive);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String toInfinitive(String v) {
		return verbLemmas.get(v);
	}
	
	public static String changeForm(String v, VerbForm f, Person p, Number n, Tense t) {
		if (f == VerbForm.INFINITIVE) {
			return v;
		} else if (f == VerbForm.FINITE) {
			if (t == Tense.PRES) {
				return toPresent(v,p,n);
			} else if (t == Tense.IMPERF) {
				return toPast("be", p, n) + " "+ toPresentParticiple(v);
			} else if (t == Tense.FUT) {
				return "will " + toInfinitive(v);
			} else if (t == Tense.PERF) {
				return toPast(v,p,n);
			} else if (t == Tense.PLUPERF) {
				return "had " + toPastParticiple(v);
			} else /* FUTPERF */{
				// should I even bother with 'shall' vs. 'will'
				return "will have " + toPastParticiple(v);
			}
		} else /* PARTICIPLE */ {
			// TODO: participles and gerundives
			return null;
		}

	}
	
	public static String toPresent(String v, Person p, Number n) {
		String[] tenses = verbTenses.get(v);
		if (tenses == null)
			return null;
		String desiredTense;
		if (n == Number.SING) {
			if (p == Person.FIRST) {
				desiredTense = tenses[1];
			} else if (p == Person.SECOND) {
				desiredTense = tenses[2];
			} else {
				desiredTense = tenses[3];
			}
		} else {
			desiredTense = tenses[4];
		}
		
		if (!desiredTense.equals("")) {
			return desiredTense;
		} else {
			return tenses[0]; //infinitive
		}
	}
	
	public static String toPresentParticiple(String v) {
		String[] tenses = verbTenses.get(v);
		if (tenses == null)
			return null;
		return tenses[5];
	}
	
	public static String toPast(String v, Person p, Number n) {
		String[] tenses = verbTenses.get(v);
		if (tenses == null)
			return null;
		String desiredTense;
		if (n == Number.SING) {
			if (p == Person.FIRST) {
				desiredTense = tenses[6];
			} else if (p == Person.SECOND) {
				desiredTense = tenses[7];
			} else {
				desiredTense = tenses[8];
			}
		} else {
			desiredTense = tenses[9];
		}
		
		if (!desiredTense.equals("")) {
			return desiredTense;
		} else {
			return tenses[10];
		}
	}
	
	public static String toPastParticiple(String v) {
		String[] tenses = verbTenses.get(v);
		if (tenses == null)
			return null;
		return tenses[11];
	}

	public static String translate(Verb verb) {
		return changeForm(verb.getMeaning(),VerbForm.FINITE,verb.getPerson(),verb.getNumber(),verb.getTense());
	}
	
	
}
