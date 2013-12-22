package cn.guoyukun.util.map2map.convert.impl;

import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.ConvertException;
import cn.guoyukun.util.map2map.ConvertUtil;
import cn.guoyukun.util.map2map.convert.Converter;
import cn.guoyukun.util.map2map.rule.Rule;
import cn.guoyukun.util.map2map.rule.RuleGroup;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 *
 */
public class HierarchyConverter implements Converter{
	
	@Override
	public Object convert(ConvertContext ctx, Rule rule) throws ConvertException{
		if(rule instanceof RuleGroup){
			RuleGroup group = (RuleGroup) rule;
			return ConvertUtil.convert(ctx, ctx.getSourceMap(), group);
		}else{
			throw new ConvertException(HierarchyConverter.class.getSimpleName()+"只能处理RuleGroup");
		}
	}

	@Override
	public String getType() {
		return "hierarchy";
	}

	@Override
	public int getMinParamsCount() {
		return 0;
	}

}
