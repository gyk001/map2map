package cn.guoyukun.util.map2map.convert.impl;

import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.ConvertException;
import cn.guoyukun.util.map2map.convert.Converter;
import cn.guoyukun.util.map2map.rule.Rule;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 *
 */
public class NameConverter implements Converter{
	public static final String TYPE="name";
	@Override
	public Object convert(ConvertContext ctx, Rule rule) throws ConvertException{
		try {
			String name = (String)rule.getParams()[0];
			return ctx.getSourceMap().get(name);
		} catch (Exception e) {
			throw new ConvertException("提取参数失败!", e);
		}
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public int getMinParamsCount() {
		return 1;
	}

}
