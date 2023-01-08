package com.zalgo;

public class FissionReactorStateEndRamp extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else if (this.controlRodInsertion == this.controlRodThreshold && this.powerProductionFactor == 1) {
            return new FissionReactorStateFullPower();
        } else if(this.controlRodInsertion > this.controlRodThreshold) {
            return new FissionReactorStateRampDown();
        } else {
            return this;
        }
    }

}
