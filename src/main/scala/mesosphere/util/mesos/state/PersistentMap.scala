package mesosphere.util.mesos.state

/**
  * A persistent map providing efficient lookup of values by key.
  */
trait PersistentMap[T] extends PersistentCollection[T] {

  /**
    * Returns an iterator over all of the keys in this collection.
    */
  def keys(): Iterable[String]

  /**
    * Returns the set of all keys in this collection.
    */
  def keySet(): Set[String]

  /**
    * Returns `true` if the supplied item exists in this
    * collection.
    */
  def contains(item: T): Boolean

  /**
    * Returns `true` if the supplied item exists in this
    * collection.
    */
  def containsKey(key: String): Boolean

  /**
    * Returns the optional mapped value for the supplied key.
    */
  def get(key: String): Option[T]

  /**
    * Returns a copy of this collection with the supplied mapping.
    */
  def +(mapping: (String, T)): this.type

  /**
    * Returns a copy of this collection without a mapping for the
    * supplied key.
    */
  def -(key: String): this.type

  /**
    * Returns a regular Scala collection containing all of the
    * items of this collection.
    */
  def asScala(): Map[String, T]

}

