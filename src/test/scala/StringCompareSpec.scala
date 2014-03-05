import org.scalameter.api._

object PrependPerformance extends PerformanceTest.Quickbenchmark {
  val compares = Gen.enumeration("compare")(StringCompare.upperEq,
                                            StringCompare.lowerEq,
                                            StringCompare.nocaseEq,
                                            StringCompare.nocaseLower,
                                            StringCompare.nocaseUpper,
                                            StringCompare.upperGt,
                                            StringCompare.lowerGt,
                                            StringCompare.upperCmp,
                                            StringCompare.lowerCmp,
                                            StringCompare.nocaseCmp )

  val pctEqual = Gen.enumeration("pctEqual")(5, 33, 50, 75)
  val words = scala.io.Source.fromFile("/usr/share/dict/words").getLines.to[Array]

  val comparesAndPct = for {
    c ← compares
    pct ← pctEqual
  } yield c→pct


  performance of "equals" in {
    measure method "equals" in {
      using(comparesAndPct) in { cap ⇒
        for(i ← 0 to 1000000) {
          val equal: Boolean = util.Random.nextInt(100) < cap._2
          val word1: String = words(util.Random.nextInt(words.length))
          val word2: String = words(util.Random.nextInt(words.length))
          if(equal)
            cap._1.cmp(word1, word1)
          else
            cap._1.cmp(word1, word2)
        }
      }
    }
  }
}
