# ObjectMapperJSON

### Problem
Given input then print this output:
```bash
 {type: "PlayerWonGame", "payout":100,"playerOutcome":"WON"}
```

```java
public class Test {
// {"payout":100,"playerOutcome":"WON"}
  // I want:
  // {type: "PlayerWonGame", "payout":100,"playerOutcome":"WON"}
  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();

    PlayerOutcome playerOutcome = PlayerOutcome.WON;
    PlayerWonGame playerWonGame = new PlayerWonGame(100, playerOutcome);
    String jsonString = mapper.writeValueAsString(playerWonGame);

    System.out.println(jsonString);
  }
}
```

### Attempt so far

```java
// only gives {"PlayerWonGame":{"payout":100,"playerOutcome":"WON"}}
@JsonTypeName("PlayerWonGame")
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }

```

