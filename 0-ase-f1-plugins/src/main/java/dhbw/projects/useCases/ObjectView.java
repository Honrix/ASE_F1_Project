package dhbw.projects.useCases;

import dhbw.projects.actionHandler.UserOptions;
import dhbw.projects.actionHandler.Values;

public class ObjectView implements UserOptions {

    private final Values values;

    public ObjectView (){
        this.values = new Values();
    }

    @Override
    public void initializeOption() {
        this.values.sortedOutput(values.getTrackNames(), "All Tracks");
        this.values.sortedOutput(values.getNationalities(), "All Nations");
        this.values.sortedOutput(values.getTeamNames(), "All Teams");
        this.values.sortedOutput(values.getDriverNames(), "All Drivers");

    }

    @Override
    public String getDescription() {
        return "Show All Objects";
    }

    @Override
    public void closeAction() {

    }
}
