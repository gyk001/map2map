package cn.guoyukun.util.map2map.convert.impl;

import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.ConvertException;
import cn.guoyukun.util.map2map.convert.Converter;
import cn.guoyukun.util.map2map.rule.Rule;
import cn.guoyukun.util.map2map.util.ChangeDataTypeUtil;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 * 
 */
public class TypeNameConverter extends NameConverter implements Converter {
	public static final String TYPE="type-name";
	@Override
	public Object convert(ConvertContext ctx, Rule rule)
			throws ConvertException {
		int length = rule.getParams().length;
		// 参数约定，第一个为目标类型，第二个为原字段名(可选)
		String targetType = (String) rule.getParams()[0];
		String srcKeyName = length>1 ? (String) rule.getParams()[1] : rule.getKey();
		try {
			Object val = ctx.getSourceMap().get(srcKeyName);
			if(val==null){
				return null;
			}
			String srcType = val.getClass().getName();
			return ChangeDataTypeUtil.changeSrctypeToTargeType(srcType, targetType, val);
		} catch (Exception e) {
			throw new ConvertException("转换失败!", e);
		}
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
