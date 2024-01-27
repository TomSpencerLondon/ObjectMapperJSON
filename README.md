# ObjectMapperJSON

### Problem
Given input:
```java
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }
```

Fetch Output:
```bash
 {"type": "PlayerWonGame", "payout":100,"playerOutcome":"WON"}
```

### First Attempt 
Using ObjectMapper:
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
Using these annotations we can specify which attribute to add at what level. 
Firstly, I added the type attribute on the class level with the name as PlayerWonGame for this I used `include = As.WRAPPER_OBJECT`. Hence I got the following output:

```json
{
  "PlayerWonGame": {
    "payout": 100,
    "playerOutcome": "WON"
  }
}
```

I wanted `PlayerWonGame` as the value for a type key inside the object not wrapping it. Hence I used `include = As.PROPERTY`. This provided me with the correct output which I wanted. Here
`@JsonTypeName("PlayerWonGame")` specifies the value for the key which needs to be added and `use = Id.NAME` maps it and the name of the key is provided by `property = "type"`. Hence I got
`type: "PlayerWonGame"`. The final output is below:

```json
{
  "type": "PlayerWonGame",
  "payout": 100,
  "playerOutcome": "WON"
}

```


