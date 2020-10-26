package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.ems.model.EMSVO;

public interface EMSDao {

	@Select("SELECT * FROM tbl_ems order by id desc")
	public List<EMSVO> selectAll();
	
	@Select("SELECT * FROM tbl_ems WHERE id = #{id}")
	public EMSVO findBySeq(long seq);
	
	/*
	 * BBsSQL 클래스에 정의된 bbs_insert method를 호출하여
	 * SQL문을 생성하고, 여기에 코드를 추가하라
	 */
	@InsertProvider(type=EMSSQL.class,method="bbs_insert")
	@SelectKey(keyProperty = "id",
		statement = "SELECT SEQ_ID.NEXTVAL FROM DUAL",
		resultType = Long.class,before = true)
	public int insert(EMSVO emsVO);
	
	@UpdateProvider(type=EMSSQL.class,method="bbs_update")
	public int update(EMSVO emsVO);
	
	@Delete("DELETE FROM tbl_ems WHERE id = #{id}")
	public int delete(long seq);
}
