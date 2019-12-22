## 小结


### 适用场景

**输入数据**：没什么特征，不像深搜，需要有“递归”的性质。如果是树或者图，概率更大。

**状态转换图**：树或者DAG图。

**求解目标**：多阶段最优化问题。


### 思考的步骤

1. 是求路径长度，还是路径本身（或动作序列）？

    1. 如果是求路径长度，则状态里面要存路径长度（或双队列+一个全局变量）
    1. 如果是求路径本身或动作序列

        1. 要用一棵树存储宽搜过程中的路径
        1. 是否可以预估状态个数的上限？能够预估状态总数，则开一个大数组，用树的双亲表示法；如果不能预估状态总数，则要使用一棵通用的树。这一步也是第4步的必要不充分条件。

1. 如何表示状态？即一个状态需要存储哪些些必要的数据，才能够完整提供如何扩展到下一步状态的所有信息。一般记录当前位置或整体局面。

1. 如何扩展状态？这一步跟第2步相关。状态里记录的数据不同，扩展方法就不同。对于固定不变的数据结构（一般题目直接给出，作为输入数据），如二叉树，图等，扩展方法很简单，直接往下一层走，对于隐式图，要先在第1步里想清楚状态所带的数据，想清楚了这点，那如何扩展就很简单了。

1. 如何判断重复？如果状态转换图是一颗树，则永远不会出现回路，不需要判重；如果状态转换图是一个图（这时候是一个图上的BFS），则需要判重。

    1. 如果是求最短路径长度或一条路径，则只需要让“点”（即状态）不重复出现，即可保证不出现回路
    1. 如果是求所有路径，注意此时，状态转换图是DAG，即允许两个父节点指向同一个子节点。具体实现时，每个节点要**“延迟”**加入到已访问集合`visited`，要等一层全部访问完后，再加入到`visited`集合。
    1. 具体实现

        1. 状态是否存在完美哈希方案？即将状态一一映射到整数，互相之间不会冲突。
        1. 如果不存在，则需要使用通用的哈希表（自己实现或用标准库，例如`unordered_set`）来判重；自己实现哈希表的话，如果能够预估状态个数的上限，则可以开两个数组，head和next，表示哈希表，参考第 ??? 节方案2。
        1. 如果存在，则可以开一个大布尔数组，来判重，且此时可以精确计算出状态总数，而不仅仅是预估上限。

1. 目标状态是否已知？如果题目已经给出了目标状态，可以带来很大便利，这时候可以从起始状态出发，正向广搜；也可以从目标状态出发，逆向广搜；也可以同时出发，双向广搜。


### 代码模板

广搜需要一个队列，用于一层一层扩展，一个hashset，用于判重，一棵树（只求长度时不需要），用于存储整棵树。

对于队列，可以用`queue`，也可以把`vector`当做队列使用。当求长度时，有两种做法：

1. 只用一个队列，但在状态结构体`state_t`里增加一个整数字段`level`，表示当前所在的层次，当碰到目标状态，直接输出`level`即可。这个方案，可以很容易的变成A*算法，把`queue`替换为`priority_queue`即可。
1. 用两个队列，`current, next`，分别表示当前层次和下一层，另设一个全局整数`level`，表示层数（也即路径长度），当碰到目标状态，输出`level`即可。这个方案，状态里可以不存路径长度，只需全局设置一个整数`level`，比较节省内存；

对于hashset，如果有完美哈希方案，用布尔数组(`bool visited[STATE_MAX]`或`vector<bool> visited(STATE_MAX, false)`)来表示；如果没有，可以用STL里的`set`或`unordered_set`。

对于树，如果用STL，可以用`unordered_map<state_t, state_t > father`表示一颗树，代码非常简洁。如果能够预估状态总数的上限（设为STATE_MAX），可以用数组(`state_t nodes[STATE_MAX]`)，即树的双亲表示法来表示树，效率更高，当然，需要写更多代码。


### 如何表示状态

```cpp
/** 状态 */
struct state_t {
    int data1;  /** 状态的数据，可以有多个字段. */
    int data2;  /** 状态的数据，可以有多个字段. */
    // dataN;   /** 其他字段 */
    int action; /** 由父状态移动到本状态的动作，求动作序列时需要. */
    int level;  /** 所在的层次（从0开始），也即路径长度-1，求路径长度时需要；
                    不过，采用双队列时不需要本字段，只需全局设一个整数 */
    bool operator==(const state_t &other) const {
        return true;  // 根据具体问题实现
    }
};

// 定义hash函数

// 方法1：模板特化，当hash函数只需要状态本身，不需要其他数据时，用这个方法比较简洁
namespace std {
template<> struct hash<state_t> {
    size_t operator()(const state_t & x) const {
        return 0; // 根据具体问题实现
    }
};
}

// 方法2：函数对象，如果hash函数需要运行时数据，则用这种方法
class Hasher {
public:
    Hasher(int _m) : m(_m) {};
    size_t operator()(const state_t &s) const {
        return 0; // 根据具体问题实现
    }
private:
    int m; // 存放外面传入的数据
};

/**
 * @brief 反向生成路径，求一条路径.
 * @param[in] father 树
 * @param[in] target 目标节点
 * @return 从起点到target的路径
 */
vector<state_t> gen_path(const unordered_map<state_t, state_t> &father,
        const state_t &target) {
    vector<state_t> path;
    path.push_back(target);

    for (state_t cur = target; father.find(cur) != father.end(); 
            cur = father.at(cur))
        path.push_back(cur);

    reverse(path.begin(), path.end());

    return path;
}

/**
 * 反向生成路径，求所有路径.
 * @param[in] father 存放了所有路径的树
 * @param[in] start 起点
 * @param[in] state 终点
 * @return 从起点到终点的所有路径
 */
void gen_path(unordered_map<state_t, vector<state_t> > &father,
        const string &start, const state_t& state, vector<state_t> &path,
        vector<vector<state_t> > &result) {
    path.push_back(state);
    if (state == start) {
        if (!result.empty()) {
            if (path.size() < result[0].size()) {
                result.clear();
                result.push_back(path);
            } else if(path.size() == result[0].size()) {
                result.push_back(path);
            } else {
                // not possible
                throw std::logic_error("not possible to get here");
            }
        } else {
            result.push_back(path);
        }
        reverse(result.back().begin(), result.back().end());
    } else {
        for (const auto& f : father[state]) {
            gen_path(father, start, f, path, result);
        }
    }
    path.pop_back();
}
```


### 求最短路径长度或一条路径

**单队列的写法**

```cpp
#include "bfs_common.h"

/**
 * @brief 广搜，只用一个队列.
 * @param[in] start 起点
 * @param[in] data 输入数据
 * @return 从起点到目标状态的一条最短路径
 */
vector<state_t> bfs(state_t &start, const vector<vector<int>> &grid) {
    queue<state_t> q; // 队列
    unordered_set<state_t> visited; // 判重
    unordered_map<state_t, state_t> father; // 树，求路径本身时才需要

    // 判断状态是否合法
    auto state_is_valid = [&](const state_t &s) { /*...*/ };

    // 判断当前状态是否为所求目标
    auto state_is_target = [&](const state_t &s) { /*...*/ };

    // 扩展当前状态
    auto state_extend = [&](const state_t &s) {
        unordered_set<state_t> result;
        for (/*...*/) {
            const state_t new_state = /*...*/;
            if (state_is_valid(new_state) && 
                    visited.find(new_state) != visited.end()) {
                result.insert(new_state);
            }
        }
        return result;
    };

    assert (start.level == 0);
    q.push(start);
    while (!q.empty()) {
        // 千万不能用 const auto&，pop() 会删除元素，
        // 引用就变成了悬空引用
        const state_t state = q.front();
        q.pop();
        visited.insert(state);

        // 访问节点
        if (state_is_target(state)) {
            return return gen_path(father, target); // 求一条路径
            // return state.level + 1; // 求路径长度
        }

        // 扩展节点
        vector<state_t> new_states = state_extend(state);
        for (const auto& new_state : new_states) {
            q.push(new_state);
            father[new_state] = state;  // 求一条路径
            // visited.insert(state); // 优化：可以提前加入 visited 集合，
            // 从而缩小状态扩展。这时 q 的含义略有变化，里面存放的是处理了一半
            // 的节点：已经加入了visited，但还没有扩展。别忘记 while循环开始
            // 前，要加一行代码, visited.insert(start)
        }
    }

    return vector<state_t>();
    //return 0;
}
```


**双队列的写法**

```cpp
#include "bfs_common.h"

/**
 * @brief 广搜，使用两个队列.
 * @param[in] start 起点
 * @param[in] data 输入数据
 * @return 从起点到目标状态的一条最短路径
 */
vector<state_t> bfs(const state_t &start, const type& data) {
    queue<state_t> next, current; // 当前层，下一层
    unordered_set<state_t> visited; // 判重
    unordered_map<state_t, state_t> father; // 树，求路径本身时才需要

    int level = -1;  // 层次

    // 判断状态是否合法
    auto state_is_valid = [&](const state_t &s) { /*...*/ };

    // 判断当前状态是否为所求目标
    auto state_is_target = [&](const state_t &s) { /*...*/ };

    // 扩展当前状态
    auto state_extend = [&](const state_t &s) {
        unordered_set<state_t> result;
        for (/*...*/) {
            const state_t new_state = /*...*/;
            if (state_is_valid(new_state) && 
                    visited.find(new_state) != visited.end()) {
                result.insert(new_state);
            }
        }
        return result;
    };

    current.push(start);
    while (!current.empty()) {
        ++level;
        while (!current.empty()) {
            // 千万不能用 const auto&，pop() 会删除元素，
            // 引用就变成了悬空引用
            const auto state = current.front();
            current.pop();
            visited.insert(state);

            if (state_is_target(state)) {
                return return gen_path(father, state); // 求一条路径
                // return state.level + 1; // 求路径长度
            }

            const auto& new_states = state_extend(state);
            for (const auto& new_state : new_states) {
                next.push(new_state);
                father[new_state] = state;
                // visited.insert(state); // 优化：可以提前加入 visited 集合，
                // 从而缩小状态扩展。这时 current 的含义略有变化，里面存放的是处
                // 理了一半的节点：已经加入了visited，但还没有扩展。别忘记 while
                // 循环开始前，要加一行代码, visited.insert(start)
            }
        }
        swap(next, current); //!!! 交换两个队列
    }

    return vector<state_t>();
    // return 0;
}
```


### 求所有路径

**单队列**


```cpp
/**
 * @brief 广搜，使用一个队列.
 * @param[in] start 起点
 * @param[in] data 输入数据
 * @return 从起点到目标状态的所有最短路径
 */
vector<vector<state_t> > bfs(const state_t &start, const type& data) {
    queue<state_t> q;
    unordered_set<state_t> visited; // 判重
    unordered_map<state_t, vector<state_t> > father; // DAG

    auto state_is_valid = [&](const state_t& s) { /*...*/ };
    auto state_is_target = [&](const state_t &s) { /*...*/ };
    auto state_extend = [&](const state_t &s) {
        unordered_set<state_t> result;
        for (/*...*/) {
            const state_t new_state = /*...*/;
            if (state_is_valid(new_state)) {
                auto visited_iter = visited.find(new_state);

                if (visited_iter != visited.end()) {
                    if (visited_iter->level < new_state.level) {
                        // do nothing
                    } else if (visited_iter->level == new_state.level) {
                        result.insert(new_state);
                    } else { // not possible
                        throw std::logic_error("not possible to get here");
                    }
                } else {
                    result.insert(new_state);
                }
            }
        }

        return result;
    };

    vector<vector<string>> result;
    state_t start_state(start, 0);
    q.push(start_state);
    visited.insert(start_state);
    while (!q.empty()) {
        // 千万不能用 const auto&，pop() 会删除元素，
        // 引用就变成了悬空引用
        const auto state = q.front();
        q.pop();

        // 如果当前路径长度已经超过当前最短路径长度，
        // 可以中止对该路径的处理，因为我们要找的是最短路径
        if (!result.empty() && state.level + 1 > result[0].size()) break;

        if (state_is_target(state)) {
            vector<string> path;
            gen_path(father, start_state, state, path, result);
            continue;
        }
        // 必须挪到下面，比如同一层A和B两个节点均指向了目标节点，
        // 那么目标节点就会在q中出现两次，输出路径就会翻倍
        // visited.insert(state);

        // 扩展节点
        const auto& new_states = state_extend(state);
        for (const auto& new_state : new_states) {
            if (visited.find(new_state) == visited.end()) {
                q.push(new_state);
            }
            visited.insert(new_state);
            father[new_state].push_back(state);
        }
    }

    return result;
}
```


**双队列的写法**


```cpp
#include "bfs_common.h"

/**
 * @brief 广搜，使用两个队列.
 * @param[in] start 起点
 * @param[in] data 输入数据
 * @return 从起点到目标状态的所有最短路径
 */
vector<vector<state_t> > bfs(const state_t &start, const type& data) {
    // 当前层，下一层，用unordered_set是为了去重，例如两个父节点指向
    // 同一个子节点，如果用vector, 子节点就会在next里出现两次，其实此
    // 时 father 已经记录了两个父节点，next里重复出现两次是没必要的
    unordered_set<string> current, next;
    unordered_set<state_t> visited; // 判重
    unordered_map<state_t, vector<state_t> > father; // DAG

    int level = -1;  // 层次

    // 判断状态是否合法
    auto state_is_valid = [&](const state_t &s) { /*...*/ };

    // 判断当前状态是否为所求目标
    auto state_is_target = [&](const state_t &s) { /*...*/ };

    // 扩展当前状态
    auto state_extend = [&](const state_t &s) {
        unordered_set<state_t> result;
        for (/*...*/) {
            const state_t new_state = /*...*/;
            if (state_is_valid(new_state) && 
                    visited.find(new_state) != visited.end()) {
                result.insert(new_state);
            }
        }
        return result;
    };

    vector<vector<state_t> > result;
    current.insert(start);
    while (!current.empty()) {
        ++ level;
        // 如果当前路径长度已经超过当前最短路径长度，可以中止对该路径的
        // 处理，因为我们要找的是最短路径
        if (!result.empty() && level+1 > result[0].size()) break;

        // 1. 延迟加入visited, 这样才能允许两个父节点指向同一个子节点
        // 2. 一股脑current 全部加入visited, 是防止本层前一个节点扩展
        // 节点时，指向了本层后面尚未处理的节点，这条路径必然不是最短的
        for (const auto& state : current)
            visited.insert(state);
        for (const auto& state : current) {
            if (state_is_target(state)) {
                vector<string> path;
                gen_path(father, path, start, state, result);
                continue;
            }

            const auto new_states = state_extend(state);
            for (const auto& new_state : new_states) {
                next.insert(new_state);
                father[new_state].push_back(state);
            }
        }

        current.clear();
        swap(current, next);
    }

    return result;
}
```
