package cn.guoyukun.util.map2map;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 3, 2013
 *
 */
public class ConvertContext extends HashMap<String, Object>{
	private static final long serialVersionUID = 6798228153253698260L;
	private Map<String,Object> sourceMap ;
	private Map<String,Object> targetMap ;

	
	public ConvertContext(Map<String, Object> sourceMap) {
		super();
		//this.sourceMap = ImmutableMap.copyOf(sourceMap);
		this.sourceMap = new HashMap<String, Object>();
		this.sourceMap.putAll(sourceMap);
		this.targetMap = new HashMap<String, Object>();
	}
	
	public Map<String, Object> getSourceMap() {
		return sourceMap;
	}
	public void setSourceMap(Map<String, Object> sourceMap) {
		this.sourceMap = ImmutableMap.copyOf(sourceMap);
	}
	public Map<String, Object> getTargetMap() {
		return targetMap;
	}
	public void setTargetMap(Map<String, Object> targetMap) {
		this.targetMap = ImmutableMap.copyOf(targetMap);
	}
	
}
