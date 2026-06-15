package com.zhl.acl.token;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import com.zhl.utils.uuid.UUID;
import com.zhl.utils.acl.JwtUtil;
import com.zhl.services.redis.RedisService;
import com.zhl.utils.constant.CacheConstants;
import com.zhl.utils.constant.SecurityConstants;
import com.zhl.acl.model.vo.UserLoginVo;

/**
 * token验证处理
 * 
 * @author zyj
 */
@Component
@Slf4j
public class TokenService
{
	@Autowired
    private RedisService redisService;
	
	protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
	
	private final static Long MILLIS_MINUTE_TEN = CacheConstants.REFRESH_TIME * MILLIS_MINUTE;
	
    /**
     * 创建令牌
     */
    public void createToken(UserLoginVo loginUser)
    {
        String userKey = UUID.fastUUID().toString();
        Long userId = loginUser.getId();
        String userName = loginUser.getName();
        loginUser.setUserKey(userKey);
        // loginUser.setIpaddr(IpUtils.getIpAddr());
        
		refreshToken(loginUser);

        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put(SecurityConstants.USER_KEY, userKey);
        claimsMap.put(SecurityConstants.USER_ID, userId);
        claimsMap.put(SecurityConstants.USER_NAME, userName);

        loginUser.setToken(JwtUtil.createToken(claimsMap));
    }
	
	/**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public UserLoginVo getLoginUser(String token)
    {
        UserLoginVo loginUser = null;
        try
        {
            if (StringUtils.isNotEmpty(token))
            {
                String userkey = JwtUtil.getUserKey(token);
                loginUser = redisService.getCacheObject(getTokenKey(userkey));
                return loginUser;
            }
        }
        catch (Exception e)
        {
            log.error("获取用户信息异常'{}'", e.getMessage());
        }
        return loginUser;
    }
	
	/**
     * 验证令牌有效期，相差不足10分钟，自动刷新缓存
     *
     * @param loginUser
     */
    public void verifyToken(UserLoginVo loginUser)
    {
        long loginTime = loginUser.getLoginTime();
        long currentTime = System.currentTimeMillis();
        if (currentTime - loginTime >= MILLIS_MINUTE_TEN)
        {
            refreshToken(loginUser);
        }
    }
	
	/**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(UserLoginVo loginUser)
    {
        loginUser.setLoginTime(System.currentTimeMillis());
        // loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getUserKey());
        redisService.setCacheObject(userKey, loginUser, CacheConstants.EXPIRATION, TimeUnit.MINUTES);
    }

    private String getTokenKey(String token)
    {
        return CacheConstants.TOKEN_KEY + token;
    }
}