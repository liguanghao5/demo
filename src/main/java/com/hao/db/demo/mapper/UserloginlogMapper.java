package com.hao.db.demo.mapper;

import com.hao.db.demo.bean.Userloginlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserloginlogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Userloginlog record);

    int insertSelective(Userloginlog record);

    Userloginlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userloginlog record);

    int updateByPrimaryKey(Userloginlog record);

    List<Userloginlog> getList();
}