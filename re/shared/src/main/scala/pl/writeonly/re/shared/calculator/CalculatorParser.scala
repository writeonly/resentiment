package pl.writeonly.re.shared.calculator

class CalculatorParser {
  def eval(tree: (Int, Seq[(String, Int)])): Int = {
    val (base, ops) = tree
    ops.foldLeft(base) {
      case (left, (op, right)) => evalOp(op, left, right)
    }
  }

  private def evalOp(op: String, left: Int, right: Int): Int = op match {
    case "+" => left + right
    case "-" => left - right
    case "*" => left * right
    case "/" => left / right
  }

  import fastparse.all._

  val number: P[Int] = P(CharIn('0' to '9').rep(1).!.map(_.toInt))
  val parens: P[Int] = P("(" ~/ addSub ~ ")")
  val factor: P[Int] = P(number | parens)

  val divMul: P[Int] = P(factor ~ (CharIn("*/").! ~/ factor).rep).map(eval)
  val addSub: P[Int] = P(divMul ~ (CharIn("+-").! ~/ divMul).rep).map(eval)
  val expr: P[Int] = P(addSub ~ End)
}
