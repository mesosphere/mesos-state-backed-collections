# Mesos State Backed Collections

Persistent collection types backed by implementations of the Mesos state
API.

## API Usage Example (work-in-progress)

```scala
import akka.util.ByteString
import mesosphere.util.mesos.state.{ PersistentSet, WrappedState }
import org.apache.mesos.state.AbstractState
import scala.concurrent.Future

val state: AbstractState = // ...

case class Person(name: String, age: Int)

val personFormatter = new Formatter[Person] {
  def read(bytes: ByteString): Person = // ...
  def write(value: Person): ByteString = // ...
}

val wrappedState = WrappedState(state, formatter)

val people: PersistentSet[Person] = wrappedState.makeSet("people")

people ++= Seq(Person("Wayne", 23), Person("Garth", 24))

val result: Future[Try[Unit]]] = people.commit()
```

## Implemented Collection Types

- List
- Set
- String-keyed map

### Collection storage schemes

- Contiguous
- Segmented

