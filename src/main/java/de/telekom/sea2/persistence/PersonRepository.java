// **********************
// **      SEA-2.0     **
// ** PersonRepository **
// ** by WildCodeSchool** 
// **********************

package de.telekom.sea2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	
// Create - Person anlegen	
	
	public boolean create(Person person) throws SQLException { // Datentyp Person, Variable pers
		PreparedStatement preparedStatement = 
				connection.prepareStatement("insert into personen (ID, ANREDE, VORNAME, NACHNAME) values (?,?,?,?)");

		long id = person.getId();
		Salutation salutation = person.getSalutation();
		byte salutationByte = salutation.toByte();
		String firstname = person.getFirstname();
		String lastname = person.getLastname();
		
		preparedStatement.setLong(1, id);
		preparedStatement.setByte(2, salutationByte);
		preparedStatement.setString(3, firstname);
		preparedStatement.setString(4, lastname);
		
		boolean result = preparedStatement.execute();

		return result;
	}

// Update Ändern einer Person 
	
	public boolean update(Person person) throws SQLException {
		
		PreparedStatement preparedStatement = 
				connection.prepareStatement("update personen set VORNAME=?, NACHNAME=? WHERE ID=?");

		long id = person.getId();
//		byte salutationByte = person.getSalutation().toByte();
		String firstname = person.getFirstname();
		String lastname = person.getLastname();
		

//		preparedStatement.setByte(2, salutationByte);
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setLong(3, id);

	//	boolean result = preparedStatement.execute("insert into personen (ID, + ANREDE, VORNAME, NACHNAME) values () + id + salutationByte + firstname + lastname");

		boolean result = preparedStatement.execute();
		
		return result;
	}

	
// Person Abfrage anhand der ID
	public Person get(long id) throws SQLException {
		statement = connection.createStatement(); // öffnet die Datenbank und übergibt an statement

// executeQuery führt SQL Befehl aus und schreibt Ergebnis in eslutSet für EIN SQL Statement
		resultSet = statement.executeQuery("select * from personen where id=" + id);

		if (resultSet.next()) {

// Einlesen des Resultset in einzelne Felder und Zuweisung in person
			Person person = new Person(resultSet.getLong(1), Salutation.fromByte(resultSet.getByte(2)), // konvertierung
					resultSet.getString(3), resultSet.getString(4)); // Salutation
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
					resultSet.getString(3), resultSet.getString(4)); // der Byte in
			arrayList.add(person);
		}
		return arrayList;
	}


	/** löschen einer Person mit Name **/
	public boolean delete(Person person) throws SQLException {
		long id = person.getId();
		return delete(id);
	}

	/** löschen einer Person mit ID **/
	public boolean delete(long id) throws SQLException {
		statement = connection.createStatement();
		boolean result = statement.execute("delete from personen where id=" + id);
		return false;
	}

	// löschen Aller Daten
	public boolean deleteAll() {
		return false;
	}

}
