package com.zhl.utils.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    /**
     * 通用 List 转 Tree
     * @param list      平铺的节点列表
     * @param rootPredicate 判断是否为根节点的条件
     * @return 树形结构列表
     */
    public static <T extends TreeNode<T>> List<T> buildTree(List<T> list) {

        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        // id -> node 映射，方便 O(1) 查找父节点
        Map<Long, T> nodeMap = new HashMap<>();
        for (T node : list) {
            node.setChildren(new ArrayList<>());
            nodeMap.put(node.getId(), node);
        }

        List<T> roots = new ArrayList<>();
        for (T node : list) {
            if (node.getParentId() == null || node.getParentId().equals(0L)) {
                // 根节点
                roots.add(node);
            } else {
                // 子节点，挂到父节点下
                T parent = nodeMap.get(node.getParentId());
                if (parent != null) {
                    parent.getChildren().add(node);
                } else {
                    // 找不到父节点，兜底当根节点
                    roots.add(node);
                }
            }
        }

        return roots;
    }
}
