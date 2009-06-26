import latinomatic.Sentence;
import latinomatic.latin.verb.VerbDict;

public class Test {

	public static void main(String[] args) {
		Sentence s = new Sentence("rex reginas pugnat");
		System.out.println(s.translate());
	}
}
