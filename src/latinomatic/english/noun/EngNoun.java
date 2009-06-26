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
			return "The " + pluralize(noun.getMeaning());
		} else {
			return "The " + noun.getMeaning();
		}
	}

	public static String transAsDirObj(Noun noun) {
		if (noun.isPlural()) {
			return "the " + pluralize(noun.getMeaning());
		} else {
			return "the " + noun.getMeaning();
		}
	}
}
