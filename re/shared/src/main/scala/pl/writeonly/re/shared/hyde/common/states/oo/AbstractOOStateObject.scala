package pl.writeonly.re.shared.hyde.common.states.oo

import pl.writeonly.re.shared.hyde.common.url.Domain
import scalaz.Scalaz._

trait AbstractOOStateObject {

  def fromDomain(implicit d: Domain): AbstractOOState

  def apply(domain: String): AbstractOOState = fromDomain(new Domain(domain)) |> AbstractOOState.run
}
