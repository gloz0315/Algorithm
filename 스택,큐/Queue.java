package Fastcampus;
import java.util.ArrayList;

public class Queue<T> {                                    // 제네릭 타입을 쓸 것이므로 <T>를 넣어준다
    private ArrayList<T> queue = new ArrayList<>();        // 큐를 위한 공간을 만들며 여기에서도 제네릭 타입이 들어가야함.

    public void enqueue(T item){              // 별다른 return값이 없는 값을 넣는것을 의미하기에 void를 쓴다
        queue.add(item);
    }

    public T dequeue(){                      // dequeue같은 경우에는 값을 꺼내오므로 인자가 필요 없다.
        if(queue.isEmpty()){                 // queue 안에 값이 있는지 없는지 확인하기 위해서
            return null;
        }else{
            return queue.remove(0);      // ArrayList에 해당되는 인덱스 번호의 값을 지정해줘야 한다!
            // 해당 인덱스 번호의 값을 삭제하는 것이므로!
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();                // 큐 안에 데이터가 있는지 없는지 확인하기 위해
    }

    public static void main(String[] args) {
        Queue<Integer> que = new Queue<>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        System.out.println(que.dequeue());
        System.out.println(que.isEmpty());
        System.out.println(que.dequeue());
        System.out.println(que.isEmpty());
        System.out.println(que.dequeue());
        System.out.println(que.isEmpty());
    }
}
