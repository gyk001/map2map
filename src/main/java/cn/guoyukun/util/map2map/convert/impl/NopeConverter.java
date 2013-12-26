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
public class NopeConverter implements Converter{
	public static final String TYPE="nope";
	@Override
	public Object convert(ConvertContext ctx, Rule rule) throws ConvertException{
		String key = rule.getKey();
		if(key==null || key.trim().isEmpty()){
			throw new ConvertException("key不能为空！");
		}
		return ctx.getSourceMap().get(rule.getKey());
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public int getMinParamsCount() {
		return 0;
	}

}
