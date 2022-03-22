# 꼭 알아둬야 할 자료구조: 스택(Stack)
데이터를 제한적으로 접근할 수 있는 구조: 한쪽 끝에서만 자료를 넣거나 뺀다.

![image](https://user-images.githubusercontent.com/80665963/159161137-0facddbe-e5d5-46d5-bc93-18b3e9fbf97e.png)
### FILO(First In, Last Out) 형식


## 1. 스택의 구조 
* 스택은 FILO 데이터 관리 방식을 따른다 ( 맨 처음 넣은 데이터가 맨 나중에 나옴 )
* 스택의 주요 기능 
  * push() : 데이터를 스택에 넣기
  * pop() : 데이터를 스택에서 꺼내기


## 2. 자료구조 스택의 장,단점
* 장점
  * 구조가 단순해서 구현이 쉽다.
  * 데이터 저장/ 읽기 속도가 빠르다.
* 단점
  * **데이터 최대 개수를 미리 정해야 한다.**
  * 저장 공간의 낭비가 발생할 수 있다.

### [스택의 예시](https://github.com/gloz0315/Algorithm/blob/main/%EC%8A%A4%ED%83%9D%2C%ED%81%90/Stack.java)

## 


# 꼭 알아둬야 할 자료구조: 큐(Queue)
가장 먼저 넣는 데이터를 가장 먼저 꺼낼 수 있는 자료구조
![image](https://user-images.githubusercontent.com/80665963/159416390-54b91950-b171-48c6-8c49-c991328233a1.png)
### FIFO(First In, First Out) 형식

## 1. 큐의 구조
* 큐는 FIFO 데이터 관리 방식을 따른다 ( 맨 처음 넣은 데이터가 맨 처음 나옴 )
* 큐의 주요 기능
  * add(), offer() : 데이터를 큐에 넣기
  * poll(), remove() : 데이터를 큐에서 제거하기
