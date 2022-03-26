package Fastcampus;

public class DoubleLinkedList<T>{
    public Node<T> head = null;              // 기존의 링크드 리스트는 헤드가 있다고 한다면
    public Node<T> tail = null;              // 더블링크드 리스트는 테일이라는 변수 하나 더 생산해야한다.

    public class Node<T>{
        T data;
        Node<T> prev = null;                  // 앞에 있는 노드를 가르키는 포인터
        Node<T> next = null;                  // 그 다음의 노드를 가르키는 포인터

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){
            this.head = new Node<T>(data);          // 만약 헤드가 없다면, 노드를 새로 만들어준다.
            this.tail = this.head;                  // 데이터가 하나이므로, 테일 또한 헤드로 둔다.
        }else{
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;                   // 새로운 데이터의 노드의 prev를 현재의 노드에 추가하면 된다.
            this.tail = node.next;                   // 마지막의 노드를 가르키는 tail은 맨 마지막에 있는 것을 가르키면 된다.
        }
    }

    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){         // 내가 찾는 데이터가 노드의 데이터랑 같다면 그 값을 출력
                    return node.data;
                }else{
                    node = node.next;            // 그렇지 않다면 다음 노드로 돌리기.
                }
            }

            return null;                         // while구문을 끝나게 되었으므로 null값을 출력
        }
    }

    public T searchFromTail(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.tail;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.prev;               // 노드의 뒤로 돌아서 가야하므로 prev를 넣어야함
                }
            }

            return null;                            // 찾는 값이 없으므로 null로 표현
        }
    }

    public boolean insertToFront(T existedData, T addData){
        if(this.head == null){
            this.head  = new Node<T>(addData);                  // 만약 head가 없다면 그냥 데이터를 추가해서 넣으면 된다.
            this.tail = this.head;
            return true;
        }else if(this.head.data == existedData){               // 헤드가 내가 찾는 노드일 경우
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;                                 // ?? 이게 뭘까 ?
            return true;
        }else{                                               // 헤드가 아니라 그 다음들 중 노드의 경우
            Node<T> node = this.head;
            while(node != null){
                if(node.data == existedData){            // 내가 찾는 노드가 있다라면
                    Node<T> nodePrev = node.prev;          // 내가 찾는 노드의 prev를 새로운 변수에 넣어둠

                    nodePrev.next = new Node<T>(addData);     // 그 prev의 다음 포인터를 내가 새롭게 넣을 데이터에 넣어둠
                    nodePrev.next.next = node;                // node.Prev.next.next는 결국 내가 새롭게 넣을 데이터의 다음 포인터를 의미
                                                              // 그 다음 포인터를 가르키는 곳은 현재 내가 찾은 데이터로 가야함

                    nodePrev.next.prev = nodePrev;           // 내가 생성할 데이터의 prev는 nodePrev를 가르키고 있어야함
                    node.prev = nodePrev.next;               // 찾은 노드의 prev는 내가 생성할 데이터로 가르켜야 한다.

                   return true;
                }else{
                    node = node.next;                        // 만약 데이터를 찾은게 아니라면 다음 데이터에 넘김
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(5);
        doubleLinkedList.addNode(10);

        doubleLinkedList.printAll();
        System.out.println("-------------------------");

        doubleLinkedList.insertToFront(5,22);
        doubleLinkedList.insertToFront(21,25);
        doubleLinkedList.printAll();
    }

}
