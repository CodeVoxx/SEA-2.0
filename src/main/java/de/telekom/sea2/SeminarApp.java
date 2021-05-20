// *****************
// **   SEA-2.0   **
// **  SeminarApp ** 
// *****************

package de.telekom.sea2;

import java.sql.SQLException;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class SeminarApp {

    public void run(String[] args) {
   
    PersonRepository personRepository = new PersonRepository();
    
    try {
    	personRepository.dbInit();
		Person person = personRepository.get(2);
		System.out.println(person.getFirstname());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
    
   }
	        
}
