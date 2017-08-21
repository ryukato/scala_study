object SimpleClientCodeTest {
  def main(args: Array[String]): Unit = {
    println(containsNeg(List(-1, 1, 2,3,4,5)))
  }

  def containsNeg(nums: List[Int]): Boolean = nums.exists(_ < 0)

}
