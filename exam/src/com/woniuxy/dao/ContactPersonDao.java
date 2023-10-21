package com.woniuxy.dao;

import com.woniuxy.pojo.ContactPerson;

import java.util.List;
import java.util.Map;

public interface ContactPersonDao {
    List<ContactPerson> getAllContactPerson();

    ContactPerson getContactPersonById(Integer id);

    Integer addContactPerson(ContactPerson contactPerson);

    Integer UpdateContactPerson(ContactPerson contactPerson);

    List<Map<String, Object>> groupStatisticsGender();

    List<ContactPerson> getBirthdayRange(String start, String end);

    List<ContactPerson> getContactPersonByCity(String city);

    List<ContactPerson> sortByBirthday(Integer sort);

    List<ContactPerson> pagingQuery(Integer page,Integer size);

}
