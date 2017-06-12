package com.simple.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.cheuks.bin.original.common.dbmanager.BaseEntity;

/***
 * 
 * @Title: simple-core
 * @Description: 权限组
 * @Company:
 * @Email: 20796698@qq.com
 * @author cheuk.bin.li
 * @date 2017年6月3日 上午11:04:40
 *
 */
@Entity(name = "simple_authority_group")
public class AuthorityGroup extends BaseEntity {

	private static final long serialVersionUID = -3868766379525670107L;

	@Id
	private Long id;
	@Column(length = 64)
	private String name;//权限组名称

	//不同步
	private transient List<Authority> authorities;

	public Long getId() {
		return id;
	}

	public AuthorityGroup setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public AuthorityGroup setName(String name) {
		this.name = name;
		return this;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public AuthorityGroup setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	public AuthorityGroup() {
		super();
	}

	public AuthorityGroup(Long id) {
		super();
		this.id = id;
	}

}