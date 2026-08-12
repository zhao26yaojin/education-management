package com.zhl.services.security.util.auth;

import com.zhl.services.security.service.TokenService;
import com.zhl.services.model.LoginUser;
import com.zhl.services.utils.SpringUtil;

/**
 * Token 权限验证工具类
 * 
 * @author zyj
 */
public class AuthUtil
{
	public static TokenService tokenService = SpringUtil.getBean(TokenService.class);
	
    /**
     * 获取当前用户缓存信息, 如果未登录，则抛出异常
     * 
     * @param token 前端传递的认证信息
     * @return 用户缓存信息
     */
    public static LoginUser getLoginUser(String token)
    {
        return tokenService.getLoginUser(token);
    }
	
	/**
     * 验证当前用户有效期, 如果相差超过10分钟，自动刷新缓存
     * 
     * @param loginUser 当前用户信息
     */
    public static void verifyLoginUserExpire(LoginUser loginUser)
    {
        tokenService.verifyToken(loginUser);
    }
}
