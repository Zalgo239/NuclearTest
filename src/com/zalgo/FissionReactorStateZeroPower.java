package com.zalgo;

public class FissionReactorStateZeroPower extends FissionReactorStateBase {

    @Override
    public IReactorState getNextState() {
        if (this.controlRodInsertion < this.controlRodThreshold) {
            return new FissionReactorStateRampingUpStart();
        } else {
            return this;
        }
    }

}
