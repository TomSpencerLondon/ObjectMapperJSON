package org.example;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

public record PlayerWonGame(int payout, PlayerOutcome playerOutcome) { }
