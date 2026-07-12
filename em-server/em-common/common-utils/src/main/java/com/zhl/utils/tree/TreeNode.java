package com.zhl.utils.tree;

import java.util.List;

public interface TreeNode<T> {
    Long getId();
    Long getParentId();
    List<T> getChildren();
    void setChildren(List<T> children);
}
