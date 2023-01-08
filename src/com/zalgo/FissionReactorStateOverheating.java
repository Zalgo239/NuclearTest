package com.zalgo;

public class FissionReactorStateOverheating extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.temperature > this.maxTemperature) {
            return new FissionReactorStateMeltdown();
        } else if (this.coolantFlowRate >= coolantFlowThreshold) {
            return new FissionReactorStateRampingUpStart();
        } else if (this.controlRodInsertion > this.controlRodThreshold) {
            return new FissionReactorStateRampDown();
        } else {
            return this;
        }
    }

}
