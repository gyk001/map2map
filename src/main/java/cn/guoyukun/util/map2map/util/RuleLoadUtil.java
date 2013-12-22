package cn.guoyukun.util.map2map.util;

import cn.guoyukun.util.map2map.rule.Rule;
import cn.guoyukun.util.map2map.rule.RuleGroup;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;


/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version Dec 4, 2013
 *
 */
public class RuleLoadUtil {
	
	public static Rule loadRuleFromString(String xml){
		return (Rule)getXmlUtil().fromXML(xml);
	};
	
	public static Rule loadRuleFromResource(String xmlFile){
		return (Rule)getXmlUtil().fromXML(RuleLoadUtil.class.getResourceAsStream(xmlFile));
	};
	
	public static RuleGroup loadRuleGroupFromString(String xml){
		return (RuleGroup)getXmlUtil().fromXML(xml);
	};
	
	public static RuleGroup loadRuleGroupFromResource(String xmlFile){
		return (RuleGroup)getXmlUtil().fromXML(RuleLoadUtil.class.getResourceAsStream(xmlFile));
	};
	
	public static String ruleToXML(Rule rule){
		return getXmlUtil().toXML(rule);
	}
	
	private static XStream getXmlUtil(){
		XStream xstream = new XStream();
		Annotations.configureAliases(xstream, RuleGroup.class);
		Annotations.configureAliases(xstream, Rule.class);
		return xstream;
	}
	
}
