package code_03;

import java.util.Stack;

public class GetMinStack {

    public static class MyStack{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyStack(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int obj){
            if(stack2.isEmpty()){
                stack2.push(obj);
            }else if(obj <= stack2.peek()){
                stack2.push(obj);
            }
            stack1.push(obj);
        }

        public Integer pop(){
            if(stack1.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            if(stack1.peek() <= stack2.peek()){
                stack2.pop();
            }
            return stack1.pop();
        }

        public Integer getMin(){
            if(stack2.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return stack2.peek();
        }
    }

    public static class MyStack2{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyStack2(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int obj){
            if(stack2.isEmpty()){
                stack2.push(obj);
            }else if(obj <= stack2.peek()){
                stack2.push(obj);
            }else{
                stack2.push(stack2.peek());
            }
            stack1.push(obj);
        }

        public Integer pop(){
            if(stack1.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            this.stack2.pop();
            return this.stack1.pop();
        }

        public Integer getMin(){
            if(stack2.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
