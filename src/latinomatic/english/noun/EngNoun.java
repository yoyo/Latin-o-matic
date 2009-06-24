package latinomatic.english.noun;

import latinomatic.latin.noun.Noun;

public class EngNoun {
	public static String defArticle(String word) {
		return "the " + word;
	}
	
	public static String pluralize(String word) {
		return word + "s"; // I know
	}

	public static String transAsSubject(Noun noun) {
		if (noun.isPlural()) {
			return pluralize(noun.getMeaning());
		} else {
			return noun.getMeaning();
		}
	}
}
