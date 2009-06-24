package latinomatic.latin.noun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import latinomatic.Number;
import latinomatic.latin.Case;
import latinomatic.latin.Declension;
import latinomatic.latin.Gender;

public class NounDict {
	private static HashMap<String,ExceptionEntry> exceptions;
	private static HashMap<String,StemEntry> stems;
	private static HashMap<String, NounEnding[]> endings;
	
	static {
		endings = new HashMap<String, NounEnding[]>();
		
		endings.put("a", new NounEnding[]{
			new NounEnding(Case.NOM,			//femina
						   Number.SING, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.ABL,			//feminA
						   Number.SING,
						   Gender.F,
						   Declension.FIRST),
			new NounEnding(Case.NOM,			//nauta 
						   Number.SING, 
						   Gender.M, 
						   Declension.FIRST),
			new NounEnding(Case.ABL,			//nautA
						   Number.SING,
						   Gender.M,
						   Declension.FIRST),
			new NounEnding(Case.NOM,			//auxilia
						   Number.PL, 
						   Gender.N, 
						   Declension.SECOND),
			new NounEnding(Case.ACC,			//auxilia
						   Number.PL,
						   Gender.N,
						   Declension.SECOND),
			new NounEnding(Case.NOM,			//vulnera
						   Number.PL, 
						   Gender.N, 
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//vulnera
						   Number.PL,
						   Gender.N,
						   Declension.THIRD)});
		
		endings.put("ae", new NounEnding[]{
			new NounEnding(Case.GEN,			//feminae
						   Number.SING, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.DAT,			//feminae
						   Number.SING,
						   Gender.F,
						   Declension.FIRST),
			new NounEnding(Case.NOM,			//feminae
						   Number.PL,
						   Gender.F,
						   Declension.FIRST),
			new NounEnding(Case.GEN,			//nautae
						   Number.SING, 
						   Gender.M, 
						   Declension.FIRST),
			new NounEnding(Case.DAT,			//nautae
						   Number.SING,
						   Gender.M,
						   Declension.FIRST),
			new NounEnding(Case.NOM,			//nautae
						   Number.PL,
						   Gender.M,
						   Declension.FIRST)});
		
		endings.put("am", new NounEnding[]{
			new NounEnding(Case.ACC,			//feminam
						   Number.SING, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.ACC,			//nautam
						   Number.SING, 
						   Gender.M, 
						   Declension.FIRST)});
		
		endings.put("arum", new NounEnding[]{
			new NounEnding(Case.GEN,			//feminArum
						   Number.PL, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.GEN,			//nautArum
						   Number.PL, 
						   Gender.M, 
						   Declension.FIRST)});
		
		endings.put("is", new NounEnding[]{
			new NounEnding(Case.DAT,			//feminIs
						   Number.PL, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.ABL,			//feminIS
						   Number.PL, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.DAT,			//nautIs
						   Number.PL, 
						   Gender.M, 
						   Declension.FIRST),
			new NounEnding(Case.ABL,			//nautIs
						   Number.PL, 
						   Gender.M, 
						   Declension.FIRST),
			new NounEnding(Case.DAT,			//servIs
						   Number.PL, 
						   Gender.M, 
						   Declension.SECOND),
			new NounEnding(Case.ABL,			//servIs
						   Number.PL, 
						   Gender.M, 
						   Declension.SECOND),
			new NounEnding(Case.DAT,			//auxiliIs
						   Number.PL, 
						   Gender.N, 
						   Declension.SECOND),
			new NounEnding(Case.ABL,			//auxiliIs
						   Number.PL, 
						   Gender.N, 
						   Declension.SECOND),
			new NounEnding(Case.GEN,			//regis
						   Number.SING,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.GEN,			//lucis
						   Number.SING,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.GEN,			//vulneris
						   Number.SING,
						   Gender.N,
						   Declension.THIRD)});
		
		endings.put("as", new NounEnding[]{
			new NounEnding(Case.ACC,			//feminAs
						   Number.PL, 
						   Gender.F, 
						   Declension.FIRST),
			new NounEnding(Case.ACC,			//nautAs
						   Number.PL, 
						   Gender.M, 
						   Declension.FIRST)});
		
		endings.put("us", new NounEnding[]{
			new NounEnding(Case.NOM,			//servus
						   Number.SING,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.NOM,			//portus
						   Number.SING,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.NOM,			//manus
						   Number.SING,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.GEN,			//portUs
						   Number.SING,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.GEN,			//manUs
						   Number.SING,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.GEN,			//genUs
						   Number.SING,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.NOM,			//portUs
						   Number.PL,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.NOM,			//manUs
						   Number.PL,
						   Gender.F,
						   Declension.FOURTH)});
		
		endings.put("i", new NounEnding[]{
			new NounEnding(Case.GEN,			//servI
						   Number.SING,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.GEN,			//auxiliI
						   Number.SING,
						   Gender.N,
						   Declension.SECOND),
			new NounEnding(Case.NOM,			//servI
						   Number.PL,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.DAT,			//regI
						   Number.SING,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.DAT,			//lucI
						   Number.SING,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.DAT,			//vulnerI
						   Number.SING,
						   Gender.N,
						   Declension.THIRD)});
		
		endings.put("o", new NounEnding[]{
			new NounEnding(Case.DAT,			//servO
						   Number.SING,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.DAT,			//auxiliO
						   Number.SING,
						   Gender.N,
						   Declension.SECOND),
			new NounEnding(Case.ABL,			//servO
						   Number.SING,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.ABL,			//auxiliO
						   Number.SING,
						   Gender.N,
						   Declension.SECOND)});
		
		endings.put("um", new NounEnding[]{
			new NounEnding(Case.NOM,			//auxilium
						   Number.SING,
						   Gender.N,
						   Declension.SECOND),
			new NounEnding(Case.ACC,			//servum
						   Number.SING,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.ACC,			//auxilium
						   Number.SING,
						   Gender.N,
						   Declension.SECOND),
			new NounEnding(Case.GEN,			//regum
						   Number.PL,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.GEN,			//lucum
						   Number.PL,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.GEN,			//vulnerum
						   Number.PL,
						   Gender.N,
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//portum
						   Number.SING,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.ACC,			//manum
						   Number.SING,
						   Gender.F,
						   Declension.FOURTH)});
		
		endings.put("orum", new NounEnding[]{
			new NounEnding(Case.GEN,			//servOrum
						   Number.PL,
						   Gender.M,
						   Declension.SECOND),
			new NounEnding(Case.GEN,			//auxiliOrum
						   Number.PL,
						   Gender.N,
						   Declension.SECOND)});

		endings.put("os", new NounEnding[]{
			new NounEnding(Case.ACC,			//servOs
						   Number.PL,
						   Gender.M,
						   Declension.SECOND)});
		
		endings.put("em", new NounEnding[]{
			new NounEnding(Case.ACC,			//regem
						   Number.SING,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//lucem
						   Number.SING,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//diem
						   Number.SING,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.ACC,			//rem
						   Number.SING,
						   Gender.F,
						   Declension.FIFTH)});
		
		endings.put("e", new NounEnding[]{
			new NounEnding(Case.ABL,			//rege
						   Number.SING,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//luce
						   Number.SING,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//luce
						   Number.SING,
						   Gender.N,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//diE
						   Number.SING,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.ABL,			//rE
						   Number.SING,
						   Gender.F,
						   Declension.FIFTH)});
		
		endings.put("es", new NounEnding[]{
			new NounEnding(Case.NOM,			//regEs
						   Number.PL,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.NOM,			//lucEs
						   Number.PL,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//regEs
						   Number.PL,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.ACC,			//lucEs
						   Number.PL,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.NOM,			//diEs
						   Number.SING,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.NOM,			//rEs
						   Number.SING,
						   Gender.F,
						   Declension.FIFTH),
			new NounEnding(Case.NOM,			//diEs
						   Number.PL,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.NOM,			//rEs
						   Number.PL,
						   Gender.F,
						   Declension.FIFTH),
			new NounEnding(Case.ACC,			//diEs
						   Number.PL,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.ACC,			//rEs
						   Number.PL,
						   Gender.F,
						   Declension.FIFTH)});
		
		endings.put("ibus", new NounEnding[]{
			new NounEnding(Case.DAT,			//regibus
						   Number.PL,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.DAT,			//lucibus
						   Number.PL,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.DAT,			//vulneribus
						   Number.PL,
						   Gender.N,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//regibus
						   Number.PL,
						   Gender.M,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//lucibus
						   Number.PL,
						   Gender.F,
						   Declension.THIRD),
			new NounEnding(Case.ABL,			//vulneribus
						   Number.PL,
						   Gender.N,
						   Declension.THIRD),
			new NounEnding(Case.DAT,			//portibus
						   Number.PL,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.DAT,			//manibus
						   Number.PL,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.DAT,			//genibus
						   Number.PL,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.ABL,			//portibus
						   Number.PL,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.ABL,			//manibus
						   Number.PL,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.ABL,			//genibus
						   Number.PL,
						   Gender.N,
						   Declension.FOURTH)});
		
		endings.put("ui", new NounEnding[]{
			new NounEnding(Case.DAT,			//portuI
						   Number.SING,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.DAT,			//manuI
						   Number.SING,
						   Gender.F,
						   Declension.FOURTH)});

		endings.put("u", new NounEnding[]{
			new NounEnding(Case.ABL,			//portU
						   Number.SING,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.DAT,			//manU
						   Number.SING,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.NOM,			//genU
						   Number.SING,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.DAT,			//genU
						   Number.SING,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.ACC,			//genU
						   Number.SING,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.ABL,			//genU
						   Number.SING,
						   Gender.N,
						   Declension.FOURTH)});
		
		endings.put("uum", new NounEnding[]{
			new NounEnding(Case.GEN,			//portuum
						   Number.PL,
						   Gender.M,
						   Declension.FOURTH),
			new NounEnding(Case.GEN,			//manuum
						   Number.PL,
						   Gender.F,
						   Declension.FOURTH),
			new NounEnding(Case.GEN,			//genuum
						   Number.PL,
						   Gender.N,
						   Declension.FOURTH)});
		
		endings.put("uum", new NounEnding[]{
			new NounEnding(Case.NOM,			//genua
						   Number.PL,
						   Gender.N,
						   Declension.FOURTH),
			new NounEnding(Case.ACC,			//manua
						   Number.PL,
						   Gender.N,
						   Declension.FOURTH)});
		
		endings.put("ei", new NounEnding[]{
			new NounEnding(Case.GEN,			//diEI
						   Number.SING,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.GEN,			//reI
						   Number.SING,
						   Gender.F,
						   Declension.FIFTH),
			new NounEnding(Case.DAT,			//diEI
						   Number.SING,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.DAT,			//reI
						   Number.SING,
						   Gender.F,
						   Declension.FIFTH)});
		
		endings.put("erum", new NounEnding[]{
			new NounEnding(Case.GEN,			//diErum
						   Number.PL,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.GEN,			//rEnua
						   Number.PL,
						   Gender.F,
						   Declension.FIFTH)});
		
		endings.put("ebus", new NounEnding[]{
			new NounEnding(Case.DAT,			//diEbus
						   Number.PL,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.DAT,			//rEbus
						   Number.PL,
						   Gender.F,
						   Declension.FIFTH),
			new NounEnding(Case.ABL,			//diEbus
						   Number.PL,
						   Gender.M,
						   Declension.FIFTH),
			new NounEnding(Case.ABL,			//rEbus
						   Number.PL,
						   Gender.F,
						   Declension.FIFTH)});
		
		
		exceptions = new HashMap<String,ExceptionEntry>();
		stems = new HashMap<String,StemEntry>();
		
		try {
			Scanner fileScanner = new Scanner(new File("NounDict.txt"));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
 
				String first = lineScanner.next();
				String second = lineScanner.next();
				String stem = first;
				Gender g;
				// If the second string is lower case, then the first string 
				// is an exception and the second string is the stem.
				// Ex: rex,reg,M,THIRD
				if (second.equals(second.toLowerCase())) {
					stem = second;
					g = Gender.valueOf(lineScanner.next());
				} else {
					g = Gender.valueOf(second);
				}
				Declension d = Declension.valueOf(lineScanner.next());
				String meaning = lineScanner.next();
				
				// If first is an exception
				if (second == stem) {
					HashSet<NounEnding> exSet = new HashSet<NounEnding>();
					exSet.add(new NounEnding(Case.NOM,Number.SING,g,d));
					if (g == Gender.N) {
						exSet.add(new NounEnding(Case.ACC,Number.SING,g,d));
					}				
					exceptions.put(first, new ExceptionEntry(exSet, meaning));
				}
				stems.put(stem, new StemEntry(new NounClassification(g,d),meaning));

				lineScanner.close();
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// TODO: Does not work fully with exception words like puer, vir, etc.
	// Thinks puerus and virus are valid.
	public static Set<Noun> lookup(String word) {
		HashSet<Noun> nouns = new HashSet<Noun>();
		Set<String> sEnds = possibleStringEndings(word);
		
		for (String sEnd : sEnds) {
			String wordStem = removeEnd(sEnd.length(), word);
			
			for (NounEnding nEnd : endings.get(sEnd)) {
				if (stems.containsKey(wordStem) && nEnd.getNounClassification().equals(stems.get(wordStem).getNounClassification()))
					nouns.add(new Noun(word, nEnd, stems.get(wordStem).getMeaning()));
			}
		}
		
		// Checks if this word is an exception.
		if (exceptions.containsKey(word)) {
			for (NounEnding e : exceptions.get(word).getEndings()) {
				nouns.add(new Noun(word, e, exceptions.get(word).getMeaning()));
			}
		}
		return nouns;
	}
	
	private static Set<String> possibleStringEndings(String s) {
		Set<String> ends = new HashSet<String>();
		
		for (String a : endings.keySet()) {
			if (endsWith(a, s))
				ends.add(a);
		}
		return ends;
	}
	
	private static boolean endsWith(String end, String word) {
		if (end.length() >= word.length())
			return false;
		else 
			return word.substring(word.length()-end.length()).equals(end);
	}
	
	private static String removeEnd(int endLen, String word) {
		return word.substring(0, word.length()-endLen);
	}
	
	private static class ExceptionEntry {
		private Set<NounEnding> nEnds;
		private String meaning;
		
		public ExceptionEntry(Set<NounEnding> ne, String m) {
			nEnds = ne;
			meaning = m;
		}
		
		public Set<NounEnding> getEndings() {
			return nEnds;
		}
		
		public String getMeaning() {
			return meaning;
		}
	}
	
	private static class StemEntry {
		private NounClassification nClass;
		private String meaning;
		
		public StemEntry(NounClassification nc, String m) {
			nClass = nc;
			meaning = m;
		}
		
		public NounClassification getNounClassification(){
			return nClass;
		}
		
		public String getMeaning() {
			return meaning;
		}
	}
}
