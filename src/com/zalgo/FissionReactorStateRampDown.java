package com.zalgo;

public class FissionReactorStateRampDown extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.powerProductionFactor <= 0.1) {
            return new FissionReactorStateShutdown();
        } else if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else if (this.controlRodInsertion < this.controlRodThreshold) {
            return new FissionReactorStateStalling();
        } else {
            return this;
        }
    }

}
