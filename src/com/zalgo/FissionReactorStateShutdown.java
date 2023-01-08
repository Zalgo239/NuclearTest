package com.zalgo;

public class FissionReactorStateShutdown extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else if (this.powerProductionFactor == 0) {
            return new FissionReactorStateOFF();
        } else {
            return this;
        }
    }

}
