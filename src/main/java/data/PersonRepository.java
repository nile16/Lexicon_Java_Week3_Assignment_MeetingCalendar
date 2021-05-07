package data;

import models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private static final PersonRepository INSTANCE;
    private final List<Person> personList;

    static {
        INSTANCE = new PersonRepository();
    }

    public static PersonRepository getInstance() {
        return INSTANCE;
    }

    private PersonRepository() {
        personList = new ArrayList<>();
    }

    public void clear() {
        personList.clear();
    }

    public List<Person> findAll() {
        return personList;
    }

    public Person findByEmail(String email) {
        for (Person person : personList) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> findByFirstname(String firstName) {
        List<Person> persons = new ArrayList<>();

        for (Person person : personList) {
            if (person.getFirstName().equals(firstName)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public Person findById(int id) {
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<Person> findByLastname(String lastName) {
        List<Person> persons = new ArrayList<>();

        for (Person person : personList) {
            if (person.getLastName().equals(lastName)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public Person findByUsername(String userName) {
        for (Person person : personList) {
            if (person.getUserCredentials().getUsername().equals(userName)) {
                return person;
            }
        }
        return null;
    }

    public int getPeopleCount() {
        return personList.size();
    }

    public void persist(Person person) { // Return value never used so made it void
        if (!personList.contains(person)) {
            personList.add(person);
        }
    }

    public boolean remove(int id) {
        for (Person person : personList) {
            if (person.getId() == id) {
                personList.remove(person);
                return true;
            }
        }
        return false;
    }
}

