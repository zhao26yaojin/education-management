/**
 * 通用树结构遍历方法
 * @param list    树节点数组
 * @param handler 对每个节点的处理回调
 */
export function traverseTree(list, handler) {
  for (const item of list) {
    handler(item)
    if (item.children?.length) {
      traverseTree(item.children, handler)
    }
  }
}

// treeUtil.ts
//export function traverseTree<T extends { children?: T[] }>(
//  list: T[],
//  handler: (item: T) => void
//): void {
//  for (const item of list) {
//    handler(item)
//    if (item.children?.length) {
//      traverseTree(item.children, handler)
//    }
//  }
//}