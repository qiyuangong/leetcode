## Pow(x,n)


### 描述

Implement `pow(x, n)`.


### 分析

二分法，$$x^n = x^{n/2} \times x^{n/2} \times x^{n\%2}$$


### 代码

{% codesnippet "./code/pow."+book.suffix, language=book.suffix %}{% endcodesnippet %}

### 相关题目

* [Sqrt(x)](sqrt.md)
