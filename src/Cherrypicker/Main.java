package Cherrypicker;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;

@ScriptManifest(name="Cherrypicker", author = "Niko", logo="", version = 1.0, info = "Joku yritys tehä scriptiä")
public class Main extends Script{

    private Area cherry = new Area(3277, 3360, 3269, 3374);
    private Area puska1 = new Area(3262, 3363, 3266, 3366);



    public void onMessage(Message message) throws java.lang.InterruptedException {
        String txt = message.getMessage().toLowerCase();
        if (txt.contains("there are no berries on this bush at the moment.")) {
            if (!puska1.contains(myPlayer())) {
                if (getWalking().webWalk(puska1)) {
                    new ConditionalSleep(1800, 6000) {
                        @Override
                        public boolean condition() throws InterruptedException {
                            return false;
                        }
                    }.sleep();
                }
            } else {
                RS2Object bush = getObjects().closest("Cadava bush");
                if (bush != null) {
                    if (!myPlayer().isAnimating()) {
                        bush.interact("Pick-from");
                    }

                    getMouse().moveOutsideScreen();

                    sleep(random(2000, 4000));




                }

            }

        }
    }






    @Override
            public int onLoop () throws InterruptedException {
                if (!cherry.contains(myPlayer())) {
                    if (getWalking().webWalk(cherry)) {
                        new ConditionalSleep(1800, 6000) {
                            @Override
                            public boolean condition() throws InterruptedException {
                                return false;
                            }
                        }.sleep();
                    }
                } else {
                    RS2Object bush = getObjects().closest("Cadava bush");
                    if (bush != null) {
                        if (!myPlayer().isAnimating()) {
                            bush.interact("Pick-from");
                            }

                            getMouse().moveOutsideScreen();

                            sleep(random(2000, 4000));




                        }

                    }
        return 602;
    }




    }



