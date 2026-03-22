package com.zhl.services.security;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import com.zhl.services.context.SecurityContextHolder;
import com.zhl.services.servlet.ServletUtil;
import com.zhl.utils.constant.TokenConstants;


/**
 * 权限获取工具类
 * 
 * @author zyj
 */
public class SecurityUtil
{
	/**
     * 获取用户ID
     */
    public static Long getUserId()
    {
        return SecurityContextHolder.getUserId();
    }
	
	/**
     * 获取请求token
     */
    public static String getToken()
    {
        return getToken(ServletUtil.getRequest());
    }
	
	/**
     * 根据request获取请求token
     */
    public static String getToken(HttpServletRequest request)
    {
        // 从header获取token标识
        String token = request.getHeader(TokenConstants.AUTHENTICATION);
        return replaceTokenPrefix(token);
    }
	
	/**
     * 裁剪token前缀
     */
    public static String replaceTokenPrefix(String token)
    {
        // 如果前端设置了令牌前缀，则裁剪掉前缀
        if (StringUtils.isNotEmpty(token) && token.startsWith(TokenConstants.PREFIX))
        {
            token = token.replaceFirst(TokenConstants.PREFIX, "");
        }
        return token;
    }
    
}
