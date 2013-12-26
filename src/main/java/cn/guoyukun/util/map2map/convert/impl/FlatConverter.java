package cn.guoyukun.util.map2map.convert.impl;

import ognl.Ognl;
import ognl.OgnlException;
import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.ConvertException;
import cn.guoyukun.util.map2map.convert.Converter;
import cn.guoyukun.util.map2map.rule.Rule;
import cn.guoyukun.util.map2map.util.ConvertOgnlContext;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 *
 */
public class FlatConverter implements Converter{
	public static final String TYPE="flat";
	
	@Override
	public Object convert(ConvertContext ctx, Rule rule) throws ConvertException{
		String ognl = (String) rule.getParams()[0];
		try {
			return Ognl.getValue(ognl, new ConvertOgnlContext(ctx), ctx.getSourceMap());
		} catch (OgnlException e) {
			throw new ConvertException("ognl求值错误", e);
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
