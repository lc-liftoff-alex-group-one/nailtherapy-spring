package com.theone.nailtherapyspring.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends CrudRepository<ContactForm, Integer> {

}
