package com.zhl.acl.model.vo;

import lombok.Data;
import java.util.List;
import java.lang.Long;
import java.lang.String;
import com.zhl.utils.tree.TreeNode;

@Data
public class MenuRoleNode implements TreeNode<MenuRoleNode> {

	private Long id;

	private String name;

	private Long parentId;

	private String pidPath;

	private String url;

	private String component;

	private Long roleId;

	private List<MenuRoleNode> children;

}