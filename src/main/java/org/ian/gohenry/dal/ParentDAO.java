package org.ian.gohenry.dal;

import org.ian.gohenry.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDAO extends JpaRepository<Parent, Long> {

}
