package dhbw.projects.useCases;

import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.values.ValuesImpl;

public class ObjectView implements UserOptions {

    private final ValuesImpl valuesImpl;

    public ObjectView (){
        this.valuesImpl = new ValuesImpl();
    }

    @Override
    public void initializeOption() {
        System.out.println(
                this.valuesImpl.getValuesAdapter().sortedOutput(valuesImpl.getTrackNames(), "All Tracks"));
        System.out.println(
                this.valuesImpl.getValuesAdapter().sortedOutput(valuesImpl.getNationalities(), "All Nations"));
        System.out.println(
                this.valuesImpl.getValuesAdapter().sortedOutput(valuesImpl.getTeamNames(), "All Teams"));
        System.out.println(
                this.valuesImpl.getValuesAdapter().sortedOutput(valuesImpl.getDriverNames(), "All Drivers"));

    }

    @Override
    public String getDescription() {
        return "Show All Objects";
    }
}
