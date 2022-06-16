package com.experiment.algo.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuruohong
 * @date 2022-06-15 22:50
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意 两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 提示：
 *
 *     1 <= tokens.length <= 104
 *     tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NibolanExpress {



    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }
        Stack<String> s = new Stack<>();
        for(int i = 0; i < tokens.length; i ++) {
            if(tokens[i].equals("+")) {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                String str = b + a + "";
                s.push(str);
            }
            else if(tokens[i].equals("-")) {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                String str = b - a + "";
                s.push(str);
            }
            else if(tokens[i].equals("*")) {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                String str = b * a + "";
                s.push(str);
            }
            else if(tokens[i].equals("/")) {
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                String str = (int)(b / a) + "";
                s.push(str);
            } else {
                s.push(tokens[i]);
            }
        }
        return Integer.valueOf(s.pop());
    }

    public int evalRPNV2(String[] tokens) {
        //Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    @Test
    public void Test128() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        Deque<Integer> stack = new LinkedList<Integer>();
        stack.add(1);
        stack.add(2);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());


    }

}
