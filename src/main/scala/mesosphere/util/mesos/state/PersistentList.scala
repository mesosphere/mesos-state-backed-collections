package mesosphere.util.mesos.state

/**
  * A persistent ordered list.
  */
trait PersistentList[T] extends PersistentCollection[T] {

  /**
    * Returns a copy of this collection with the supplied item
    * prepended at the head of the list.
    */
  def +:(item: T): this.type

  /**
    * Returns a copy of this collection with the supplied item
    * appended to the tail of the list.
    */
  def :+(item: T): this.type

  /**
    * Returns a copy of this collection with the supplied items
    * appended to the tail of the list.
    */
  def append(items: Iterable[T]): this.type

  /**
    * Returns a copy of this collection without the first `n`
    * items.
    */
  def drop(n: Int): this.type

  /**
    * Returns a regular Scala collection containing all of the
    * items of this collection.
    */
  def asScala(): List[T]
}

