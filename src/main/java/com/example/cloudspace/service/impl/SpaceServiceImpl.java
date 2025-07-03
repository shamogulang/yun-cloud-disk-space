package com.example.cloudspace.service.impl;

import com.example.cloudspace.entity.Space;
import com.example.cloudspace.mapper.SpaceMapper;
import com.example.cloudspace.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {
    @Autowired
    private SpaceMapper spaceMapper;

    @Override
    public int createSpace(Space space) {
        return spaceMapper.insertSpace(space);
    }

    @Override
    public int updateSpace(Space space) {
        return spaceMapper.updateSpace(space);
    }

    @Override
    public int deleteSpace(Long id) {
        return spaceMapper.deleteSpaceById(id);
    }

    @Override
    public Space getSpaceById(Long id) {
        return spaceMapper.selectSpaceById(id);
    }

    @Override
    public List<Space> getSpacesByUserId(Long userId) {
        return spaceMapper.selectSpacesByUserId(userId);
    }
} 