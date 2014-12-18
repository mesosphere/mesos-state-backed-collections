package mesosphere.util.mesos.state

trait WrappedState[T] {

  def formatter: ValueFormatter[T]

  protected[this] var collections: Map[String, PersistentCollection[T]]

  def makeList(name: String): PersistentList[T]
  def makeSet(name: String): PersistentSet[T]
  def makeMap(name: String): PersistentMap[T]

  def getList(name: String): Option[PersistentList[T]]
  def getSet(name: String): Option[PersistentSet[T]]
  def getMap(name: String): Option[PersistentMap[T]]

}

