package com.theone.nailtherapyspring.models.data;

import com.theone.nailtherapyspring.models.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {
}
