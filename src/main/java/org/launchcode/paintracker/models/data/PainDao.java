package org.launchcode.paintracker.models.data;

import org.launchcode.paintracker.models.Pain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PainDao extends CrudRepository<Pain, Integer> {
}
