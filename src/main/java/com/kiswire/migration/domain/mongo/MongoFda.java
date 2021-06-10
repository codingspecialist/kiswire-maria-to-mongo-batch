package com.kiswire.migration.domain.mongo;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("fda")
public class MongoFda {
	@Id
	private String _id; // 몽고에서 만들어지는 ObjectId
	private Long id;
	private String name; // fda001, fda002
	private String group; // 1,2

	@Field(name = "PLC_R0001")
	private String plcR0001;

	// UTC로 들어가기 때문에 꼭 9시간 더해서 옮기기
	@Field(name = "PLC_R0001_TIMESTAMP")
	private Timestamp plcR0001Timestamp;

	@Field(name = "PLC_R0001_QUALITY")
	private Integer plcR0001Quality;

	@Field(name = "R0035")
	private String r0035;

	@Field(name = "R0036")
	private String r0036;

	@Field(name = "R0037")
	private String r0037;

	@Field(name = "R0038")
	private String r0038;

	@Field(name = "R0039")
	private String r0039;

	@Field(name = "R0040")
	private String r0040;

	@Field(name = "R0041")
	private String r0041;

	@Field(name = "R0042")
	private String r0042;

	@Field(name = "R0043")
	private String r0043;

	@Field(name = "R0044")
	private String r0044;

	@Field(name = "R0002")
	private String r0002;

	@Field(name = "R0045")
	private String r0045;

	@Field(name = "R0046")
	private String r0046;

	@Field(name = "R0047")
	private String r0047;

	@Field(name = "R0048")
	private String r0048;

	@Field(name = "R0049")
	private String r0049;

	@Field(name = "R0050")
	private String r0050;

	@Field(name = "R0051")
	private String r0051;

	@Field(name = "R0052")
	private String r0052;

	@Field(name = "R0053")
	private String r0053;

	@Field(name = "R0054")
	private String r0054;

	@Field(name = "R0003")
	private String r0003;

	@Field(name = "R0055")
	private String r0055;

	@Field(name = "R0004")
	private String r0004;

	@Field(name = "R0005")
	private String r0005;

	@Field(name = "R0031")
	private String r0031;

	@Field(name = "R0032")
	private String r0032;

	@Field(name = "R0033")
	private String r0033;

	@Field(name = "R0034")
	private String r0034;
}
