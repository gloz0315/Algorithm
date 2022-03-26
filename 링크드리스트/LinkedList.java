package Fastcampus;

public class LinkedList<T> { // 제너릭 타입 T로 뭐가 들어올지 모르는 것

    public Node<T> head = null;  // 링크드 리스트의 최초 헤드를 null이라고 둔다

    public class Node<T>{          // 노드를 만든다.
        T data;                    // 두개의 데이터를 가지고 있음 (데이터 값)
        Node<T> next = null;       // 포인트값

        public Node(T data){      // 생성자를 만들어서 데이터를 받으면 해당 데이터를 가지고 저장.
           this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data); // 만약 head가 없으면 노드를 하나 객체로 만들어서 넣어준다.
        }else{
            Node<T> node = this.head; // node를 현재 head로 두며

            while(node.next != null){ // 다음 포인터의 값이 있다면 ( 그 다음 노드의 값이 있다는 것을 의미하며 )
                node = node.next;     // 현재의 노드를 그 다음 노드로 바꾸면 된다. ( 원래 자기 자신을 가르키는 포인터를
                                      // 다음 노드로 바꿔준 다는 의미인것 같다 )

            }
                                      // 만약 그 다음의 노드의 값이 없다면 null을 의미하는 것이고 포인터는 마지막의 노드를 가리킬 것이다.

            node.next = new Node<T>(data);  // 현재의 노드는 맨 끝에 있는 노드이므로 맨 끝에 있는 노드의 포인터를 현재 데이터를 추가하는 노드로 연결시켜주면 된다.

        }
    }

    public void printAll(){              // 링크드리스트를 출력하기 위한 메서드
        if(head != null){                // head가 null이 아니여야 출력이 되므로!
            Node<T> node = this.head;    // node는 현재의 헤드부터 시작한다.
            System.out.println(node.data);  // 헤드에 있는 데이터를 출력
            while(node.next != null){          // 그 다음 포인터를 가르키는 값이 있다면
                node = node.next;              // 그 다음 포인터를 가르키는 노드를 현재의 노드에 넣고
                System.out.println(node.data);     // 그 노드의 데이터 값을 출력하면 된다.
            }
        }
    }

    public static void main(String args[]){
        LinkedList<Integer> node = new LinkedList<Integer>();
        node.addNode(1);
        node.addNode(2);
        node.printAll();
    }
}
