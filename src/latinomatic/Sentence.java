package latinomatic;

import java.util.ArrayList;

import latinomatic.english.noun.EngNoun;
import latinomatic.latin.WordCollection;
import latinomatic.latin.noun.Noun;
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
		trans();
		
		return null;
	}
	
	public class PartiallyTranslated {
		//Perhaps a HashSet could be used instead...
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
		
		public ArrayList<WordCollection> getUntranslated() {
			ArrayList<WordCollection> all = (ArrayList<WordCollection>) words.clone();
			all.removeAll(translated);
			
			PartiallyTranslated s = sup;
			while (s != null) {
				all.removeAll(s.translated);
			}
			return all;
		}
		
		
		private boolean trans() {
			singSubject(); singVerb(); object();
				for (int i = 0; i < sub.size(); i++){
					sub.get(i).mainTransitiveVerb(singOrPlural.get(i));
					
					if (object())
						return true;
				}
			}
			return false;
		}
		
		private boolean mainTransitiveVerb(Number n) {
			
			return false;
		}

		private boolean singSubject() {
			return nomSingNoun();		
		}
		
		private boolean nomSingNoun() {
			ArrayList<WordCollection> possNouns = new ArrayList<WordCollection>();
			ArrayList<Noun> nomNouns = new ArrayList<Noun>();
			for (WordCollection word : getUntranslated()) {
				Noun nomNoun = word.possiblyNomNoun();
				if (nomNoun != null) {
					nomNouns.add(nomNoun);
					possNouns.add(word);
				}
			}
			if (possNouns.size() >= 1) {
				ArrayList<Number> singOrPlural = new ArrayList<Number>();
				
				sub = new ArrayList<PartiallyTranslated>();
				for (int i = 0; i < possNouns.size(); i++) {
					ArrayList<WordCollection> arr = new ArrayList<WordCollection>();
					arr.add(possNouns.get(i));
					PartiallyTranslated subPT = new PartiallyTranslated(arr,this);
					subPT.result += " " + EngNoun.transAsSubject(nomNouns.get(i));
					sub.add(subPT);
					
					singOrPlural.add(nomNouns.get(i).getNumber());					
				}
				return singOrPlural;
			} else {
				return null;
			}
			
		}
		
	}
}
