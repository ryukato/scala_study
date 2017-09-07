object Solution {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  def lcm(a: Int, b: Int): Int = {
    if (a == 0 || b== 0) 0
    else a * (b / gcd(a, b))
  }

  def getTotalX(a: Array[Int], b: Array[Int]): Int =  {
        val gcdVal = b.reduceLeft(gcd(_ , _)
        val lcmVal = a.reduceLeft(lcm(_ , _)
        
        val result = for {
          s <- lcmVal.to(gcdVal)
          if (s => s % lcmVal == 0 && gcdVal % s == 0)
        } yield s

        result.size
  }

  def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in);
      var n = sc.nextInt();
      var m = sc.nextInt();
      var a = new Array[Int](n);
      for(a_i <- 0 to n-1) {
         a(a_i) = sc.nextInt();
      }
      var b = new Array[Int](m);
      for(b_i <- 0 to m-1) {
         b(b_i) = sc.nextInt();
      }
      val total = getTotalX(a, b);
      println(total)
  }

}
