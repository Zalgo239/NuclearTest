package com.zalgo;

public class FissionReactorStateStalled extends FissionReactorStateBase {

    @Override
    public IReactorState getNextState() {
        if (this.neutronPoisonEquilibrium == 0 && this.controlRodInsertion == this.controlRodThreshold) {
            return new FissionReactorStateRampingUpStart();
        } else if (this.neutronPoisonEquilibrium == 0 && this.controlRodInsertion == 1) {
            return new FissionReactorStateOFF();
        } else if (this.controlRodInsertion < this.controlRodThreshold) {
            return new FissionReactorStateRampUpDanger();
        } else if (this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateOverheating();
        } else {
            return this;
        }
    }

}
