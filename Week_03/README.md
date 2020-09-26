## 递归套路模板
```java
    /**
     * 递归模板
     *
     * @param level
     * @param param
     */
    public void backtrack(int level, String param) {

        // 1.递归推出条件
        if (level > MAX) {
            return;
        }

        // 2.process处理逻辑
        process(param);

        // 3.下探
        backtrack(level + 1, param);

        // 4.清理本层状态（如果需要）
    }
```
##  分治套路模板
```java
    /**
     * 分治模板
     *
     */
    public int divide_conquer(Problem problem,) {
        // 1.推出条件
        if (problem == NULL) {
            int res = process_last_result();
            return res;
        }
        
        // 2.prepare data 处理逻辑
        subProblems = split_problem(problem)

        // 3.conquer subproblems 处理子问题
        res0 = divide_conquer(subProblems[0])
        res1 = divide_conquer(subProblems[1])

        // 4.process and generate final result 处理合并子问题
        result = process_result(res0, res1);

        // revert current states 清理本层状态（如果需要）
        return result;
    }
```

