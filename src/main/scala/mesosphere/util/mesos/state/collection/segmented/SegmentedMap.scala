package mesosphere.util.mesos.state.collection.segmented

import mesosphere.util.mesos.state.collection.PersistentMap
import mesosphere.util.mesos.state.ValueFormatter
import org.apache.mesos.state.State

class SegmentedMap[T](
    state: State,
    formatter: ValueFormatter[T]) extends PersistentMap[T] {

  // TODO

}

