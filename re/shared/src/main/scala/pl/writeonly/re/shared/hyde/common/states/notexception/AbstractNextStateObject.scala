package pl.writeonly.re.shared.hyde.common.states.notexception

import pl.writeonly.re.shared.hyde.common.url.Domain
import scalaz.Scalaz._

trait AbstractNextStateObject {

  def fromDomain(implicit d: Domain): AbstractNextState

  def apply(domain: String): AbstractNextState = fromDomain(new Domain(domain)) |> AbstractNextState.run
}
