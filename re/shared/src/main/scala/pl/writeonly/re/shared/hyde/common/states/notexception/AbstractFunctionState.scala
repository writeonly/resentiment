package pl.writeonly.re.shared.hyde.common.states.notexception

import pl.writeonly.re.shared.hyde.common.url.typed.InternalUrl

trait AbstractFunctionState extends AbstractNewSetState {

  final def newSet: SET = nextUrls.map(impureFunction)

  def impureFunction: HPFromInternalUrl

  type HPFromInternalUrl = InternalUrl => HP
}
