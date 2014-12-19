package mesosphere.util.mesos.state

import mesosphere.util.mesos.state.collection._

import org.apache.mesos.state.{
  State,
  InMemoryState,
  LevelDBState,
  LogState,
  ZooKeeperState
}

import scala.collection.mutable

trait WrappedState[T] {

  protected def state: State

  protected def formatter: ValueFormatter[T]

  protected def newList(): PersistentList[T]

  protected def newSet(): PersistentSet[T]

  protected def newMap(): PersistentMap[T]

  protected[this] val lists: mutable.Map[String, PersistentList[T]] =
    mutable.Map[String, PersistentList[T]]()

  protected[this] val sets: mutable.Map[String, PersistentSet[T]] =
    mutable.Map[String, PersistentSet[T]]()

  protected[this] val maps: mutable.Map[String, PersistentMap[T]] =
    mutable.Map[String, PersistentMap[T]]()

  def makeList(name: String) = {
    val collection = newList()
    lists += name -> collection
    collection
  }

  def makeSet(name: String) = {
    val collection = newSet()
    sets += name -> collection
    collection
  }

  def makeMap(name: String) = {
    val collection = newMap()
    maps += name -> collection
    collection
  }

  def getList(name: String): Option[PersistentList[T]] =
    this.lists.get(name)

  def getSet(name: String): Option[PersistentSet[T]] =
    this.sets.get(name)

  def getMap(name: String): Option[PersistentMap[T]] =
    this.maps.get(name)
}

object WrappedState {

  def apply[T](
    state: State,
    formatter: ValueFormatter[T]): WrappedState[T] = {
    state match {
      case s: InMemoryState =>
        new SegmentedWrappedState(s, formatter)

      case s: LevelDBState =>
        new SegmentedWrappedState(s, formatter)

      case s: LogState =>
        // new ContiguousWrappedState(s, formatter)
        new SegmentedWrappedState(s, formatter)

      case s: ZooKeeperState =>
        new SegmentedWrappedState(s, formatter)

      case s: State =>
        new SegmentedWrappedState(s, formatter) // possibly not optimal
    }
  }
}

