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

import de.telekom.sea2.model.Person;

public class PersonRepository {
	
	// Initialisierung der Datenbank-Connection
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	final static String DRIVER = "org.mariadb.jbc.Driver";		// SQL Treiber definieren
	final static String URL = "jdbc:mariadb://localhost:3306/seadb?user=seauser&password=seapass";  // Datenbank Pfad, Benutzer und Passw.
	
	Connection connection; 	// Deklaration der Variable connection
	Statement statement;	// Deklaration der Variable statement
	ResultSet resultSet; 	// Deklaration der Variable resultset
	
	public void dbInit() throws ClassNotFoundException, SQLException {
		
		// Datenbanktreiber (mariadb) wird an class übergeben. "Class" lädt den passenden Datenbanktreiber
		Class.forName(DRIVER);   

		// aufbau der Datenbank-Connection
		connection = DriverManager.getConnection(URL);

	}
	

	// Sichtbarkeit, Rückgabewert, Methodenname (Parameter) {Methoden-Funktion}

	public boolean create(Person person) { 			// Datentyp Person, Variable pers
		return false;
	}
	
	// 
	public Person get(long id) throws SQLException { 									// Person Abfrage anhand der ID
		statement = connection.createStatement();										// öffnet die Datenbank und übergibt an statement
		resultSet = statement.executeQuery("select * from personen where id=" + id); 	// executeQuery führt SQL Befehl aus und schreibt Ergebnis in reslutSet

		while (resultSet.next()) {
			System.out.println("ID       : " + resultSet.getInt(1)); 			// ID
			System.out.println("Anrede   : " + resultSet.getInt(2)); 			// Anrede
			System.out.println("Vorname  : " + resultSet.getString(3)); 		// Vorname
			System.out.println("Nachname : " + resultSet.getString(4)); 		// Nachname
			System.out.println(""); // Leer
		}
		
		return null;
	}

	// Ausgabe aller Personen in Person-Array. Das Array wird in der Methode definiert
	public Person[] getAll() {
		
		return null;
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

