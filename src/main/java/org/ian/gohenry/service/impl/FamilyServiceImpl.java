package org.ian.gohenry.service.impl;

import org.ian.gohenry.dal.ChildDAO;
import org.ian.gohenry.dal.ParentDAO;
import org.ian.gohenry.domain.Parent;
import org.ian.gohenry.dto.ParentDTO;
import org.ian.gohenry.service.FamilyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private ChildDAO childDAO;
    @Autowired
    private ParentDAO parentDAO;



    @Override
    public Parent createParent(Parent parent) {
        Parent p =parentDAO.save(parent);
        return p;
    }

    @Override
    public Parent getParentPlusChildren(Long parentId) {
        Parent parent = parentDAO.findOne(parentId);
        if (null != parent) {
            return parent;
        } else {
            return null;
        }
    }


}
