package code_03;

public class Array_To_Stack_Queue {

    public static class ArrayStack{
        private int[] arr;
        private int size;

        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            arr = new int[initSize];
            size = 0;
        }

        public int peek(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return arr[size-1];
        }

        public void push(int obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException();
            }
            arr[size++] = obj;
        }

        public int pop(){
            if(size ==0)
                throw new ArrayIndexOutOfBoundsException();
            return arr[--size];
        }
    }


    public static class ArrayQueue{

        private int[] arr;
        private int size;
        private int first;
        private int last;

        public ArrayQueue(int initSize){
            if(initSize < 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            arr = new int[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public int peek(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return arr[first];
        }

        public void push(int obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException();
            }
            size ++;
            arr[last] = obj;
            last = last==arr.length-1?0:last+1;
        }

        public int poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            size --;
            int tmp = first;
            first=first==arr.length-1?0:first+1;
            return arr[tmp];
        }
    }
}































