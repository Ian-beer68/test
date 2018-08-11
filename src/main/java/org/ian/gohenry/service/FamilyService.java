package org.ian.gohenry.service;

import org.ian.gohenry.domain.Parent;

public interface FamilyService {

    Parent createParent(Parent parent);

    Parent getParentPlusChildren(Long parentId);


}
