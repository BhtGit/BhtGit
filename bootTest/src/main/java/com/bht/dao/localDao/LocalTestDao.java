package com.bht.dao.localDao;

import org.apache.ibatis.annotations.Mapper;

import javax.persistence.Entity;

@Mapper
@Entity
public interface LocalTestDao {

    String select1();

}
