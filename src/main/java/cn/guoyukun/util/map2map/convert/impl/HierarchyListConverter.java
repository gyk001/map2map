package cn.guoyukun.util.map2map.convert.impl;

import java.util.ArrayList;
import java.util.List;

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
public class HierarchyListConverter implements Converter{
	public static final String TYPE="hierarchy-list";
	@Override
	public Object convert(ConvertContext ctx, Rule rule) throws ConvertException{
		if(rule instanceof RuleGroup){
			RuleGroup group = (RuleGroup) rule;
			List<Object> list = new ArrayList<Object>();
			List<Rule> itemRules = group.getRules();
			if(itemRules==null || itemRules.isEmpty()){
				return list;
			}
			for (Rule itemRule: itemRules) {
				list.add(ConvertUtil.convert(ctx, ctx.getSourceMap(), itemRule));
			}
			return list;
		}else{
			throw new ConvertException(HierarchyListConverter.class.getSimpleName()+"只能处理RuleGroup");
		}
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
