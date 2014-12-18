package mesosphere.util.mesos.state

/**
  * A persistent set.
  */
trait PersistentSet[T] extends PersistentCollection[T] {

  /**
    * Returns a copy of this collection with the supplied item.
    */
  def +(item: T): this.type

  /**
    * Returns a copy of this collection without the supplied item.
    */
  def -(item: T): this.type

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

