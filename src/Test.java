import java.util.Set;

import latinomatic.Sentence;
import latinomatic.latin.noun.Noun;
import latinomatic.latin.noun.NounDict;
import latinomatic.latin.verb.VerbDict;

public class Test {

	public static void main(String[] args) {
		Set<Noun> n = NounDict.lookup("puella");
		System.out.println(n);
		System.out.println(VerbDict.lookup("vocabar"));
	}
}
