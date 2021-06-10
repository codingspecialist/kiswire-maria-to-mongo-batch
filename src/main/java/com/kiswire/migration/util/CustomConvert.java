package com.kiswire.migration.util;

import java.util.List;
import java.util.stream.Collectors;

import com.kiswire.migration.domain.maria.MariaFda;
import com.kiswire.migration.domain.mongo.MongoFda;

public class CustomConvert {

	public static List<MongoFda> mariaToMongoObject(List<? extends MariaFda> datas, String name, String group){
		
		List<MongoFda> mongoFs =  datas.stream().map((data)->{
			MongoFda m = MongoFda.builder()
					.id(data.getId())
					.name(name)
					.group(group)
					.plcR0001(data.getPlcR0001())
					.plcR0001Timestamp(CustomTimeUtils.plus9Hour(data.getPlcR0001Timestamp()))
					.plcR0001Quality(data.getPlcR0001Quality())
					.r0035(data.getR0035())
					.r0036(data.getR0036())
					.r0037(data.getR0037())
					.r0038(data.getR0038())
					.r0039(data.getR0039())
					.r0040(data.getR0040())
					.r0041(data.getR0041())
					.r0042(data.getR0042())
					.r0043(data.getR0043())
					.r0044(data.getR0044())
					.r0002(data.getR0002())
					.r0045(data.getR0045())
					.r0046(data.getR0046())
					.r0047(data.getR0047())
					.r0048(data.getR0048())
					.r0049(data.getR0049())
					.r0050(data.getR0050())
					.r0051(data.getR0051())
					.r0052(data.getR0052())
					.r0053(data.getR0053())
					.r0054(data.getR0054())
					.r0003(data.getR0003())
					.r0055(data.getR0055())
					.r0004(data.getR0004())
					.r0005(data.getR0005())
					.r0031(data.getR0031())
					.r0032(data.getR0032())
					.r0033(data.getR0033())
					.r0034(data.getR0034())
					.build();
			
			return m;
		}).collect(Collectors.toList());
		
		return mongoFs;
	}
}
