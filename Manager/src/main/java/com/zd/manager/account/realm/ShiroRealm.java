package com.zd.manager.account.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zd.manager.account.model.User;
import com.zd.manager.account.service.UserService;
import com.zd.manager.core.util.SpringUtils;

@Component("ShiroRealm")
public class ShiroRealm extends AuthorizingRealm {
	public static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    private UserService userService;
    
//    private RoleService roleService;
	
//    private PermissionService permissionService;
	
    /**
     * 权限检查
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//	
//		roleService = SpringUtils.getBean(RoleService.class);
//    	permissionService = SpringUtils.getBean(PermissionService.class);
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        User user = (User) principals.getPrimaryPrincipal();
//        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getUserId());
//        for (Role role : roleInfos) {
//            // 添加角色
//            authorizationInfo.addRole(role.getRoleSign());
//            
//            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getRoleId());
//            for (Permission permission : permissions) {
//                // 添加权限
//            	logger.debug("添加权限"+"permissions");
//                authorizationInfo.addStringPermission(permission.getPermissionSign());
//            }
//        }
        return null;
	}

	/**
     * 登录验证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
    	userService = SpringUtils.getBean(UserService.class);
    	UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String userName = utoken.getUsername();
    	User user = userService.selectByUserName(userName);
    	
    	if (null == user || null == user.getUserName()) { 
    		throw new AuthenticationException("用户名错误"); 
    	} 
		// 通过数据库进行验证
//        if (null == user || "禁用".equals(user.getStatus())) {
//            throw new AuthenticationException("用户已经被禁用");
//        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
        return simpleAuthenticationInfo;
	}
	  /**
     * 清除授权缓存
     */
    @Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}
    /**
     *  清除认证缓存
     */
	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}
	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
