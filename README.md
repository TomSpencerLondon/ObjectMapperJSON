# ObjectMapperJSON


### Attempt so far

```java
// only gives {"PlayerWonGame":{"payout":100,"playerOutcome":"WON"}}
@JsonTypeName("PlayerWonGame")
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }

```

