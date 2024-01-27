package com.tomspencerlondon;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

// gives {"type":"PlayerWonGame","payout":100,"playerOutcome":"WON"}
@JsonTypeName("PlayerWonGame")
@JsonTypeInfo(include = As.PROPERTY, use = Id.NAME, property = "type")
public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }
