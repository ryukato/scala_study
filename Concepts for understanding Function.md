# Concepts for understanding Function
## Call-by-Name
일반적으로 함수 호출 시 전달되는 매개변수(parameter)는 값 자체(**by-value**)가 전달된다. 함수로 매개변수를 전달하기 전에 evaluation을 거쳐 매개변수의 값을 확정지어 전달한다고 보면 된다. 
그렇지만 함수내에서 전달된 매개변수가 사용되기 전까지 evaluation되지 않기를 원할 경우에는 어떻게 해야 할까? 이런 경우 이름 혹은 참조(**by-name**)로 전달되는 매개변수를 사용하면 된다.

혹은 참조(**by-name**)로 전달되는 매개변수는 코드 블럭으로 전달이 되며, 이 코드블럭은 호출될때마다 값을 반환한다. 

아래의 예제를 살펴보자. delayed라는 함수에 전달되는 매개변수 t는 Long타입의 값을 반환하는 함수(코드블럭)으로 선언되어 있다. 그리고 delayed에 전달되는 time함수는 현재의 nano 시간을 반환한다. 
그런데 결과를 보면 delayed에 t가 전달되는 시점에 t가 호출되는 것이 아닌, delayed안에서 t가 호출될때 결과를 반환한다. 

```
object Demo extends App {
  def time(): Long = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  def delayed(t : => Long) : Unit = {
    println("In delayed method")
    println("Param: t = " + t)
  }

  delayed(time())
  //delayed(time) 이렇게 호출해도 된다.
}

```

###### output
```
In delayed method
Getting time in nano seconds
Param: t = 685694529343121
```

## Functions with Named Arguments
매개변수를 받는 함수를 선언하고, 해당 함수에 선언된 매개변수를 전달할때 선언된 이름으로 전달하여 함수를 호출하는 것을 말한다. 예제를 보면 쉽게 이해할 수 있다. 

```
object Demo extends App {
  def printInt(a: Int, b: Int) : Unit = {
    println("value of a = " + a)
    println("value of b = " + b)
  }

  printInt(b = 5, a = 7)
}

```

###### output

```
value of a = 7
value of b = 5
```

## Variable Arguments
자바에서 사용할 수 있는 가변인자(예: String...strs)와 같은 것을 말한다. 선언 및 사용하는 방식은 자바와 크게 다르지 않으며, 다음과 같다.

```
object Demo extends App {
  def printStrings(args: String*): Unit = {
    var i: Int = 0
    for(arg <- args){
      println("Arg value["+i+"] = " + arg)
      i = i + 1;
    }
  }

  printStrings("Hello", "Scala", "Python");
}

```

###### output
```
Arg value[0] = Hello
Arg value[1] = Scala
Arg value[2] = Python
```

## Recursion (재귀)
재귀 함수는 함수형 프로그래밍에서 많이 사용이 된다. 재귀 함수는 자신을 반복해서 여러번 호출 하는 것을 의미한다. 
아래의 factorial의 예제 코드가 재귀 함수의 좋은 예가 된다.

```
object Demo extends App{
  def factorial(n: BigInt): BigInt = {
    if(n <= 1){
      1
    }else{
      n*factorial(n-1)
    }
  }

  for(i <- 1 to 10){
    println("Fatorial of " + i + ": = " + factorial(i))
  }
}

```

###### output

```
Fatorial of 1: = 1
Fatorial of 2: = 2
Fatorial of 3: = 6
Fatorial of 4: = 24
Fatorial of 5: = 120
Fatorial of 6: = 720
Fatorial of 7: = 5040
Fatorial of 8: = 40320
Fatorial of 9: = 362880
Fatorial of 10: = 3628800
```

일반적으로 함수를 호출하게되면 호출된 함수는 call stack에 추가가 된다. call stack을 통해 지역변수(local variable)을 사용하고 따라 갈 수 있다. 하지만 이 call stack의 사이즈는 제한적이다. 그렇기때문에 잘못 작성된 재귀를 실행할때 stack-over-flow라는 에러를 보게 되는 것이다. 

### Head Recursion
head recursion은 재귀적인 구조내에서 자신의 호출해서 반환된 값을 가지고 추가적인 계산이나 다른 작업을 수행하는 형태를 말한다. 
### Tail Recursion
tail recursion은 모든 계산 혹은 다른 작업은 자기 자신을 호출하기 이전에 모두 수행하고 자시 자신은 맨 마지막에 호출하는 형태를 말한다. tail recursion의 경우, 결론적으로 말하면 call stack의 stack frame의 사용을 거의 사용하지 않는다. 왜냐면 이미 지역변수의 계산을 마친 상태고 동일한 함수를 재귀적으로 호출하기 때문이다. 따라서 추적할 로컬 변수도 없고 동일한 함수를 다시 호출하기때문에 새로운 stack frame을 사용할 필요가 없어서 현재의 stack frame을 계속 재 사용하게 된다.

아래의 예제는 tail recursion 형태의 함수이다.

```
object Demo extends App{
  def listSum(list: List[Int]): Int = {
    def listSumHelper(list: List[Int], sum: Int): Int  = {
      if(list == Nil) sum
      else listSumHelper(list.tail, sum + list.head)
    }
    listSumHelper(list, 0)
  }

  var list1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(listSum(list1))
}

```

작성한 함수가 tail recursive인지 아닌지 확인하고자 한다면, @tailrec annotation을 붙여보면 된다. 아래처럼.

```
object Demo extends App{
  def listSum(list: List[Int]): Int = {
    @tailrec
    def listSumHelper(list: List[Int], sum: Int): Int  = {
      if(list == Nil) sum
      else listSumHelper(list.tail, sum + list.head)
    }
    listSumHelper(list, 0)
  }

  var list1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(listSum(list1))
}

```

tail recursive하지 않은 경우는 아래와 같은 compile에러를 보게 될 것이다. 

```
could not optimize @tailrec annotated method [메서드명]: it
contains a recursive call not in tail position
```
