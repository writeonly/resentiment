package pl.writeonly.re.shared.hyde.common.states.notexception

trait AbstractNewSetState extends AbstractNextState {

  final def next: AbstractNextState = newState(newSet)

  def newSet: SET
}
