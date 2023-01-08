package com.zalgo;

public class FissionReactorStateFullPower extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.fuelDepletion == 0) {
            return new FissionReactorStateShutdown();
        } else if (this.controlRodInsertion > this.controlRodThreshold) {
            return new FissionReactorStateRampDown();
        } else if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else {
            return this;
        }
    }

}
