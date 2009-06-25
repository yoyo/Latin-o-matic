package latinomatic.latin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import latinomatic.latin.noun.Noun;
import latinomatic.latin.noun.NounDict;
import latinomatic.latin.verb.Verb;
import latinomatic.latin.verb.VerbDict;

public class WordCollection implements Iterable<Word> {
	private HashSet<Noun> possN;
	private HashSet<Verb> possV;
	
	public WordCollection(String s) {
		possN = (HashSet<Noun>)NounDict.lookup(s);
		possV = (HashSet<Verb>)VerbDict.lookup(s);
	}

	public Iterator<Word> iterator() {
		return new IterImp();
	}
	
	public class IterImp implements Iterator<Word> {
		Iterator<Noun> nIter;
		Iterator<Verb> vIter;
		
		public IterImp() {
			nIter = possN.iterator();
			vIter = possV.iterator();
		}
		
		public boolean hasNext() {
			return nIter.hasNext() || vIter.hasNext();
		}

		public Word next() {
			if (nIter.hasNext()) {
				return nIter.next();
			} else if (vIter.hasNext()) {
				return vIter.next();
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	/* If this Word object has a nominitive noun in the noun set,
	 * it returns that noun, otherwise it returns null.
	 */
	// TODO: Both of these next two methods should probably return sets
	public Noun possiblyNomNoun() {
		for (Noun n : possN) {
			if (n.getCase() == Case.NOM)
				return n;
		}
		return null;
	}

	public Verb possiblyVerb() {
		for (Verb v : possV) {
			return v;
		}
		return null;
	}
	
	
}
