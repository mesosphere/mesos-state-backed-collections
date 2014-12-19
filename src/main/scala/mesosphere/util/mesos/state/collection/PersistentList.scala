package mesosphere.util.mesos.state.collection

/**
  * A persistent ordered list.
  */
trait PersistentList[T] extends PersistentCollection[T] {

  /**
    * Returns a copy of this collection with the supplied item
    * prepended at the head of the list.
    */
  def +:(item: T): PersistentList[T]

  /**
    * Returns a copy of this collection with the supplied item
    * appended to the tail of the list.
    */
  def :+(item: T): PersistentList[T]

  /**
    * Returns a copy of this collection with the supplied items
    * appended to the tail of the list.
    */
  def append(items: Iterable[T]): PersistentList[T]

  /**
    * Returns a copy of this collection with the supplied items
    * appended to the tail of the list.  Alias of `append`.
    */
  def ++=(items: Iterable[T]): PersistentList[T] = this append items

  /**
    * Returns a copy of this collection without the first `n`
    * items.
    */
  def drop(n: Int): PersistentList[T]

  /**
    * Returns a regular Scala collection containing all of the
    * items of this collection.
    */
  def asScala(): List[T]
}

