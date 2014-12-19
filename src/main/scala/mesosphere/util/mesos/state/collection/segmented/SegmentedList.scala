package mesosphere.util.mesos.state.collection.segmented

import mesosphere.util.mesos.state.collection.PersistentList
import mesosphere.util.mesos.state.ValueFormatter
import org.apache.mesos.state.State

class SegmentedList[T](
    state: State,
    formatter: ValueFormatter[T]) extends PersistentList[T] {

  // TODO

}

