package latinomatic.latin.verb;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import latinomatic.Number;
import latinomatic.Person;
import latinomatic.Tense;
import latinomatic.latin.Conjugation;
import latinomatic.latin.Voice;

public class VerbDict {
	private static HashMap<String, VerbEnding> exceptions;
	private static HashMap<String,ConjAndMeaning> presentStems;
	private static HashMap<String,String> perfStems;
	private static HashMap<String,VerbEnding[]> endings;
	
	static {
		endings = new HashMap<String,VerbEnding[]>();

//Active
//Present
		endings.put("o", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("as", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("at", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("amus", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("atis", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("ant", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
		endings.put("s", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("t", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("mus", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("tis", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("nt", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.ACTIVE)});

		endings.put("is", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("it", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.PERF,null,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("imus", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("itis", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("unt", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.ACTIVE)});
	
// Imperfect
		endings.put("abam", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("abas", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("abat", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("abamus", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("abatis", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("abant", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
		endings.put("bam", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("bas", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("bat", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("bamus", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("batis", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("bant", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
		endings.put("ebam", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("ebas", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("ebat", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("ebamus", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("ebatis", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("ebant", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.ACTIVE)});

		
//Future
		endings.put("abo", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("abis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("abit", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("abimus", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("abitis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("abunt", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
		endings.put("bo", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("bis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("bit", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("bimus", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("bitis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("bunt", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
		endings.put("am", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("es", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("et", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("emus", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("etis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("ent", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.ACTIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
//	Perfect
		endings.put("i", new VerbEnding[] {
			new VerbEnding(Tense.PERF,null,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("isti", new VerbEnding[] {
			new VerbEnding(Tense.PERF,null,Person.SECOND,Number.SING,Voice.ACTIVE)});
		// "it" is also a third conjugation ending
		//endings.put("it", new VerbEnding[] {
		//	new VerbEnding(Tense.PERF,null,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("imus", new VerbEnding[] {
			new VerbEnding(Tense.PERF,null,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("istis", new VerbEnding[] {
			new VerbEnding(Tense.PERF,null,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("erunt", new VerbEnding[] {
			new VerbEnding(Tense.PERF,null,Person.THIRD,Number.PL,Voice.ACTIVE)});
		
//	Pluperfect		
		endings.put("eram", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("eras", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("erat", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("eramus", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("eratis", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("erant", new VerbEnding[] {
			new VerbEnding(Tense.PLUPERF,null,Person.THIRD,Number.PL,Voice.ACTIVE)});

//	Future Perfect
		endings.put("ero", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.FIRST,Number.SING,Voice.ACTIVE)});
		endings.put("eris", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.SECOND,Number.SING,Voice.ACTIVE)});
		endings.put("erit", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.THIRD,Number.SING,Voice.ACTIVE)});
		endings.put("erimus", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.FIRST,Number.PL,Voice.ACTIVE)});
		endings.put("eritis", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.SECOND,Number.PL,Voice.ACTIVE)});
		endings.put("erint", new VerbEnding[] {
			new VerbEnding(Tense.FUTPERF,null,Person.THIRD,Number.PL,Voice.ACTIVE)});
	
//Passive
//Present
		endings.put("or", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("aris", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("atur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("amur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("amini", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("antur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.PASSIVE)});
		
		endings.put("ris", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("tur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("mur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("mini", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("ntur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.PASSIVE)});

		endings.put("eris", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("itur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("imur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("imini", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("untur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.PASSIVE)});

		endings.put("untur", new VerbEnding[] {
			new VerbEnding(Tense.PRES,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.PASSIVE)});
	
//	Imperfect
		endings.put("abar", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("abaris", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("abatur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("abamur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("abamini", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("abantur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.PASSIVE)});
		
		endings.put("bar", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("baris", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("batur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("bamur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("bamini", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("bantur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.PASSIVE)});
		
		endings.put("ebar", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("ebaris", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("ebatur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("ebamur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("ebamini", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("ebantur", new VerbEnding[] {
			new VerbEnding(Tense.IMPERF,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.IMPERF,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.PASSIVE)});

//	Future
		endings.put("abor", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("aberis", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("abitur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("abimur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("abimini", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("abuntur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.FIRST,Person.THIRD,Number.PL,Voice.PASSIVE)});
		
		endings.put("bor", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("beris", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("bitur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("bimur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("bimini", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("buntur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.SECOND,Person.THIRD,Number.PL,Voice.PASSIVE)});
		
		endings.put("ar", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.FIRST,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.FIRST,Number.SING,Voice.PASSIVE)});
		endings.put("eris", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.SECOND,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.SECOND,Number.SING,Voice.PASSIVE)});
		endings.put("etur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.THIRD,Number.SING,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.THIRD,Number.SING,Voice.PASSIVE)});
		endings.put("emur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.FIRST,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.FIRST,Number.PL,Voice.PASSIVE)});
		endings.put("emini", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.SECOND,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.SECOND,Number.PL,Voice.PASSIVE)});
		endings.put("entur", new VerbEnding[] {
			new VerbEnding(Tense.FUT,Conjugation.THIRD,Person.THIRD,Number.PL,Voice.PASSIVE),
			new VerbEnding(Tense.FUT,Conjugation.FOURTH,Person.THIRD,Number.PL,Voice.PASSIVE)});
	
		
		// TODO: All exceptions, not just "to be" verbs should be
		// put in a file or something.
		exceptions = new HashMap<String,VerbEnding>();
		exceptions.put("sum", new VerbEnding(Tense.PRES,null,Person.FIRST,Number.SING,Voice.ACTIVE));
		exceptions.put("es", new VerbEnding(Tense.PRES,null,Person.SECOND,Number.SING,Voice.ACTIVE));
		exceptions.put("est", new VerbEnding(Tense.PRES,null,Person.THIRD,Number.SING,Voice.ACTIVE));
		exceptions.put("sumus", new VerbEnding(Tense.PRES,null,Person.FIRST,Number.PL,Voice.ACTIVE));
		exceptions.put("estis", new VerbEnding(Tense.PRES,null,Person.SECOND,Number.PL,Voice.ACTIVE));
		exceptions.put("sunt", new VerbEnding(Tense.PRES,null,Person.THIRD,Number.PL,Voice.ACTIVE));

		
		presentStems = new HashMap<String,ConjAndMeaning>();
		perfStems = new HashMap<String,String>();
		

		
		
		
		try {
			Scanner fileScanner = new Scanner(new File("VerbDict.txt"));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				
				String firstPP = lineScanner.next();
				//String secondPP = lineScanner.next();
				String thirdPP = lineScanner.next();
				String fourthPP = lineScanner.next();
				Conjugation c = Conjugation.valueOf(lineScanner.next());
				String meaning = lineScanner.next();
				
				presentStems.put(firstPP, new ConjAndMeaning(c,meaning));
				perfStems.put(thirdPP, meaning);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static Set<Verb> lookup(String word) {
		HashSet<Verb> verbs = new HashSet<Verb>();
		Set<String> sEndings = possibleStringEndings(word);
		
		for (String sEnding : sEndings) {
			String stem = removeEnd(sEnding.length(), word);
			for (VerbEnding vEnding : endings.get(sEnding)) {
				// checks pres,imperf,fut endings
				if (!isPerfect(vEnding.getTense()) && presentStems.get(stem) != null) {
					if (vEnding.getConjugation() == presentStems.get(stem).getConjugation())
						verbs.add(new Verb(word, vEnding, presentStems.get(stem).getMeaning()));
				}
				
				// checks perf,pluperf,futperf endings
				if (isPerfect(vEnding.getTense()) && perfStems.get(stem) != null) {
					verbs.add(new Verb(word, vEnding, perfStems.get(stem)));
				}
			}
		}
		
		if (exceptions.containsKey(word)) {
			verbs.add(new Verb(word, exceptions.get(word),"be"));
		}
		return verbs;
	}
	
	private static boolean isPerfect(Tense t) {
		return t == Tense.PERF || t == Tense.PLUPERF || t == Tense.FUTPERF;
	}
	
	private static Set<String> possibleStringEndings(String s) {
		HashSet<String> ends = new HashSet<String>();
		
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
	
	private static class ConjAndMeaning {
		private Conjugation conj;
		private String meaning;
		
		public ConjAndMeaning(Conjugation c, String m) {
			conj = c;
			meaning = m;
		}
		
		public Conjugation getConjugation() {
			return conj;
		}
		
		public String getMeaning() {
			return meaning;
		}		
	}
}