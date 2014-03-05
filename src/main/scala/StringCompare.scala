
trait StringCompare {
  def cmp(s1: String, s2: String): Any
}

object StringCompare {
  val upperEq = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toUpperCase.equals(s2.toUpperCase) 
    override def toString = "upperEq"
  }
  val lowerEq = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toLowerCase.equals(s2.toLowerCase)
    override def toString = "lowerEq"
  }
  val nocaseEq = new StringCompare {
    def cmp(s1: String, s2: String) = s1.equalsIgnoreCase(s2)
    override def toString = "nocaseEq"
  }
  val upperGt = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toUpperCase > s2.toUpperCase
    override def toString = "upperGt"
  }
  val lowerGt = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toLowerCase > s2.toLowerCase
    override def toString = "lowerGt"
  }
  val upperCmp = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toUpperCase.compareTo(s2.toUpperCase)
    override def toString = "upperCmp"
  }
  val lowerCmp = new StringCompare {
    def cmp(s1: String, s2: String) = s1.toLowerCase.compareTo(s2.toLowerCase)
    override def toString = "lowerCmp"
  }
  val nocaseCmp = new StringCompare {
    def cmp(s1: String, s2: String) = s1.compareToIgnoreCase(s2)
    override def toString = "nocaseCmp"
  }
}
