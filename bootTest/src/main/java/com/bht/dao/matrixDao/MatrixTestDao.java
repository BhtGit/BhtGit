package com.bht.dao.matrixDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MatrixTestDao {

    String testSelect(@Param("mid")String mid);

}
