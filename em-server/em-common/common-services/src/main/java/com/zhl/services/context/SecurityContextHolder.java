package com.zhl.services.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.commons.lang3.StringUtils;
import com.zhl.utils.constant.SecurityConstants;
import com.zhl.utils.text.Convert;

/**
 * 获取当前线程变量中的 用户id、用户名称、Token等信息 
 * 注意： 必须在网关通过请求头的方法传入，同时在HeaderInterceptor拦截器设置值。 否则这里无法获取
 *
 * @author zyj
 */
public class SecurityContextHolder
{
    private static final TransmittableThreadLocal<Map<String, Object>> THREAD_LOCAL = new TransmittableThreadLocal<>();
	
	public static Map<String, Object> getLocalMap()
    {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null)
        {
            map = new ConcurrentHashMap<String, Object>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }
	
	public static Object get(String key)
    {
        Map<String, Object> map = getLocalMap();
        return map.getOrDefault(key, StringUtils.EMPTY);
    }
	
	public static void set(String key, Object value)
    {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? StringUtils.EMPTY : value);
    }
	
	public static Long getUserId()
    {
        return Convert.toLong(get(SecurityConstants.USER_ID), 0L);
    }
	
	public static void setUserId(String value)
    {
        set(SecurityConstants.USER_ID, value);
    }
	
	public static void remove()
    {
        THREAD_LOCAL.remove();
    }

}
