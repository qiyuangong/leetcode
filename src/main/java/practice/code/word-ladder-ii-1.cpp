// Word Ladder II
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<string> > findLadders(const string& start,
        const string& end, const unordered_set<string> &dict) {
        queue<string> q;
        unordered_map<string, int> visited; // 判重
        unordered_map<string, vector<string> > father; // DAG

        auto state_is_valid = [&](const string& s) {
            return dict.find(s) != dict.end() || s == end;
        };
        auto state_is_target = [&](const string &s) {return s == end; };
        auto state_extend = [&](const string &s) {
            unordered_set<string> result;
            const int new_depth = visited[s] + 1;

            for (size_t i = 0; i < s.size(); ++i) {
                string new_state = s;
                for (char c = 'a'; c <= 'z'; c++) {
                    // 防止同字母替换
                    if (c == new_state[i]) continue;

                    swap(c, new_state[i]);

                    if (state_is_valid(new_state)) {
                        auto visited_iter = visited.find(new_state);

                        if (visited_iter != visited.end()) {
                            const int depth = visited_iter->second;
                            if (depth < new_depth) {
                                // do nothing
                            }
                            else if (depth == new_depth) {
                                result.insert(new_state);
                            }
                            else { // not possible
                                throw std::logic_error("not possible to get here");
                            }
                        }
                        else {
                            result.insert(new_state);
                        }
                    }
                    swap(c, new_state[i]); // 恢复该单词
                }
            }

            return result;
        };

        vector<vector<string>> result;
        q.push(start);
        visited[start] = 0;
        while (!q.empty()) {
            // 千万不能用 const auto&，pop() 会删除元素，
            // 引用就变成了悬空引用
            const auto state = q.front();
            q.pop();

            // 如果当前路径长度已经超过当前最短路径长度，
            // 可以中止对该路径的处理，因为我们要找的是最短路径
            if (!result.empty() && visited[state] + 1 > result[0].size()) break;

            if (state_is_target(state)) {
                vector<string> path;
                gen_path(father, start, state, path, result);
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
                    visited[new_state] = visited[state] + 1;
                }
                father[new_state].push_back(state);
            }
        }

        return result;
    }
private:
    void gen_path(unordered_map<string, vector<string> > &father,
        const string &start, const string &state, vector<string> &path,
        vector<vector<string> > &result) {
        path.push_back(state);
        if (state == start) {
            if (!result.empty()) {
                if (path.size() < result[0].size()) {
                    result.clear();
                }
                else if (path.size() == result[0].size()) {
                    // do nothing
                }
                else { // not possible
                    throw std::logic_error("not possible to get here ");
                }
            }
            result.push_back(path);
            reverse(result.back().begin(), result.back().end());
        }
        else {
            for (const auto& f : father[state]) {
                gen_path(father, start, f, path, result);
            }
        }
        path.pop_back();
    }
};