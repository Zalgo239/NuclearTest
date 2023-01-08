package com.zalgo;

public class FissionReactorStateStalling extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.neutronPoisonEquilibrium == 1) {
            return new FissionReactorStateStalled();
        } else if (this.controlRodInsertion < this.controlRodThreshold) {
            return new FissionReactorStateRampUpDanger();
        } else if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else {
            return this;
        }
    }

}
