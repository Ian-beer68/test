package org.ian.gohenry.dal;

import org.ian.gohenry.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDAO extends JpaRepository<Child, Long> {

}
