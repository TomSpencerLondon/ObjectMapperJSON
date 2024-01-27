# ObjectMapperJSON

### Problem
Given input:
```java
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }
```

Fetch Output:
```bash
 {type: "PlayerWonGame", "payout":100,"playerOutcome":"WON"}
```

### Attempt so far 
- using ObjectMapper
```java
// only gives {"PlayerWonGame":{"payout":100,"playerOutcome":"WON"}}
@JsonTypeName("PlayerWonGame")
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }

```

### Correct Solution

```java

// gives {"type":"PlayerWonGame","payout":100,"playerOutcome":"WON"}
@JsonTypeName("PlayerWonGame")
@JsonTypeInfo(include = As.PROPERTY, use = Id.NAME, property = "type")
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }
```

### Explanation
We are using Object Mapper to convert Java record objects into Json string but what if I need to add another type into Json without changing my record object.
The above annotations help us to solve this problem. I have used two annotations `@JsonTypeName()` and `@JsonTypeInfo()`.
