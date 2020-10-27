package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.ems.model.EMSVO;
import com.biz.ems.sql.EMSSQL;

public interface EMSDao {

	@Select("SELECT * FROM tbl_ems order by id desc")
	public List<EMSVO> selectAll();
	
	@Select("SELECT * FROM tbl_ems WHERE id = #{id}")
	public EMSVO findBySeq(long id);
	
	@InsertProvider(type=EMSSQL.class,method="ems_insert")
	@SelectKey(keyProperty = "id",
	statement = "SELECT SEQ_ID.NEXTVAL FROM DUAL",
	resultType = Long.class,before = true)
	public int insert(EMSVO emsVO);
	
	@UpdateProvider(type=EMSSQL.class,method="ems_update")
	public int update(EMSVO emsVO);
	
	@Delete("DELETE FROM tbl_ems WHERE id = #{id}")
	public int delete(long seq);
}
