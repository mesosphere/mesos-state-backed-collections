package mesosphere.util.mesos.state

import mesosphere.util.mesos.state.collection.segmented._
import org.apache.mesos.state.State

class SegmentedWrappedState[T](
    protected val state: State,
    protected val formatter: ValueFormatter[T]) extends WrappedState[T] {

  override protected def newList =
    new SegmentedList(state, formatter)

  override protected def newSet =
    new SegmentedSet(state, formatter)

  override protected def newMap =
    new SegmentedMap(state, formatter)

}
