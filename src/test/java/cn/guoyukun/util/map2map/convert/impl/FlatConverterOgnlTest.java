package cn.guoyukun.util.map2map.convert.impl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.testng.Assert;
import org.testng.annotations.Test;

import cn.guoyukun.util.map2map.ConvertContext;
import cn.guoyukun.util.map2map.util.ConvertOgnlContext;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 4, 2013
 *
 */
public class FlatConverterOgnlTest {

	@Test
	public void convert() throws OgnlException {
		Map<String, Object> srcMap = new HashMap<String,Object>();
		srcMap.put("S", "SV");
		ConvertContext ctx = new ConvertContext(srcMap);
		
		ConvertOgnlContext ognlContext = new ConvertOgnlContext(ctx);
		
		Assert.assertEquals(Ognl.getValue("#_SOURCE_MAP.S", ognlContext, srcMap), "SV");
		Assert.assertEquals(Ognl.getValue("S", srcMap), "SV");
	}
}
