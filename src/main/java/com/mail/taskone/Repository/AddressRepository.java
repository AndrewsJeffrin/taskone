package com.mail.taskone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.taskone.bean.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
