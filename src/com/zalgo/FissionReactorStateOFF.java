package com.zalgo;

public class FissionReactorStateOFF extends FissionReactorStateBase{

    @Override
    public IReactorState getNextState() {

        if (this.controlRodInsertion <= this.controlRodThreshold) {

            //Control rods withdrawn but not enough coolant flow or pressure -> Overheating
            if (this.coolantFlowRate < this.coolantFlowThreshold || this.pressure < this.pressureThreshold) {
                return new FissionReactorStateOverheating();
            }
            //Control rods withdrawn but poison still present -> Stalling
            if (this.neutronPoisonEquilibrium > 0) {
                return new FissionReactorStateStalling();
            }
            return new FissionReactorStateZeroPower();
        }

        return this;
    }

    @Override
    public void runStateEvolution() {
        this.neutronPoisonEquilibrium -= this.neutronPoisonEquilibrium/10;
        this.temperature -= Math.abs(this.temperature - this.roomTemperature)/10;
    }
}
