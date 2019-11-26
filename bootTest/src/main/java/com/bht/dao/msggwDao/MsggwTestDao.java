package com.bht.dao.msggwDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsggwTestDao {

    String testSelect(@Param("id")String id);

}
