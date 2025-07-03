package com.example.cloudspace.service;

import com.example.cloudspace.entity.Space;
import java.util.List;

public interface SpaceService {
    int createSpace(Space space);
    int updateSpace(Space space);
    int deleteSpace(Long id);
    Space getSpaceById(Long id);
    List<Space> getSpacesByUserId(Long userId);
} 