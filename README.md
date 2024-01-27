# ObjectMapperJSON


### Attempt so far

```java
package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
