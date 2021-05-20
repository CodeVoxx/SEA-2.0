// *****************
// **   SEA-2.0   **
// **    Main     ** 
// *****************



package de.telekom.sea2;

public class Main {

	public static void main(String[] args) {        // -> die Main - classe (Start-Klasse) wird in der pom.xml defniert!
		SeminarApp seminarApp = new SeminarApp();   // erzeugen einer Objekt-Instanz von SeminarApp
		seminarApp.run(args);                       // run Methode aus der SeminarApp
	}
}