package mesosphere.util.mesos.state.collection

import scala.concurrent.Future
import scala.util.Try

/**
  * Parent type of all state-backed collections.
  */
trait PersistentCollection[T] {

  /**
    * Returns `true` if this collection has unsaved changes.
    */
  def hasUncommittedChanges(): Boolean

  /**
    * Returns the future result of commiting the enqueued changes
    * to the backing store.
    */
  def commit(): Future[Try[Unit]]

  /**
    * Returns an iterator over the items in this collection.
    */
  def iterator(): Iterator[T]

}

