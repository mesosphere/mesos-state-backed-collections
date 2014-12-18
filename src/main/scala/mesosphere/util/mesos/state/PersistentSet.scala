package mesosphere.util.mesos.state

/**
  * A persistent set.
  */
trait PersistentSet[T] extends PersistentCollection[T] {

  /**
    * Returns a copy of this collection with the supplied item.
    */
  def +(item: T): PersistentSet[T]

  /**
    * Returns a copy of this collection without the supplied item.
    */
  def -(item: T): PersistentSet[T]

  /**
    * Returns a copy of this collection with the supplied items.
    */
  def ++=(items: Iterable[T]): PersistentSet[T] =
    items.foldLeft(this) { (result, item) =>
      result + item
    }

  /**
    * Returns `true` if the supplied item exists in this
    * collection.
    */
  def contains(item: T): Boolean

  /**
    * Returns a regular Scala collection containing all of the
    * items of this collection.
    */
  def asScala(): Set[T]
}

