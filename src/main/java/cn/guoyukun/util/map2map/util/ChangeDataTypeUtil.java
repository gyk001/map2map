package cn.guoyukun.util.map2map.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDataTypeUtil {
	private final static  SimpleDateFormat SDF_FULL = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private final static  SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public static Object changeSrctypeToTargeType(String srcType, String targetType,
			Object val) throws Exception {
			if(srcType.equals(targetType)){
				return val;
			}
			Object obj = null;
			if (targetType.equals("java.lang.String")) {
				if (srcType.equals("java.sql.Timestamp")) {
					Timestamp timestamp = (Timestamp) val;
					String targetName = SDF_FULL.format(timestamp);
					obj = targetName;
				} else if (srcType.equals("java.math.BigDecimal")) {
					Number bigDecimal = (Number) val;
					int bigDecValue = bigDecimal.intValue();
					String targeValue = String.valueOf(bigDecValue);
					obj = targeValue;
				}else{
				  throw new Exception("找不到与之匹配的类型");	
				}
			} else if (targetType.equals("java.sql.Timestamp")) {
				if (srcType.equals("java.lang.String")) {
					String date = (String) val;
					Date utilDate = null;
					if(date.length()>10){
						utilDate = SDF_FULL.parse(date);
					}else{
						utilDate = SDF_DATE.parse(date);
					}
					java.sql.Timestamp dateTime = new java.sql.Timestamp(
							utilDate.getTime());
					obj = dateTime;
				}else{
					  throw new Exception("找不到与之匹配的类型");	
					}
			} else if (targetType.equals("java.math.BigDecimal")) {
				if (srcType.equals("java.lang.String")) {
					String srcName = (String) val;
					// 构造以字符串内容为值的BigDecimal类型的变量bd
					BigDecimal bd = new BigDecimal(srcName);
					obj = bd;
				}else{
					  throw new Exception("找不到与之匹配的类型");	
					}
			}
			return obj;
		}
	
}
