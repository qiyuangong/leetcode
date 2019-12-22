## Product of Array Except Self


### 描述

Given an array of `n` integers where `n > 1`, `nums`, return an array output such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

Solve it **without division** and in `O(n)`.

For example, given `[1,2,3,4]`, return `[24,12,8,6]`.

**Follow up**:

Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


### 分析

我们以一个4个元素的数组为例，`nums=[a1,a2,a3,a4]`，要想在`O(n)`的时间内输出结果，比较好的解决方法是提前构造好两个数组：

* `[1, a1, a1*a2, a1*a2*a3]`
* `[a2*a3*a4, a3*a4, a4, 1]`

然后两个数组一一对应相乘，即可得到最终结果 `[a2*a3*a4, a1*a3*a4, a1*a2*a4, a1*a2*a3]`。

不过，上述方法的空间复杂度为`O(n)`，可以进一步优化成常数空间，即用一个整数代替第二个数组。


### 代码1 O(n)空间

{% if book.java %}
{% codesnippet "./code/product-of-array-except-self-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 代码2 O(1)空间

{% if book.java %}
{% codesnippet "./code/product-of-array-except-self-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
