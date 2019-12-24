package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright (C), 2019-2019
 * FileName: ListNode
 * Author:   s·D·bs
 * Date:     2019-12-24 17:58
 * Description: 定义节点类
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2019-12-24 17:58          0.0.0
 */
@Data
@AllArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

    
  