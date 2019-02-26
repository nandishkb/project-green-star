package com.outreach.greenstar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.repository.GroupRepository;

@Repository("groupDao")
public class GroupDao {

    @Autowired
    private GroupRepository groupRepo;
    
    public Group getGroupById(int groupId) {
        return groupRepo.getOne(groupId);
    }

}
