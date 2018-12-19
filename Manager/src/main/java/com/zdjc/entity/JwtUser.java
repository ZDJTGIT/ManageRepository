package com.zdjc.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer userId;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String company;

    private String realName;

    private Date createTime;

    private Integer status;
    
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser() {
	}

	public JwtUser(User user) {
		userId = user.getUserId();
		username = user.getUserName();
		password = user.getPassword();
		authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	

	public void setId(Integer id) {
		this.userId = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "JwtUser [id=" + userId + ", username=" + username + ", password=" + password + ", authorities="
				+ authorities + "]";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
