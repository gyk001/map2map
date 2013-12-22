package cn.guoyukun.util.map2map.convert;

import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.ConvertException;
import cn.guoyukun.util.map2map.rule.Rule;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 *
 */
public interface Converter {
	public String getType();
	public Object convert(ConvertContext cxt, Rule rule) throws ConvertException;
	public int getMinParamsCount();
}
