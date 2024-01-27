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

