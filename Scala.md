# Scala
## Functional Concept
### Mathmatical functions
- x -> f(x)
- f(x) = x*2
- f:X -> Y
- y = f(x)

### Side Effect
#### Description (or Definition)
Application이 실행되는 환경(Ram, disk, IO etc...)내에서 정의되고 사용되는 객체 혹은 변수의 상태(혹은 값)이 변경되는 것을 의미한다. 
예를 들어, 아래와 같은 것들이 side effect일 수 있다. 
- 변수의 값 변경
- 디스크에 값을 쓰는 것
- 사용자 interface에서 버튼의 활성/비활성 

그러면 side effect는 나쁜 것인가? 좋은 것인가?라는 의문이 생길 수 있다. side effect는 좋지도 나쁘지도 않다. 다만 applicaton(혹은 function)을 작성하는 프로그래머가 이를 고려하지 않을 경우에는 의도 하지 않은 결과가 나올 수 있습니다. 때문에 되도록 side effect가 발생하지 않도록 하는 것이 좋지만, side effect를 피할수 없는 경우에는 반드시 이를 고려해서 application(혹은 function)등을 작성해야 합니다. 

#### Code examples
##### With side effect

```
var x = 0;
x = 3 + 4; // this statement has side effect
```

##### Without side effect

```
def f = 3 + 4
```

### Referential Transparency
#### Description (or Definition)
공식적인 정의는 없는 것으로 보이지만, 보통 어떤 상황에서든지 함수 등이 동일한 입력값에 대해 동일한 결과값을 도출하는 것을 의미한다. 
다음의 예는 referential transparency 하다라고 할 수 있다.

```
def f = 2 + 2
```
위의 예제는 너무도 간단해서 실제로 사용하기에는 무리가 있다. 다음의 예제를 살펴보면

```
def even(number: Int): Boolean = number %2 == 0
def f = (1 to 10).filter(even)
```
위의 예제에 선언된 even과 f는 동일한 입력값에 대해 동일한 결과를 반환한다. 

#### ref sites
- [Referential Transparency, And The True Meaning Of Functional Programming](http://monospacedmonologues.com/post/138204666541/referential-transparency-and-the-true-meaning-of)


### Immutable state


## Scala basic syntax