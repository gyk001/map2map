package cn.guoyukun.util.map2map.util;

import java.util.Map;

import ognl.OgnlContext;
import cn.guoyukun.util.map2map.ConvertContext;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 4, 2013
 *
 */
public class ConvertOgnlContext extends OgnlContext {

	
	public static final String SOURCE_MAP = "_SOURCE_MAP";
	public static final String TARGET_MAP = "_TARGET_MAP";
	
	public ConvertOgnlContext(Map<String, Object> sourceMap,
			Map<String, Object> targetMap) {
		super();
		this.put(SOURCE_MAP, sourceMap);
		this.put(TARGET_MAP, targetMap);
	}
	
	public ConvertOgnlContext( ConvertContext ctx) {
		super(ctx);
		this.put(SOURCE_MAP, ctx.getSourceMap());
		this.put(TARGET_MAP, ctx.getTargetMap());
	}
	
}
