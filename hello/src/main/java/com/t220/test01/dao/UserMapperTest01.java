package com.t220.test01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapperTest01 {
	//在mapper接口中可以使用注解注入简单sql语句
	@Insert(value={"insert into itrip_user (userCode,userPassword,userName) values(#{userCode},#{userPassword},#{name})"})
	public void insert(@Param("userCode")String userCode,@Param("userPassword")String password,@Param("name")String name);
}
