package pl.writeonly.re.shared.hyde.impl.thirdparty.thirdparty4

import pl.writeonly.re.shared.hyde.common.states.api._

object TaskHyde {

  private val domain = "https://www.writeonly.pl"

  def main(args: Array[String]): Unit = apply().showResult()

  def apply(): DisjunctionAPIState = applyTask().unsafePerformSync

  def applyTask(): ParallelStateTask = TaskState(domain)

}
