package mesosphere.util.mesos.state.collection.segmented

import mesosphere.util.mesos.state.collection.PersistentSet
import mesosphere.util.mesos.state.ValueFormatter
import org.apache.mesos.state.State

class SegmentedSet[T](
    state: State,
    formatter: ValueFormatter[T]) extends PersistentSet[T] {

  // TODO

}

