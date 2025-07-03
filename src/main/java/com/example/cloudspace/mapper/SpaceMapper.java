package com.example.cloudspace.mapper;

import com.example.cloudspace.entity.Space;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SpaceMapper {
    int insertSpace(Space space);
    int updateSpace(Space space);
    int deleteSpaceById(@Param("id") Long id);
    Space selectSpaceById(@Param("id") Long id);
    List<Space> selectSpacesByUserId(@Param("userId") Long userId);
} 