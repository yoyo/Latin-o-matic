package latinomatic;

import java.util.ArrayList;

import latinomatic.english.noun.EngNoun;
import latinomatic.english.verb.EngVerb;
import latinomatic.latin.WordCollection;
import latinomatic.latin.noun.Noun;
import latinomatic.latin.verb.Verb;
import latinomatic.Number;

public class Sentence {
	String[] sWords;
	ArrayList<WordCollection> words;
	
	public Sentence(String sentence) {	
		sWords = sentence.split(" ");
		words = new ArrayList<WordCollection>();
		for (int n = 0; n < sWords.length; n++) {
			words.add(new WordCollection(sWords[n]));
		}
	}
	
	public String translate() {
		PartiallyTranslated master = new PartiallyTranslated();
		master.trans();
		
		// TODO: Later it will return every possible translation
		String s = master.result;
		while (master.sub != null) {
			s += " " + master.sub.get(0).result;
			master = master.sub.get(0);
		}
		return s;
	}
	
	public class PartiallyTranslated {
		private ArrayList<WordCollection> translated;
		private String result;
		
		private PartiallyTranslated sup;
		private ArrayList<PartiallyTranslated> sub; 
		
		// To make the initial PartiallyTranslated object
		public PartiallyTranslated() {
			translated = new ArrayList<WordCollection>();
			result = "";
			sup = null;
		}
		
		public PartiallyTranslated(ArrayList<WordCollection> t, PartiallyTranslated superPT) {
			translated = t;
			result = "";
			sup = superPT;
		}
		
		private ArrayList<WordCollection> getUntranslated() {
			ArrayList<WordCollection> all = (ArrayList<WordCollection>) words.clone();
			all.removeAll(translated);
			
			PartiallyTranslated s = sup;
			while (s != null) {
				all.removeAll(s.translated);
				s = s.sup;
			}
			return all;
		}
		
		
		public boolean trans() {
			if (singSubject()) {
				for (PartiallyTranslated pt : sub) {
					if (pt.thirdSingVerb()) {
						for (PartiallyTranslated subPT : pt.sub) {
							subPT.directObj();
						}
					}
				}
			}
			
			return false;
		}

		private boolean directObj() {
			return accNoun();			
		}

		private boolean accNoun() {
			ArrayList<WordCollection> possNouns = new ArrayList<WordCollection>();
			ArrayList<Noun> accNouns = new ArrayList<Noun>();
		
			for (WordCollection word : getUntranslated()) {
				Noun accNoun = word.possiblyAccNoun();
				if (accNoun != null) {
					accNouns.add(accNoun);
					possNouns.add(word);
				}
			}
			
			if (possNouns.size() >= 1) {
				sub = new ArrayList<PartiallyTranslated>();
				for (int i = 0; i < possNouns.size(); i++) {
					ArrayList<WordCollection> arr = new ArrayList<WordCollection>();
					arr.add(possNouns.get(i));
					PartiallyTranslated subPT = new PartiallyTranslated(arr,this);
					subPT.result += EngNoun.transAsDirObj(accNouns.get(i));
					sub.add(subPT);					
				}
				return true;
			} else {
				return false;
			}
		}

		private boolean thirdSingVerb() {
			ArrayList<WordCollection> possVerbs = new ArrayList<WordCollection>();
			ArrayList<Verb> singVerbs = new ArrayList<Verb>();
		
			for (WordCollection word : getUntranslated()) {
				Verb verb = word.possiblyVerb();
				if (verb != null && verb.getNumber() == Number.SING && verb.getPerson() == Person.THIRD) {
					singVerbs.add(verb);
					possVerbs.add(word);
				}
			}
			
			if (possVerbs.size() >= 1) {
				sub = new ArrayList<PartiallyTranslated>();
				for (int i = 0; i < possVerbs.size(); i++) {
					ArrayList<WordCollection> arr = new ArrayList<WordCollection>();
					arr.add(possVerbs.get(i));
					PartiallyTranslated subPT = new PartiallyTranslated(arr,this);
					subPT.result += EngVerb.translate(singVerbs.get(i));
					sub.add(subPT);					
				}
				return true;
			} else {
				return false;
			}
			
		}

		private boolean singSubject() {
			return nomSingNoun();
		}
		
		private boolean nomSingNoun() {
			ArrayList<WordCollection> possNouns = new ArrayList<WordCollection>();
			ArrayList<Noun> nomSingNouns = new ArrayList<Noun>();
		
			for (WordCollection word : getUntranslated()) {
				Noun nomNoun = word.possiblyNomNoun();
				if (nomNoun != null && nomNoun.getNumber() == Number.SING) {
					nomSingNouns.add(nomNoun);
					possNouns.add(word);
				}
			}
			
			if (possNouns.size() >= 1) {
				sub = new ArrayList<PartiallyTranslated>();
				for (int i = 0; i < possNouns.size(); i++) {
					ArrayList<WordCollection> arr = new ArrayList<WordCollection>();
					arr.add(possNouns.get(i));
					PartiallyTranslated subPT = new PartiallyTranslated(arr,this);
					subPT.result += EngNoun.transAsSubject(nomSingNouns.get(i));
					sub.add(subPT);					
				}
				return true;
			} else {
				return false;
			}
		}
		
	}
}
