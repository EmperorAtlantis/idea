package com.oracle.dao;

import com.oracle.entitys.JobRight;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JobRightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobRight record);

    int insertSelective(JobRight record);

    JobRight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobRight record);

    int updateByPrimaryKey(JobRight record);
}