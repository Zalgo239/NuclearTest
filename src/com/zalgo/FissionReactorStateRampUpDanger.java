package com.zalgo;

public class FissionReactorStateRampUpDanger extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {
        if (this.isExplosionPossible() && this.controlRodInsertion == 1 && this.coolantFlowRate < this.coolantFlowThreshold) {
            return new FissionReactorStateExplosion();
        } else if (this.controlRodInsertion < 1) {
            return new FissionReactorStateMeltdown();
        } else  if (this.controlRodInsertion == 1) {
            return new FissionReactorStateStalled();
        } else {
            return this;
        }
    }

}
