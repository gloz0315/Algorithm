# 꼭 알아둬야 할 자료구조: 배열(Array)
데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터구조

* 배열은 왜 필요할까?
  * 같은 종류의 **데이터를 효율적으로 관리**하고 **데이터를 순차적으로 저장**하기 위해 사용

* 장점
  * 빠른 접근 가능 ( 첫 데이터의 위치에서 상대적인 위치로 데이터 접근 )
* 단점
  * 데이터 추가 / 삭제의 어려움 (**미리 최대 길이를 설정해야 함**)

## Java와 배열
* 1차원 배열은 [ ] 통해서 선언한다.
* 각 아이템은 { } 내에서 콤마로 작성한다.

```bash
Integer[] 변수형 = new Integer[];
```

```bash
int[] num = {1,2,3,4};
```

**배열은 고정된 크기를 갖고 있으므로 가변적이지 않다.**

**ArrayList 클래스는 가변길이의 배열 자료구조를 다룰 수 있는 기능을 한다.**

## List와 ArrayList의 선언 차이점
```bash
List<Integer> list1 = new ArrayList<Integer>();
ArrayList<Integer> list1 = new ArrayList<Integer>();
ArrayList<Integer> list1 = new ArrayList<>();
```
여기서의 List는 인터페이스이며, ArrayList는 클래스이다.

가변길이인 배열을 만들 때, 선언인 List나 ArrayList 둘 다 만들 수 있다.

### 배열 아이템 추가
```bash
list1.add(아이템);
```
### 배열 아이템 읽기, 특정 인덱스에 해당하는 아이템 변경 시
```bash
list1.get(인덱스 번호);
list1.set(인덱스 번호, 변경할 값);
```
### 배열 아이템 삭제 및 배열의 길이 확인하기
```bash
list1.remove(인덱스 번호);
list1.size();
```

### 배열에 들어가 있는 아이템 개수
```bash
배열.length;
```

* 문자 key가 해당 문자열에 있으면 해당 문자의 위치 ( index값 ) 을 리턴하고, 없으면 -1을 리턴하는 법
  * 문자열.indexOf(String key)
