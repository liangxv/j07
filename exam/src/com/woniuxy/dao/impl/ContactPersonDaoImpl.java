package com.woniuxy.dao.impl;

import com.woniuxy.dao.BaseDao;
import com.woniuxy.dao.ContactPersonDao;
import com.woniuxy.pojo.ContactPerson;

import java.util.List;
import java.util.Map;

public class ContactPersonDaoImpl extends BaseDao implements ContactPersonDao {
    @Override
    public List<ContactPerson> getAllContactPerson() {
        return jdbcTemplate.query("select * from crm.contactperson",ContactPerson.class);
    }

    @Override
    public ContactPerson getContactPersonById(Integer id) {
        return jdbcTemplate.queryForObject("select * from crm.contactperson where id=?",ContactPerson.class,id);
    }

    @Override
    public Integer addContactPerson(ContactPerson contactPerson) {
        return jdbcTemplate.update("insert into crm.contactperson (name, gender, birthday, telephone, city) value (?,?,?,?,?)",
                contactPerson.getName(),contactPerson.getGender(),contactPerson.getBirthday(),
                contactPerson.getTelephone(),contactPerson.getCity());
    }

    @Override
    public Integer UpdateContactPerson(ContactPerson contactPerson) {
        return jdbcTemplate.update("update crm.contactperson set name=?,gender=?,birthday=?,telephone=?,city=? where id=?",
                contactPerson.getName(),contactPerson.getGender(),contactPerson.getBirthday(),
                contactPerson.getTelephone(),contactPerson.getCity(),contactPerson.getId());
    }

    @Override
    public List<Map<String, Object>> groupStatisticsGender() {
        return jdbcTemplate.queryForList("select gender,count(*) from crm.contactperson group by gender");
    }

    @Override
    public List<ContactPerson> getBirthdayRange(String start, String end) {
        return jdbcTemplate.query("select * from contactperson where birthday between ? and ?",ContactPerson.class,start,end);
    }

    @Override
    public List<ContactPerson> getContactPersonByCity(String city) {
        return jdbcTemplate.query("select * from contactperson where city=?",ContactPerson.class,city);
    }

    @Override
    public List<ContactPerson> sortByBirthday(Integer sort) {
        if (sort==1) {
            return jdbcTemplate.query("select * from contactperson order by birthday",ContactPerson.class);
        }else {
            return jdbcTemplate.query("select * from contactperson order by birthday desc ",ContactPerson.class);
        }
    }

    @Override
    public List<ContactPerson> pagingQuery(Integer page, Integer size) {
        int sum;
        sum = (page-1)*size;
        return jdbcTemplate.query("select *from contactperson limit ?,?",ContactPerson.class,sum,size);
    }
}
