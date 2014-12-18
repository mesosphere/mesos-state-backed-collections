package mesosphere.util.mesos.state

import akka.util.ByteString

/**
  * Implements binary (de)serialization for objects of type `T`.
  */
trait ValueFormatter[T] {

  def serialize(value: T): ByteString

  def deserialize(bytes: ByteString): T

}
