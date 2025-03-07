package com.synerset.hvacengine.process.heating.dataobject;

import com.synerset.hvacengine.process.ConsoleOutputFormatters;
import com.synerset.hvacengine.process.ProcessResult;
import com.synerset.hvacengine.process.ProcessType;
import com.synerset.hvacengine.process.heating.HeatingMode;
import com.synerset.hvacengine.property.fluids.humidair.FlowOfHumidAir;
import com.synerset.unitility.unitsystem.thermodynamic.Power;

/**
 * Represents the result of an air heating process.
 */
public record HeatingResult(ProcessType processType,
                            HeatingMode processMode,
                            FlowOfHumidAir inletAirFlow,
                            FlowOfHumidAir outletAirFlow,
                            Power heatOfProcess) implements ProcessResult {
    @Override
    public String toConsoleOutput() {
        return ConsoleOutputFormatters.heatingConsoleOutput(this);
    }

    public static class Builder {
        private static final ProcessType processType = ProcessType.HEATING;
        private HeatingMode processMode;
        private FlowOfHumidAir inletAirFlow;
        private FlowOfHumidAir outletAirFlow;
        private Power heatOfProcess;

        public Builder processMode(HeatingMode processMode){
            this.processMode = processMode;
            return this;
        }

        public Builder inletAirFlow(FlowOfHumidAir inletAirFlow) {
            this.inletAirFlow = inletAirFlow;
            return this;
        }

        public Builder outletAirFlow(FlowOfHumidAir outletAirFlow) {
            this.outletAirFlow = outletAirFlow;
            return this;
        }

        public Builder heatOfProcess(Power heatOfProcess) {
            this.heatOfProcess = heatOfProcess;
            return this;
        }

        public HeatingResult build() {
            return new HeatingResult(processType, processMode, inletAirFlow, outletAirFlow, heatOfProcess);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

}