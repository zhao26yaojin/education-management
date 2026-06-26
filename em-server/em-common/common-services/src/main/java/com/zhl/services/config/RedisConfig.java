package com.zhl.services.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	// @ConditionalOnMissingBean(name = "redisTemplate")
	// @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> template = new RedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
			.cacheDefaults(defaultCacheConfig(7))
			.transactionAware()
			.build();

		return redisCacheManager;
	}

	private RedisCacheConfiguration defaultCacheConfig(Integer day) {
		// ObjectMapper mapper = new ObjectMapper();
		// mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// Jackson2JsonRedisSerializer<Object> serializer = new
		// Jackson2JsonRedisSerializer<>(mapper, Object.class);

		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
			.entryTtl(Duration.ofDays(day))
			.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
			.serializeValuesWith(RedisSerializationContext.SerializationPair
				.fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class)))
			.disableCachingNullValues();

		return configuration;
	}

}
