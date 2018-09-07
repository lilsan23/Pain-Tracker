package org.launchcode.paintracker.models.data;

import org.launchcode.paintracker.models.Pain;
import org.launchcode.paintracker.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProfileDao extends CrudRepository<Profile, Integer> {
}


