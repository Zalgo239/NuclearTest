package com.zalgo;

public class FissionReactorStateBase implements IReactorState {

    protected float roomTemperature;

    protected float temperature;
    protected float pressure;
    protected float controlRodInsertion;
    protected float fuelDepletion;
    protected float coolantFlowRate;
    protected float voidFactor;
    protected float powerProductionFactor;
    protected float neutronPoisonEquilibrium;

    protected float maxTemperature;
    protected float controlRodThreshold;
    protected float coolantFlowThreshold;
    protected float pressureThreshold;

    @Override
    public IReactorState getNextState() {
        return this;
    }

    @Override
    public void performWorldEffects() {}

    @Override
    public boolean isFailedState() {
        return false;
    }

    @Override
    public void runStateEvolution() {}

    public boolean isExplosionPossible() {
        return this.voidFactor > 0;
    }

}
