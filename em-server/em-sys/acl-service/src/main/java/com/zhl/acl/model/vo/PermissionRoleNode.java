package com.zhl.acl.model.vo;

import lombok.Data;
import java.util.List;
import java.lang.Long;
import java.lang.String;
import com.zhl.utils.tree.TreeNode;

@Data
public class PermissionRoleNode implements TreeNode<PermissionRoleNode> {

	private Long id;

	private String name;

	private String type;

	private Long parentId;

	private String pidPath;

	private String path;

	private String component;

	private Long roleId;

	private List<PermissionRoleNode> children;

}