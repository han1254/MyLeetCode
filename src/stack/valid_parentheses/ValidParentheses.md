方法一 :
```java
private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        //循环遍历
        for (int i = 0; i < str.length(); i+ +) {
            //如果第一个就为右括号，直接报错
            if (i == 0 && !isLeft(str.charAt(i)))
                return false;
            char temp = str.charAt(i);
            if (isLeft(temp)) {
                //左括号，入栈
                stack.push(temp);
            } else {
                //栈空，但是还有右括号，返回错误
                if (stack.isEmpty()) {
                    return false;
                }
                //遇到的右括号与左括号不成对，返回错误
                if (!isPair(stack.pop(), temp)) {
                    return false;
                }
            }
        }
        //如果遍历完了，还有左括号在里面，返回错误
        return stack.isEmpty();
    }
```

<img src="img/合理括号.PNG">    

😀：很明显，内存消耗太大，需要继续优化  

---