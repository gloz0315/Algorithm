import java.util.ArrayList;

public class Stack<T>{
    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T item){
        stack.add(item);
    }

    public T pop(){
        if(stack.isEmpty()){
            return null;
        }else{
            return stack.remove(stack.size()-1);       // 스택은 FILO 데이터 방식을 따르기 때문에
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String args[]){
        Stack<Integer> ms = new Stack<Integer>();

        ms.push(1);
        ms.push(2);
        ms.push(3);

        System.out.println(ms.isEmpty());
        System.out.println(ms.pop());
        System.out.println(ms.isEmpty());
        System.out.println(ms.pop());
        System.out.println(ms.isEmpty());
        System.out.println(ms.pop());
        System.out.println(ms.isEmpty());

    }

}
