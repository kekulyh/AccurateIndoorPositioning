package au.usyd.capstone.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

//实现了Serializable接口， 以便JVM可以序列化PO实例
@SuppressWarnings("serial")
public class BaseDomain implements Serializable {
	
	//统一的toString()方法
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
