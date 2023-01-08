package com.zalgo;

public class FissionReactorStateRampingUpStart extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.coolantFlowRate < coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else if (this.coolantFlowRate == this.coolantFlowThreshold && this.powerProductionFactor == 0.6) {
            return new FissionReactorStateMidRamp();
        } else if (this.powerProductionFactor > 0.6) {
            return new FissionReactorStateStalling();
        } else if (this.controlRodInsertion > this.controlRodThreshold) {
            return new FissionReactorStateRampDown();
        } else {
            return this;
        }
    }

}
