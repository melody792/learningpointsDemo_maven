package com.pzb.mockito;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(Integer personId, String name) {
        if (isUpdate(personId,name)){
            System.out.println("can be update");
        }
        Person person = personDao.fetchPerson(personId);
        if (person != null) {
            Person updatedPerson = new Person(person.getPersonID(), name);
            personDao.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }

    public boolean isUpdate(Integer personId, String name){
        return true;
    }
} 