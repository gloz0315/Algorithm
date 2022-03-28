package Fastcampus;

public class NodeMgmt {
    Node head = null;
    public class Node{
        Node left;
        Node right;
        int value;

        public Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data){
        //CASE1: Node가 하나도 없을 때
        if(this.head == null){
            this.head = new Node(data);
        }else{
            //CASE2: Node가 하나 이상 들어가 있을때
            Node findNode = this.head;

            while(true){
                //CASE2-1: 현재 Node의 왼쪽의 Node가 들어가야할 때
                if(data < findNode.value){      // data와 findNode의 값을 비교해서 findNode가 크다면
                    if(findNode.left != null){    // findNode에서 왼쪽에 노드가 null이 아닌 경우에는
                        findNode = findNode.left;     // 왼쪽 노드를 다시 기준으로 둔다
                    } else{
                        findNode.left = new Node(data);      // 왼쪽 노드에 데이터가 없다면, 노드를 새로 만들어서 data값을 넣는다.
                        break;   // while구문을 벗어나기 위해서
                    }
                }else{
                    //CASE2-2: 현재 Node의 오른쪽에 Node가 들어가야할 때
                    if(findNode.right != null){
                        findNode = findNode.right;     // findNode.right를 기준으로 둔다
                    }else{
                        findNode.right = new Node(data);      // 데이터가 없다면 새로운 노드를 생성
                        break;        // while구문을 벗어난다.
                    }
                }
            }
        }

        return true;      // 적절한 위치에 노드가 추가가 되었다.
    }

    public Node search(int data){
        // CASE1: Node가 하나도 없을 때
        if(this.head == null){
            return null;
        }else{
            // CASE2: Node가 하나 이상 있을 때

            Node findNode = this.head;            // 이게 Root Node를 의미한다.
            while(findNode != null){
                if(findNode.value == data){
                    return findNode;                 // 만약 내가 노드의 값이 맞다면 그대로 반환
                }else if(data < findNode.value){         // 왼쪽 노드를 의미한다.
                    findNode = findNode.left;             // 왼쪽 노드를 기준으로 설정
                }else{                                   // 오른쪽 노드를 의미한다.
                    findNode = findNode.right;
                }
            }

            return null;               // 열심히 찾았는데 결국에는 아무것도 안나온다면 null로 반환환
        }

    }

    public boolean delete(int value){
        boolean searched = false;                    // 해당 노드가 찾아지면 searched를 true로 변환한다.

        Node currParentNode = this.head;              // 현재의 부모 노드를 만들어서 head부터 시작
        Node currNode = this.head;                    // 현재의 노드를 만들어서 head부터 시작

        // 코너 케이스1: Node가 하나도 없을 때
        if(this.head == null){
            return false;
        }else{
            // 코너 케이스2: Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
            // 그 head의 값이 내가 찾는 value값이며 left,right이 둘다 null인, 즉 그 하나의 Node만 있는 경우
            if(this.head.value == value && this.head.left == null && this.head.right == null){
                this.head = null;     // 그 노드를 삭제한다.
                return true;
            }

            while(currNode != null){                  // 순회하기 위해 while문으로 쓴다.
                if(currNode.value == value){
                    searched = true;
                    break;
                }else if(value < currNode.value){
                    // 값이 현재의 값보다 작은 것은 왼쪽 노드 쪽에 있다는 것을 의미하기 때문
                    currParentNode = currNode;            // 현재의 노드를 ParentNode로 바꿔주고
                    currNode = currNode.left;             // left로 이동
                }else{
                    // 값이 현재의 값보다 큰 경우는 오른쪽 노드에 있다는 것을 의미
                    currParentNode = currNode;             // 현재의 노드를 ParentNode로 바꿔주고
                    currNode = currNode.right;             // right로 이동
                }
            }

            if(searched == false){
                return false;
            }
        }
        // 여기까지 실행되면, currNode에는 해당 데이터를 가지고 있는 Node
        // currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 Node


        //Case1: 삭제할 Node가 Leaf Node인 경우
        if(currNode.left == null && currNode.right == null){
            if(value < currParentNode.value){
                currParentNode.left = null;
                currNode = null;                 // 굳이 안써줘도 됨
            }else{
                currParentNode.right = null;
                currNode = null;                  // 굳이 안써줘도 됨
            }
            return  true;
        }else if(currNode.left != null && currNode.right == null){
            //Case2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(왼쪽에 있을 경우)
            if(value < currParentNode.value){
                currParentNode.left = currNode.left;           // 현재의 노드를 삭제할 것이니 현재의 노드의 왼쪽 노드를 Parent노드의 왼쪽 노드로 바꿔준다.
                currNode = null;
            }else{
                // ParentNode의 오른쪽에 삭제할 노드가 있는 경우
                currParentNode.right = currNode.left;          // 현재의 노드를 삭제할 것이니 현재의 노드의 왼쪽 노드를 Parent노드의 오른쪽 노드로 바꿔준다.
                currNode = null;
            }
            return  true;
        }else if(currNode.left == null && currNode.right != null){
            //Case2-2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(오른쪽에 있을 경우)
            if(value < currParentNode.value){
                currParentNode.left = currNode.right;           // 현재의 노드를 삭제할 것이니 현재의 노드의 오른쪽 노드를 Parent노드의 왼쪽 노드로 바꿔준다.
                currNode = null;
            }else{
                currParentNode.right = currNode.right;           // 현재의 노드를 삭제할 것이니 현재의 노드의 오른쪽 노드를 Parent노드의 오른쪽 노드로 바꿔준다.
                currNode = null;
            }
            return true;
        } else{
            // Case3-1 : 삭제할 Node가 Child Node를 두 개 가지고 있고, (삭제할 Node가 부모 Node의 왼쪽에 있을 때)

            //삭제할 Node가 부모 Node의 왼쪽에 있을 때
            if(value < currParentNode.value){

                Node changeNode = currNode.right; // 삭제할 노드의 오른쪽에 있기 때문
                Node changeParentNode = currNode.right;
                while(changeNode.left != null){      // 바꾸려는 노드의 left가 null이 아닌 경우 순회해서 가장 작은 값을 찾기
                    changeParentNode = changeNode;
                    changeNode = currNode.left;
                }
                // 가장 왼쪽에 위치하는 노드에 도착하게 됨
                // changeNode에는 삭제할 Node의 오른쪽 Node 중에서 가장 작은 값을 가진 Node가 들어가 있다.


                if(changeNode.right != null){
                    //Case 3-1-2:changeNode의 오른쪽 ChildNode가 있을 경우
                    changeParentNode.left = changeNode.right;

                }else{
                    //Case 3-1-1:changeNode의 ChildNode가 없을 경우
                    changeParentNode.left = null;
                }

                //currParentNode의 왼쪽 ChildNode에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;                    // currParentNode의 왼쪽 값을 바꿀 값에 연결하고
                changeNode.left = currNode.left;         // 삭제할 값의 왼쪽 자식 노드를 바꿀 값에 연결
                changeNode.right = currNode.right;        // 삭제할 값의 오른쪽 자식 노드를 바꿀 값에 연결

                currNode = null;     // 현재 노드는 삭제를 한다.



            }else{
                //Case3-2 삭제할 Node가 ChildNode를 두개 가지고 있을 경우
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음

                if (changeNode.right != null) {
                    // Case 3-2-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-2-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode 의 오른쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                // 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        NodeMgmt nodeMgmt = new NodeMgmt();

        nodeMgmt.insertNode(2);
        nodeMgmt.insertNode(3);
        nodeMgmt.insertNode(1);
        nodeMgmt.insertNode(15);
        nodeMgmt.insertNode(12);
        nodeMgmt.insertNode(21);
        nodeMgmt.insertNode(8);

        System.out.println(nodeMgmt.delete(10));
        System.out.println(nodeMgmt.search(2).left.value);
    }
}
