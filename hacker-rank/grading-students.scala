object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var grades = new Array[Int](n);
        val base = 38
        val mod = 5
        val mod_base =3

        for(grades_i <- 0 to n-1) {
           println(Grade(sc.nextInt(), base, mod, mod_base).g)
        }
    }

    case class Grade(g: Int, failed: Boolean) {
    }

    object Grade {
      def apply(g: Int, base: Int, mod: Int, mod_base: Int) = {
        if (g < base) new Grade(g, true)
        else if (g % mod < 3) new Grade(g, false)
        else new Grade(g + mod - (g % mod), false)
      }
    }
}
