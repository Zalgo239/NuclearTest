package com.zalgo;

public interface IReactorState {

    IReactorState getNextState();

    void performWorldEffects();

    boolean isFailedState();

    void runStateEvolution();

}
