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