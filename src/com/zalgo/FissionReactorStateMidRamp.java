package com.zalgo;

public class FissionReactorStateMidRamp extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else if (this.controlRodInsertion < this.controlRodThreshold && this.neutronPoisonEquilibrium <= 0) {
            return new FissionReactorStateEndRamp();
        } else if (this.controlRodInsertion < this.controlRodThreshold && this.neutronPoisonEquilibrium > 0) {
            return new FissionReactorStateStalling();
        } else if (this.controlRodInsertion > this.controlRodThreshold) {
            return new FissionReactorStateRampDown();
        } else {
            return this;
        }
    }

}
