package com.zd.manager.core.config;

import net.sf.ehcache.config.CacheConfiguration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kstar:
 * @version 2018年6月21日 下午4:58:34
 * 
 */
@Configuration
@EnableCaching
public class CachingConfiguration implements CachingConfigurer {

	/*
	 * 配置自定义缓存
    name：Cache的唯一标识
    maxElementsInMemory：缓存中允许创建的最大对象数
    maxElementsOnDisk：磁盘中最大缓存对象数，若是0表示无穷大
    eternal：Element是否永久有效，一但设置了true，timeout将不起作用，对象永不过期。
    timeToIdleSeconds：缓存数据的钝化时间，也就是在一个元素消亡之前，
            两次访问时间的最大时间间隔值，这只能在元素不是永久驻留时有效，
            如果该值是 0 就意味着元素可以停顿无穷长的时间。
    timeToLiveSeconds：缓存数据的生存时间，也就是一个元素从构建到消亡的最大时间间隔值，                               这只能在元素不是永久驻留时有效，如果该值是0就意味着元素可以停顿无穷长的时间。
    overflowToDisk：内存不足时，是否启用磁盘缓存。
    diskPersistent：是否缓存虚拟机重启期数据
    diskExpiryThreadIntervalSeconds：磁盘失效线程运行时间间隔，默认是120秒
    diskSpoolBufferSizeMB：这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区
    memoryStoreEvictionPolicy：缓存满了之后的淘汰算法。默认策略是LRU（最近最少使用）。你可以设置为FIFO（先进先出）或是LFU（较少使用）
        Ehcache的三种清空策略;
            FIFO，first in first out，这个是大家最熟的，先进先出。
            LFU， Less Frequently Used，就是上面例子中使用的策略，直白一点就是讲一直以来最少被使用的。如上面所讲，缓存的元素有一个hit属性，hit值最小的将会被清出缓存。
            LRU，Least Recently Used，最近最少使用的，缓存的元素有一个时间戳，当缓存容量满了，而又需要腾出地方来缓存新的元素的时候，那么现有缓存元素中时间戳离当前时间最远的元素将被清出缓存。
	 */
	public net.sf.ehcache.CacheManager ehCacheManager(){
		CacheConfiguration userCache = createCacheConfiguration("userCache");
		CacheConfiguration roleCache = createCacheConfiguration("roleCache");
		CacheConfiguration tokenCache = createCacheConfiguration("tokenCache");
		CacheConfiguration permissionCache = createCacheConfiguration("permissionCache");
		CacheConfiguration userProjectCache = createCacheConfiguration("userProjectCache");
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(userCache);
        config.addCache(roleCache);
        config.addCache(tokenCache);
        config.addCache(permissionCache);
        config.addCache(userProjectCache);
        return net.sf.ehcache.CacheManager.newInstance(config);
	}
	
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	@Override
	public CacheResolver cacheResolver() {
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	public CacheConfiguration createCacheConfiguration(String name){
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		//设置缓存名
        cacheConfiguration.setName(name);
        //设置最大对象数
        cacheConfiguration.setMaxElementsInMemory(1000);
        //
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        //对象是否永久有效
        cacheConfiguration.setEternal(false);
        //钝化时间
        cacheConfiguration.setTimeToIdleSeconds(300);
        //数据生存时间
        cacheConfiguration.setTimeToLiveSeconds(600);
        //内存溢出是否保存在硬盘
        cacheConfiguration.setOverflowToDisk(true);
        //是否缓存虚拟机重启期数据
        cacheConfiguration.setStatistics(true);
        //
        cacheConfiguration.setMaxEntriesLocalDisk(100000);
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        return cacheConfiguration;
	}
}
