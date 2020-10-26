package com.biz.ems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EMSVO {

	private long id;//	NUMBER
	private String from_email;//	nVARCHAR2(30)
	private String to_email;//	nVARCHAR2(30)
	private String s_date;//	nVARCHAR2(10)
	private String s_time;//	nVARCHAR2(10)
	private String s_subject;//	nVARCHAR2(125)
	private String s_content;//	nVARCHAR2(2000)
	private String s_file1;//	nVARCHAR2(125)
	private String s_file2;//	nVARCHAR2(125)

}
