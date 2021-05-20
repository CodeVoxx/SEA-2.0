// **********************
// **      SEA-2.0     **
// ** PersonRepository ** 
// **********************

package de.telekom.sea2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;

public class PersonRepository {

	// Initialisierung der Datenbank-Connection

	java.util.Scanner scanner = new java.util.Scanner(System.in);

	final static String DRIVER = "org.mariadb.jdbc.Driver"; // SQL Treiber definieren
	final static String URL = "jdbc:mariadb://localhost:3306/seadb?user=seauser&password=seapass"; // Datenbank
																									// Pfad,Benutzer,
																									// Passwort

	Connection connection; // Deklaration der Variable connection
	Statement statement; // Deklaration der Variable statement
	ResultSet resultSet; // Deklaration der Variable resultset

	public void dbInit() throws ClassNotFoundException, SQLException {

		// Datenbanktreiber (mariadb) wird an class übergeben. "Class" lädt den
		// passenden Datenbanktreiber
		Class.forName(DRIVER);

		// aufbau der Datenbank-Connection
		connection = DriverManager.getConnection(URL);
	}

	// Sichtbarkeit, Rückgabewert, Methodenname (Parameter) {Methoden-Funktion}

	public boolean create(Person person) { // Datentyp Person, Variable pers
		return false;
	}

// Person Abfrage anhand der ID
	public Person get(long id) throws SQLException {
		statement = connection.createStatement(); // öffnet die Datenbank und übergibt an statement

// executeQuery führt SQL Befehl aus und schreibt Ergebnis in eslutSet für EIN SQL Statement
		resultSet = statement.executeQuery("select * from personen where id=" + id);

		if (resultSet.next()) {

// Einlesen des Resultset in einzelne Felder und Zuweisung in person
			Person person = new Person(resultSet.getLong(1), Salutation.fromByte(resultSet.getByte(2)), // konvertierung
				resultSet.getString(3), resultSet.getString(4));										// Salutation
			                                                                                            // der Byte in
			return person;
		} else {
			return null;
		}
	}

// Ausgabe aller Personen in Person-Array. Das Array wird in der Methode definiert
	public ArrayList getAll() throws SQLException {

		ArrayList arrayList = new ArrayList();
		
		statement = connection.createStatement(); // öffnet die Datenbank und übergibt an statement

		// executeQuery führt SQL Befehl aus und schreibt Ergebnis in eslutSet für EIN
		// SQL Statement
		resultSet = statement.executeQuery("select * from personen");

		while (resultSet.next()) {
	
			// Einlesen des Resultset in einzelne Felder und Zuweisung in person
			Person person = new Person(resultSet.getLong(1), Salutation.fromByte(resultSet.getByte(2)), // konvertierung
					resultSet.getString(3), resultSet.getString(4));									// der Byte in
					arrayList.add(person);
		}
			return arrayList;
	}

	// Ändern einer Person
	public boolean update(Person person) {
		return false;
	}

	// löschen einer Person mit
	public boolean delete(Person person) {
		long id = person.getId();
		return delete(id);
	}

	// löschen einer Person mit id
	public boolean delete(long id) {
		return false;
	}

	// löschen Aller Daten
	public boolean deleteAll() {
		return false;
	}

}
