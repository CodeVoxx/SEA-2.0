// *****************
// **   SEA-2.0   **
// **  SeminarApp ** 
// *****************

package de.telekom.sea2;

import java.sql.SQLException;
import java.util.ArrayList;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class SeminarApp {

	public void run(String[] args) {

		PersonRepository personRepository = new PersonRepository();

		
		
// Select by ID
		try {
			personRepository.dbInit();
			
			Person person = personRepository.get(13);
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);
		} catch (Exception e) {
					e.printStackTrace();
		}
	
// Delete

		try {
			boolean result = personRepository.delete(13);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
// Create - Benutzer hinzufügen
		
		long id= 13;
		String salutation =	"MR";
		String firstName =	"Gerd";
		String lastName = "Barodte";
		
		Person person1 = new Person (id, salutation, firstName, lastName);
		try {
			personRepository.dbInit();
			Boolean result = personRepository.create(person1);
			System.out.println("___________________________________________________________________");	
			System.out.println(result);
			System.out.println("___________________________________________________________________");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
// Update - Benutzer Update
		
				long id2= 1;
				String salutation2 =	"MR";
				String firstName2 =	"Aaanton";
				String lastName2 = "Aaaanonius";
				
				Person person2 = new Person (id2, salutation2, firstName2, lastName2);
				try {
					personRepository.dbInit();
					Boolean result = personRepository.update(person2);
					System.out.println("___________________________________________________________________");	
					System.out.println(result);
					System.out.println("___________________________________________________________________");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
// Select all
	
			try {
		ArrayList personListAll = personRepository.getAll();
		for (int i = 0; i < personListAll.size(); i++) {
			Person person = (Person) personListAll.get(i);
			// System.out.println(person.getFirstname());
			String string = String.format("%s %s %s %s", person.getId(), person.getSalutation(), person.getFirstname(),
					person.getLastname());
			System.out.println(string);
		}
	} catch(
	Exception e)
	{
		e.printStackTrace();
	}

}
}
