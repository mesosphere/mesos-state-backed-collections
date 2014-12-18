package mesosphere.util.mesos.state

import akka.util.ByteString

/**
  * Implements binary (de)serialization for objects of type `T`.
  */
trait ValueFormatter[T] {

  def read(bytes: ByteString): T

  def write(value: T): ByteString

}
