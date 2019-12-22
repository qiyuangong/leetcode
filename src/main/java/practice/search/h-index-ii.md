## H-Index II


### 描述

**Follow up** for [H-Index](../sorting/counting-sort/h-index.md): What if the citations array is sorted in ascending order? Could you optimize your algorithm?


### 分析

设数组长度为`n`，那么`n-i`就是引用次数大于等于`nums[i]`的文章数。如果`nums[i]<n-i`，说明`i`是有效的H-Index, 如果一个数是H-Index，那么最大的H-Index一定在它后面（因为是升序的），根据这点就可以进行二分搜索了。


### 代码

{% if book.java %}
{% codesnippet "./code/h-index-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
