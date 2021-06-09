package com.kiswire.migration.domain.maria.fda002;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "fda002")
public class MariaFda002 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // mediumint = Integer와 동일!! 혹시 모르니 Long으로 잡기
	
	//@ColumnDefault("null") - insert할 것이 아니라 select만 할 것이기 때문에 맞출 필요 없음.
	@Column(length = 20, name = "FDA002_PLC_R0001")
	private String plcR0001;
	
	@Column(name = "FDA002_PLC_R0001_TIMESTAMP")
	private Timestamp plcR0001Timestamp;
	
	@Column(name = "FDA002_PLC_R0001_QUALITY")
	private Integer plcR0001Quality;
	
	@Column(length = 20, name = "FDA002_R0035")
	private String r0035;

	@Column(length = 20, name = "FDA002_R0036")
	private String r0036;
	
	@Column(length = 20, name = "FDA002_R0037")
	private String r0037;
	
	@Column(length = 20, name = "FDA002_R0038")
	private String r0038;
	
	@Column(length = 20, name = "FDA002_R0039")
	private String r0039;
	
	@Column(length = 20, name = "FDA002_R0040")
	private String r0040;
	
	@Column(length = 20, name = "FDA002_R0041")
	private String r0041;
	
	@Column(length = 20, name = "FDA002_R0042")
	private String r0042;
	
	@Column(length = 20, name = "FDA002_R0043")
	private String fda0021R0043;
	
	@Column(length = 20, name = "FDA002_R0044")
	private String r0044;
	
	@Column(length = 20, name = "FDA002_R0002")
	private String r0002;
	
	@Column(length = 20, name = "FDA002_R0045")
	private String r0045;
	
	@Column(length = 20, name = "FDA002_R0046")
	private String r0046;
	
	@Column(length = 20, name = "FDA002_R0047")
	private String r0047;
	
	@Column(length = 20, name = "FDA002_R0048")
	private String r0048;
	
	@Column(length = 20, name = "FDA002_R0049")
	private String r0049;
	
	@Column(length = 20, name = "FDA002_R0050")
	private String r0050;
	
	@Column(length = 20, name = "FDA002_R0051")
	private String r0051;
	
	@Column(length = 20, name = "FDA002_R0052")
	private String r0052;
	
	@Column(length = 20, name = "FDA002_R0053")
	private String r0053;
	
	@Column(length = 20, name = "FDA002_R0054")
	private String r0054;
	
	@Column(length = 20, name = "FDA002_R0003")
	private String r0003;
	
	@Column(length = 20, name = "FDA002_R0055")
	private String r0055;
	
	@Column(length = 20, name = "FDA002_R0004")
	private String r0004;
	
	@Column(length = 20, name = "FDA002_R0005")
	private String r0005;
	
	@Column(length = 20, name = "FDA002_R0031")
	private String r0031;
	
	@Column(length = 20, name = "FDA002_R0032")
	private String r0032;
	
	@Column(length = 20, name = "FDA002_R0033")
	private String r0033;
	
	@Column(length = 20, name = "FDA002_R0034")
	private String r0034;
}











